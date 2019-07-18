package com.shris.frontEnd.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shris.backEndConnectivity.DAO.AddressDAO;
import com.shris.backEndConnectivity.model.Address;




@Controller
@RequestMapping("/user")
public class AddressController {

	@Autowired
	AddressDAO addressdao;

	@RequestMapping("/shippingAddress")
	public String shippingAddressPage(HttpSession session, Model m) {
		m.addAttribute("shippingAddressPage", true);
		m.addAttribute("addShippingAddress", new Address());
		ArrayList<Address> addressObj = (ArrayList<Address>) addressdao
				.SelectAddress(Integer.parseInt(session.getAttribute("usercartid").toString()));
		m.addAttribute("myaddress", addressObj);
		m.addAttribute("haserror", false);
		m.addAttribute("error", null);
		m.addAttribute("edit", false);
		return "index";
	}

	@RequestMapping("/addaddress")
	public String addaddress(@Valid @ModelAttribute("addShippingAddress") Address address, BindingResult bres, Model m,
			HttpSession session) {
		if (bres.hasErrors()) {
			m.addAttribute("shippingAddressPage", true);
			m.addAttribute("addShippingAddress", address);
			ArrayList<Address> addressObj = (ArrayList<Address>) addressdao
					.SelectAddress(Integer.parseInt(session.getAttribute("usercartid").toString()));
			m.addAttribute("myaddress", addressObj);
			m.addAttribute("haserror", true);
			m.addAttribute("error", "Pls Check Data");
			m.addAttribute("edit", false);
			return "index";
		} else {
			try {
				addressdao.insertAddress(address);
				return "redirect:/shippingAddress";
			} catch (Exception e) {
				m.addAttribute("shippingAddressPage", true);
				m.addAttribute("addShippingAddress", address);
				ArrayList<Address> addressObj = (ArrayList<Address>) addressdao
						.SelectAddress(Integer.parseInt(session.getAttribute("usercartid").toString()));
				m.addAttribute("myaddress", addressObj);
				m.addAttribute("haserror", true);
				m.addAttribute("error", "Pls Check Data");
				m.addAttribute("edit", false);
				return "index";

			}
		}
	}

	@RequestMapping("/editaddress")
	public String editaddress(@RequestParam("addid") int id, Model m, HttpSession session) {
		m.addAttribute("shippingAddressPage", true);
		m.addAttribute("addShippingAddress", addressdao.SelectOneAddress(id));
		ArrayList<Address> addressObj = (ArrayList<Address>) addressdao
				.SelectAddress(Integer.parseInt(session.getAttribute("usercartid").toString()));
		m.addAttribute("myaddress", addressObj);
		m.addAttribute("haserror", false);
		m.addAttribute("error", null);
		m.addAttribute("edit", true);
		return "index";
	}

	@RequestMapping("/updateaddress")
	public String updateaddress(@Valid @ModelAttribute("addShippingAddress") Address address, BindingResult bres,
			Model m, HttpSession session) {
		if (bres.hasErrors()) {
			m.addAttribute("shippingAddressPage", true);
			m.addAttribute("addShippingAddress", address);
			ArrayList<Address> addressObj = (ArrayList<Address>) addressdao
					.SelectAddress(Integer.parseInt(session.getAttribute("usercartid").toString()));
			m.addAttribute("myaddress", addressObj);
			m.addAttribute("haserror", true);
			m.addAttribute("error", "Pls Check Data");
			m.addAttribute("edit", true);
			return "index";
		} else {
			try {
				addressdao.updateAddress(address);
				return "redirect:/shippingAddress";
			} catch (Exception e) {
				m.addAttribute("shippingAddressPage", true);
				m.addAttribute("addShippingAddress", address);
				ArrayList<Address> addressObj = (ArrayList<Address>) addressdao
						.SelectAddress(Integer.parseInt(session.getAttribute("usercartid").toString()));
				m.addAttribute("myaddress", addressObj);
				m.addAttribute("haserror", true);
				m.addAttribute("error", "Pls Check Data");
				m.addAttribute("edit", true);
				return "index";

			}
		}
	}

	@RequestMapping("/deleteaddress")
	public String deleteAddress(@RequestParam("addid") int id, Model m) {
		addressdao.deleteOneAddress(id);
		return "redirect:/shippingAddress";
	}

}
