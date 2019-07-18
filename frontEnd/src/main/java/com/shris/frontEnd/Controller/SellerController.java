package com.shris.frontEnd.Controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shris.backEndConnectivity.DAO.MyProductDAO;
import com.shris.backEndConnectivity.DAO.OrdersDAO;
import com.shris.backEndConnectivity.model.MyProduct;
import com.shris.backEndConnectivity.model.Orders;



@Controller
public class SellerController {

	@Autowired
	OrdersDAO ordersdao;

	@Autowired
	MyProductDAO productdao;
	
	@Autowired
	private MailSending mailsupplier;

	@RequestMapping("/seller/approveseller")
	public String approvesellerPage(HttpSession session, Model m) {
		m.addAttribute("approvesellerPage", true);
		List<MyProduct> product = productdao
				.SelectbySeller(Integer.parseInt(session.getAttribute("sellerid").toString()));
		Iterator<MyProduct> iprod = product.listIterator();
		Orders o = new Orders();
		while (iprod.hasNext()) {
			MyProduct prod = (MyProduct) iprod.next();
			List<Orders> orders = ordersdao.selectbySeller(prod.getProductId());
			Iterator<Orders> iorder = orders.listIterator();
			while (iorder.hasNext()) {
				Orders orders2 = (Orders) iorder.next();

				if (orders2.getProduct().getProductId() == prod.getProductId()) {
					m.addAttribute("prodlist", ordersdao.selectbySeller(prod.getProductId()));
				}

			}

		}

		return "index";
	}
	
	@RequestMapping("/seller/approve")
	public String approvePage(@RequestParam("id") String id, Model m)
	{
		m.addAttribute("approvesellerPage", true);
		Orders order = ordersdao.SelectOneOrder(id);
		order.setOrderState("Shipped");
		if(ordersdao.updateStatus(order)) {
		//Mail to Customer with orderid for shipped
		String orderid = order.getOrderId();
		String productname = order.getProduct().getProductName();
		String customeremail = order.getCustomer().getCustomeremail();
		String customername = order.getCustomer().getCustomername();
		String subject = "Your "+orderid+" is Shipped";
		String message = "Hi "+customername+" \n\n Your Product:"+productname+" is shipped.\n\nRegards,\nFirstSmile Team";
		mailsupplier.sendMail(customeremail, subject, message);
		}
		m.addAttribute("haserror", true);
		m.addAttribute("message", "Order approved successfully");
		return "redirect:approveseller";
	}
	
	@RequestMapping("/seller/disapprove")
	public String disapprovePage(@RequestParam("id") String id, Model m)
	{
		m.addAttribute("approvesellerPage", true);
		Orders order = ordersdao.SelectOneOrder(id);
		order.setOrderState("Cancelled");
		if(ordersdao.updateStatus(order)) {
		//Mail to Customer with orderid for cancel the product
			String orderid = order.getOrderId();
			String productname = order.getProduct().getProductName();
			String customeremail = order.getCustomer().getCustomeremail();
			String customername = order.getCustomer().getCustomername();
			String subject = "Your "+orderid+" is Cancelled";
			String message = "Hi "+customername+" \n\n Your Product:"+productname+" is cancelled due to some other reason. Futher please conatct our admin.\n\nRegards,\nFirstSmile Team";
			mailsupplier.sendMail(customeremail, subject, message);
		}
		m.addAttribute("haserror", true);
		m.addAttribute("message", "Order disapproved successfully");
		return "redirect:approveseller";
	}
	

	@RequestMapping("/admin/approveadmin")
	public String adminapprovePage(HttpSession session, Model m) {
		m.addAttribute("adminapprovePage", true);
		List<MyProduct> product = productdao.SelectAllProductUser();
				
		Iterator<MyProduct> iprod = product.listIterator();
		Orders o = new Orders();
		while (iprod.hasNext()) {
			MyProduct prod = (MyProduct) iprod.next();
			List<Orders> orders = ordersdao.selectbyadmin();
			Iterator<Orders> iorder = orders.listIterator();
			while (iorder.hasNext()) {
				Orders orders2 = (Orders) iorder.next();

				if (orders2.getProduct().getProductId() == prod.getProductId()) {
					m.addAttribute("prodlist", ordersdao.selectbyadmin());
				}

			}

		}

		return "index";
	}
	
	@RequestMapping("/admin/deleivred")
	public String deleivredPage(@RequestParam("id") String id, Model m)
	{
		Orders order = ordersdao.SelectOneOrder(id);
		order.setOrderState("Delivered");
		if(ordersdao.updateStatus(order))
		{
		//Mail to Customer with orderid for delivered the product
			String orderid = order.getOrderId();
			String productname = order.getProduct().getProductName();
			String customeremail = order.getCustomer().getCustomeremail();
			String customername = order.getCustomer().getCustomername();
			String subject = "Your "+orderid+" is Delivered";
			String message = "Hi "+customername+" \n\n Your Product:"+productname+" is Delivered. If not please conatct our admin.\n\nRegards,\nFirstSmile Team";
			mailsupplier.sendMail(customeremail, subject, message);
		}
		m.addAttribute("haserror", true);
		m.addAttribute("message", "Order approved successfully");
		return "redirect:approveadmin";
	}
}
