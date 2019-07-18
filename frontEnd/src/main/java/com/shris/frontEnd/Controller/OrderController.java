package com.shris.frontEnd.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shris.backEndConnectivity.DAO.AddressDAO;
import com.shris.backEndConnectivity.DAO.CartDAO;
import com.shris.backEndConnectivity.DAO.MyCustomerDAO;
import com.shris.backEndConnectivity.DAO.MyProductDAO;
import com.shris.backEndConnectivity.DAO.OrdersDAO;
import com.shris.backEndConnectivity.model.Cart;
import com.shris.backEndConnectivity.model.MyProduct;
import com.shris.backEndConnectivity.model.Orders;


@Controller
@RequestMapping("/user")
public class OrderController {

	@Autowired
	MyCustomerDAO mycustomerdao;

	@Autowired
	MyProductDAO myproductdao;

	@Autowired
	CartDAO CartDAO;

	@Autowired
	AddressDAO addressdao;

	@Autowired
	OrdersDAO orderdao;

	@RequestMapping("/checkout")
	public String cartOrderPage(@RequestParam("addid") int addid, HttpSession session) {
		ArrayList<Cart> c = (ArrayList<Cart>) CartDAO
				.SelectCart(Integer.parseInt(session.getAttribute("usercartid").toString()));
		Iterator<Cart> ic = c.listIterator();
		while (ic.hasNext()) {
			Cart cart = (Cart) ic.next();
			Orders o = new Orders();
			String s = "OD".concat(String.valueOf(UUID.randomUUID().getMostSignificantBits()).substring(0, 12).replace("-","4"));
			o.setOrderId(s);
			o.setAddress(addressdao.SelectOneAddress(addid));
			o.setCustomer(mycustomerdao.SelectOneCustomer(session.getAttribute("useremail").toString()));
			o.setProduct(cart.getProduct());
			o.setQty(cart.getQuantity());
			o.setPrice(cart.getTotalprice());
			o.setDate(new Date());
			o.setOrderState("Ordered");
			if (orderdao.insertOrder(o)) {
				MyProduct p = myproductdao.SelectOneProduct(cart.getProduct().getProductId());
				p.setProuctQuantity(p.getProuctQuantity() - cart.getQuantity());
				myproductdao.updateProduct(p);
				CartDAO.deleteOneCart(cart.getItemid());
			}

		}
		return "redirect:/ViewAllProduct";
		//return "redirect:/viewAllOrders";
		
	}
	
	@RequestMapping("/viewAllOrders")
	public String viewOrders(Model m,HttpSession session)
	{
		m.addAttribute("cartOrderPage", true);
		m.addAttribute("ordercart",
				orderdao.selectAllOrders(Integer.parseInt(session.getAttribute("usercartid").toString())));
			return "index";
	}
	
	@RequestMapping("/viewReceipt")
	public String viewReceiptPage(@RequestParam("oid") String oid ,Model m)
	{
		m.addAttribute("viewReceiptPage", true);
		m.addAttribute("orderDetail",orderdao.SelectOneOrder(oid));
		return "index";
	}
	

}
