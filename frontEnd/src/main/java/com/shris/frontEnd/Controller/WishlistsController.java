package com.shris.frontEnd.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shris.backEndConnectivity.DAO.MyCustomerDAO;
import com.shris.backEndConnectivity.DAO.MyProductDAO;
import com.shris.backEndConnectivity.DAO.WishlistDAO;
import com.shris.backEndConnectivity.model.MyProduct;
import com.shris.backEndConnectivity.model.Wishlist;

@Controller
public class WishlistsController {

	@Autowired
	WishlistDAO wishlistdao;

	@Autowired
	MyProductDAO productdao;

	@Autowired
	MyCustomerDAO customerdao;

	@RequestMapping("/user/wishlist")
	public String wishlistPage(HttpSession session, Model m) {
		m.addAttribute("wishlistPage", true);
		m.addAttribute("wishList",
				wishlistdao.selectWishList(Integer.parseInt((session.getAttribute("usercartid").toString()))));
		return "index";
	}

	@RequestMapping("/user/addwishlist")
	public String addwishlistPage(@RequestParam("id") int id, HttpSession session, Model m) {
		MyProduct p = productdao.SelectOneProduct(id);
		if (session.getAttribute("usercartid") != null) {
			Wishlist wishlist = new Wishlist();
			wishlist.setProductid(p);
			wishlist.setCustomerid(customerdao.SelectOneCustomer(session.getAttribute("useremail").toString()));
			wishlistdao.insertWishlist(wishlist);
			m.addAttribute("msg", true);
			return "redirect:/ViewAllProduct";
		} else {
			session.setAttribute("id", id);
			return "redirect:/login";
		}

	}

	@RequestMapping("/user/removewishlist")
	public String removewishlistPage(@RequestParam("id") int id, Model m) {
		m.addAttribute("wishlistPage", true);
		wishlistdao.deleteWishlist(id);
		return "index";
	}

}
