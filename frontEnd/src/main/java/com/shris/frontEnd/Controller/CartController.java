package com.shris.frontEnd.Controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shris.backEndConnectivity.DAO.CartDAO;
import com.shris.backEndConnectivity.DAO.MyCustomerDAO;
import com.shris.backEndConnectivity.DAO.MyProductDAO;
import com.shris.backEndConnectivity.model.Cart;
import com.shris.backEndConnectivity.model.MyProduct;

@Controller
public class CartController {

	@Autowired
	CartDAO cartdao;
	@Autowired
	MyCustomerDAO custdao;
	@Autowired
	MyProductDAO proddao;

	double calctotal(int id) {
		double tot = 0;
		ArrayList<Cart> c = (ArrayList<Cart>) cartdao.SelectCart(id);
		Iterator<Cart> ic = c.listIterator();
		while (ic.hasNext()) {
			Cart cart = (Cart) ic.next();
			tot = tot + cart.getTotalprice();
		}

		return tot;

	}

	@RequestMapping({"/user/addCart" , "/addCart"})
	public String addToCartPage(@RequestParam("pid") int pid, HttpSession session, Model m) {
		if (session.getAttribute("usercartid") != null) {
			MyProduct p = proddao.SelectOneProduct(pid);
			ArrayList<Cart> c = (ArrayList<Cart>) cartdao
					.SelectCart(Integer.parseInt(session.getAttribute("usercartid").toString()));
			if (c.isEmpty()) {
				Cart mycart = new Cart();
				mycart.setCustomer(custdao.SelectOneCustomer(session.getAttribute("useremail").toString()));
				mycart.setProduct(p);
				mycart.setQuantity(1);
				mycart.setTotalprice(p.getProductPrice());
				cartdao.insertCart(mycart);
			} else {
				int flag = 0;
				Iterator<Cart> cartiterator = c.listIterator();
				while (cartiterator.hasNext()) {
					Cart cart = cartiterator.next();
					if (cart.getProduct().getProductId() == pid) {
						int qty = cart.getQuantity() + 1;
						if (qty > 5 && qty>p.getProuctQuantity()) {

							m.addAttribute("cartList", cartdao
									.SelectCart(Integer.parseInt(session.getAttribute("usercartid").toString())));
							m.addAttribute("total",
									calctotal(Integer.parseInt(session.getAttribute("usercartid").toString())));
							m.addAttribute("addToCartPage", true);
							m.addAttribute("error", true);
							m.addAttribute("proid", pid);
							return "index";

						} else {
							cart.setQuantity(qty);
							double price = proddao.SelectOneProduct(pid).getProductPrice() * cart.getQuantity();
							cart.setTotalprice(price);
							cartdao.updatecart(cart);
							flag = 1;
						}
					}
				}
				if (flag == 0) {
					Cart mycart = new Cart();
					mycart.setCustomer(custdao.SelectOneCustomer(session.getAttribute("useremail").toString()));
					mycart.setProduct(p);
					mycart.setQuantity(1);
					mycart.setTotalprice(p.getProductPrice());
					cartdao.insertCart(mycart);
				} else
					flag = 0;
			}
			return "redirect:/user/viewAllCart";

		} else {
			session.setAttribute("pid", pid);
			return "redirect:/login";
		}
	}

	@RequestMapping("/user/removeitem")
	public String removeItem(@RequestParam("itemid") int itemid, Model m) {
		cartdao.deleteOneCart(itemid);
		return "redirect:/user/viewAllCart";
	}

	@RequestMapping("/user/edititem")
	public String editItem(@RequestParam("itemid") int itemid, Model m, HttpSession session,
			HttpServletRequest request) {
		Cart c = cartdao.SelectOneCart(itemid);
		int qnty = Integer.parseInt(request.getParameter("upqty").toString());
		System.out.println(qnty);
		System.out.println(c.getProduct().getProuctQuantity());
		if (qnty > 5 ) {
			 
			m.addAttribute("cartList",
					cartdao.SelectCart(Integer.parseInt(session.getAttribute("usercartid").toString())));
			m.addAttribute("total", calctotal(Integer.parseInt(session.getAttribute("usercartid").toString())));
			m.addAttribute("addToCartPage", true);
			m.addAttribute("error", true);
			
			m.addAttribute("proid", c.getProduct().getProductId());
			return "index";
		}
		else if( qnty>c.getProduct().getProuctQuantity()) {
			m.addAttribute("cartList",
					cartdao.SelectCart(Integer.parseInt(session.getAttribute("usercartid").toString())));
			m.addAttribute("total", calctotal(Integer.parseInt(session.getAttribute("usercartid").toString())));
			m.addAttribute("addToCartPage", true);
			m.addAttribute("msg", true);
			m.addAttribute("proid", c.getProduct().getProductId());
			return "index";
		}
		else {
		
			c.setQuantity(qnty);
			c.setTotalprice(qnty * c.getProduct().getProductPrice());
			System.out.println(c.getQuantity() + "" + c.getTotalprice() + "" + c.getItemid());
			cartdao.updatecart(c);
			return "redirect:/viewAllCart";

		}
	}

	@RequestMapping("/user/viewAllCart")
	public String viewAllCartPage(Model m, HttpSession session) {
		m.addAttribute("cartList", cartdao.SelectCart(Integer.parseInt(session.getAttribute("usercartid").toString())));
		m.addAttribute("total", calctotal(Integer.parseInt(session.getAttribute("usercartid").toString())));
		m.addAttribute("error", false);
		m.addAttribute("proid", 0);
		m.addAttribute("addToCartPage", true);
		return "index";
	}

}
