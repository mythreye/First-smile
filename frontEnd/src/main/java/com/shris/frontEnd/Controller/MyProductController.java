package com.shris.frontEnd.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shris.backEndConnectivity.DAO.MyCategoryDAO;
import com.shris.backEndConnectivity.DAO.MyCustomerDAO;
import com.shris.backEndConnectivity.DAO.MyProductDAO;
import com.shris.backEndConnectivity.DAO.MySellerDAO;
import com.shris.backEndConnectivity.DAO.WishlistDAO;
import com.shris.backEndConnectivity.model.MyCategory;
import com.shris.backEndConnectivity.model.MyProduct;


@Controller

public class MyProductController {

	@Autowired
	MyProductDAO myproductdao;

	@Autowired
	MyCategoryDAO mycategorydao;

	@Autowired
	MySellerDAO mysellerdao;
	
	@Autowired
	WishlistDAO wishlistdao;

	void addimage(MultipartFile f, int id) {
		try {
			String path = "C:\\Users\\kalai\\project\\frontEnd\\src\\main\\webapp\\resources\\productimage\\";
			path = path + String.valueOf(id) + ".jpg";
			if (!f.isEmpty()) {
				byte[] imagebytes = f.getBytes();
				File x = new File(path);
				if (x.exists()) {
					x.delete();
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				} else {
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				}
			}
			Thread.sleep(5000);
		} catch (Exception e) {

		}

	}
	
	void deleteimage(int id)
	{
		try
		{
			String path = "C:\\Users\\kalai\\project\\frontEnd\\src\\main\\webapp\\resources\\productimage\\";
			path = path + String.valueOf(id) + ".jpg";
			File x = new File(path);
			if(x.exists())
			{
				x.delete();
			}
		}catch (Exception e) {
			System.out.println("File not exist");
		}
		
	}

	@RequestMapping("/seller/product")
	public String productviewPage(HttpSession httpSession, Model m) {
		m.addAttribute("productviewPage", true);
		// m.addAttribute("allProduct", myproductdao.SelectAllProduct());
		List<MyCategory> myCategory = mycategorydao.SelectAllCateogory();
		m.addAttribute("Categories", myCategory);
		m.addAttribute("myProduct", new MyProduct());
		List<MyProduct> allProduct = myproductdao
				.SelectAllProduct(Integer.parseInt(httpSession.getAttribute("sellerid").toString()));
		m.addAttribute("allProduct", allProduct);
		m.addAttribute("edit", false);
		return "index";
	}

	@RequestMapping("/seller/addnewproduct")
	public String addProductPage(HttpSession httpSession, @Valid @ModelAttribute("myProduct") MyProduct myProduct,
			BindingResult bres, Model m, HttpServletRequest request) {
		if (bres.hasErrors()) {
			m.addAttribute("productviewPage", true);
			m.addAttribute("haserror", false);
			m.addAttribute("edit", false);
			List<MyCategory> myCategory = mycategorydao.SelectAllCateogory();
			m.addAttribute("Categories", myCategory);
			m.addAttribute("myProduct", myProduct);
			List<MyProduct> allProduct = myproductdao
					.SelectAllProduct(Integer.parseInt(httpSession.getAttribute("sellerid").toString()));
			m.addAttribute("allProduct", allProduct);
			m.addAttribute("error", "Pls Check Data");

			return "index";
		} else {
			try {
				myproductdao.insertProduct(myProduct);
				addimage(myProduct.getImage(), myProduct.getProductId());

				return "redirect:/product";

			} catch (Exception e) {
				m.addAttribute("productviewPage", true);
				m.addAttribute("haserror", true);
				m.addAttribute("edit", false);
				List<MyCategory> myCategory = mycategorydao.SelectAllCateogory();
				m.addAttribute("Categories", myCategory);
				List<MyProduct> allProduct = myproductdao
						.SelectAllProduct(Integer.parseInt(httpSession.getAttribute("sellerid").toString()));
				m.addAttribute("allProduct", allProduct);
				m.addAttribute("error", "Please check your data.");
				return "index";

			}

		}

	}

	@RequestMapping("/seller/updateProduct")
	public String editproductPage(HttpSession httpSession, @RequestParam int pid,
			@Valid @ModelAttribute("myProduct") MyProduct myproduct, BindingResult bres, Model m) {

		m.addAttribute("productviewPage", true);
		m.addAttribute("haserror", false);
		m.addAttribute("edit", true);
		List<MyCategory> myCategory = mycategorydao.SelectAllCateogory();
		m.addAttribute("Categories", myCategory);
		MyProduct myProduct = myproductdao.SelectOneProduct(pid);
		m.addAttribute("myProduct", myProduct);
		List<MyProduct> allProduct = myproductdao
				.SelectAllProduct(Integer.parseInt(httpSession.getAttribute("sellerid").toString()));
		m.addAttribute("allProduct", allProduct);

		return "index";

	}

	@RequestMapping("/seller/updateexistProduct")
	public String editexistproductPage(HttpSession httpSession, @Valid @ModelAttribute("myProduct") MyProduct myProduct,
			BindingResult bres, Model m) {
		if (bres.hasErrors()) {
			m.addAttribute("productviewPage", true);
			m.addAttribute("haserror", false);
			m.addAttribute("edit", true);
			List<MyCategory> myCategory = mycategorydao.SelectAllCateogory();
			m.addAttribute("Categories", myCategory);
			m.addAttribute("myProduct", myProduct);
			List<MyProduct> allProduct = myproductdao
					.SelectAllProduct(Integer.parseInt(httpSession.getAttribute("sellerid").toString()));
			m.addAttribute("allProduct", allProduct);
			m.addAttribute("error", "Pls Check Data");

			return "index";
		} else {
			try {
				myproductdao.updateProduct(myProduct);
				addimage(myProduct.getImage(), myProduct.getProductId());
				return "redirect:/product";
			} catch (Exception e) {
				m.addAttribute("productviewPage", true);
				m.addAttribute("haserror", true);
				m.addAttribute("edit", false);
				List<MyCategory> myCategory = mycategorydao.SelectAllCateogory();
				m.addAttribute("Categories", myCategory);
				m.addAttribute("myProduct", myProduct);
				List<MyProduct> allProduct = myproductdao
						.SelectAllProduct(Integer.parseInt(httpSession.getAttribute("sellerid").toString()));
				m.addAttribute("allProduct", allProduct);
				m.addAttribute("error", "Please check your data.");
				return "index";
			}
		}

	}

	@RequestMapping({"/ViewAllProduct" ,"/user/ViewAllProduct"})
	public String viewAllProductPage(HttpSession httpSession, Model m) {
		m.addAttribute("viewAllProductPage", true);
		m.addAttribute("msg", false);
		List<MyCategory> myCategory = mycategorydao.SelectAllCateogory();	
		m.addAttribute("Categories", myCategory);
		List<MyProduct> allProduct = myproductdao
				.SelectAllProductUser();		
		m.addAttribute("allProduct", allProduct);
		if (httpSession.getAttribute("usercartid") != null)
		{
		m.addAttribute("wishlist", wishlistdao.selectWishList(Integer.parseInt(httpSession.getAttribute("usercartid").toString())));
		}
		return "index";
	}
	
	@RequestMapping({"/cateproduct" , "/user/cateproduct"})
	public String cateproductPage(@RequestParam("cid") int cid , Model m)
	{
		m.addAttribute("viewAllProductPage", true);
		List<MyCategory> myCategory = mycategorydao.SelectAllCateogory();	
		m.addAttribute("Categories", myCategory);
		m.addAttribute("allProduct", myproductdao.SelectbyCategory(cid));
		return "index";
	}
	
	@RequestMapping({"/viewProduct" , "/user/viewProduct"})
	public String viewOneProductPage(@RequestParam int id, Model m) {
		m.addAttribute("viewOneProductPage", true);

		MyProduct oneProduct = myproductdao.SelectOneProduct(id);
		m.addAttribute("myProduct", oneProduct);
		return "index";
	}

	@RequestMapping("/seller/deleteProduct")
	public String deleteProductPage(@RequestParam("pid") int pid, Model m) {
		myproductdao.deleteProduct(pid);
		deleteimage(pid);
		return "redirect:/product";
	}

}
