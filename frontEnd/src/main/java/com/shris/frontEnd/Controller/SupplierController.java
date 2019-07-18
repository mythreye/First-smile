package com.shris.frontEnd.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shris.backEndConnectivity.DAO.MySellerDAO;
import com.shris.backEndConnectivity.DAO.MysiteCredentialsDAO;
import com.shris.backEndConnectivity.model.MySeller;
import com.shris.backEndConnectivity.model.MysiteCredentials;

@Controller

public class SupplierController {

	@Autowired
	MySellerDAO mysellerdao;

	@Autowired
	MysiteCredentialsDAO mysitecredentialdao;

	@Autowired
	MailSending mailsupplier;

	@RequestMapping("/registration")
	public String registrationPage(Model m) {
		m.addAttribute("registrationPage", true);
		m.addAttribute("mySellerAttr", new MySeller());
		m.addAttribute("haserror", false);
		m.addAttribute("error", "");
		m.addAttribute("edit", false);
		return "index";
	}

	@RequestMapping("/addSeller")
	public String addSellerPage(@Valid @ModelAttribute("mySellerAttr") MySeller mySeller, BindingResult bres, Model m) {
		if (bres.hasErrors()) {
			m.addAttribute("registrationPage", true);
			m.addAttribute("mySellerAttr", mySeller);
			m.addAttribute("haserror", true);
			m.addAttribute("showmess", false);
			m.addAttribute("message", "");
			m.addAttribute("edit", false);
			m.addAttribute("error", "Please check ur data");
			return "index";

		} else {
			try {
				BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
				mySeller.setSellerpassword(bCryptPasswordEncoder.encode(mySeller.getSellerpassword()));
				if (mysellerdao.insertSeller(mySeller)) {
					// Mail sending
					String subject = "Thanks for Registering.";
					String messgae = "Thanks for your interest in my concern. Our team members will get back shortly.";
					mailsupplier.sendMail(mySeller.getSelleremail(), subject, messgae);

					String subject_admin = "Request from " + mySeller.getSellername() + "";
					String messgae_admin = "Dear team, \n\n\n We got quote from " + mySeller.getSellername() + " in  "
							+ mySeller.getSellercity() + "";
					mailsupplier.sendMail("firstsmiles240207@gmail.com", subject_admin, messgae_admin);

				}
				m.addAttribute("registrationPage", true);
				m.addAttribute("haserror", true);
				m.addAttribute("showmess", true);
				m.addAttribute("edit", false);
				m.addAttribute("message", "Your registered succesfully.Our team will get back soon.");
				return "redirect:thankyou";
			} catch (Exception e) {
				m.addAttribute("registrationPage", true);
				m.addAttribute("haserror", true);
				m.addAttribute("showmess", true);
				m.addAttribute("edit", false);
				m.addAttribute("message", "Your cannot registered due to some technical issue. Please try again.");
				System.out.println(e.getMessage());
				return "redirect:thankyou";
			}
		}
	}

	@RequestMapping("/thankyou")
	public String thankyouPage(Model m) {
		m.addAttribute("thankyouPage", true);
		m.addAttribute("error", false);
		m.addAttribute("message", "");
		return "index";
	}

	@RequestMapping("/admin/viewSeller")
	public String viewSellerPage(Model m) {
		m.addAttribute("viewSellerPage", true);
		m.addAttribute("allSeller", mysellerdao.SelectAllSeller());
		List<MysiteCredentials> mysitecredential = mysitecredentialdao.SelectAllSellerCredential();
		m.addAttribute("allSellercreditinal", mysitecredential);
		m.addAttribute("edit", false);
		return "index";
	}

	@RequestMapping("/admin/ativateSeller")
	public String activateSellerMail(@RequestParam("email") String email, Model m) {
		try {
			m.addAttribute("viewSellerPage", true);
			m.addAttribute("haserror", true);
			m.addAttribute("showmess", true);
			m.addAttribute("message", "Activated successfuly");
			String subject = "Your Account Activated.";
			String message = "Dear Member, \n\nYour account is activated now. Now you can please login and add your products.\n\nRegards,\nAdmin";
			mailsupplier.sendMail(email, subject, message);
			mysellerdao.updateStatus(email);
			m.addAttribute("allSeller", mysellerdao.SelectAllSeller());
			List<MysiteCredentials> mysitecredential = mysitecredentialdao.SelectAllSellerCredential();
			m.addAttribute("allSellercreditinal", mysitecredential);
			m.addAttribute("edit", false);
			return "index";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			m.addAttribute("viewSellerPage", true);
			m.addAttribute("haserror", false);
			m.addAttribute("showmess", false);
			m.addAttribute("edit", false);
			return "index";
		}
	}

	@RequestMapping("/admin/deactivateSeller")
	public String deactivateSellerMail(@RequestParam("id") int id, @RequestParam("email") String email, Model m) {
		try {
			if (mysellerdao.deleteSeller(id)) {
				String subject = "Your Account De-Activated.";
				String message = "Dear Member, \n\n Your account is De-activated now. Please contact our admin.\n\nRegards,\nAdmin";
				mailsupplier.sendMail(email, subject, message);
				m.addAttribute("haserror", true);
				m.addAttribute("showmess", true);
				m.addAttribute("message", "De-Activated successfuly");
				m.addAttribute("viewSellerPage", true);
				m.addAttribute("allSeller", mysellerdao.SelectAllSeller());
				List<MysiteCredentials> mysitecredential = mysitecredentialdao.SelectAllSellerCredential();
				m.addAttribute("allSellercreditinal", mysitecredential);
				m.addAttribute("edit", false);
			} else {
				m.addAttribute("haserror", true);
				m.addAttribute("showmess", true);
				m.addAttribute("message", "unable to delete");
				m.addAttribute("viewSellerPage", true);
				m.addAttribute("allSeller", mysellerdao.SelectAllSeller());
				List<MysiteCredentials> mysitecredential = mysitecredentialdao.SelectAllSellerCredential();
				m.addAttribute("allSellercreditinal", mysitecredential);
				m.addAttribute("edit", false);

			}
			return "index";

		} catch (Exception e) {
			m.addAttribute("haserror", true);
			m.addAttribute("showmess", true);
			m.addAttribute("message", "unable to delete");
			m.addAttribute("viewSellerPage", true);
			m.addAttribute("allSeller", mysellerdao.SelectAllSeller());
			List<MysiteCredentials> mysitecredential = mysitecredentialdao.SelectAllSellerCredential();
			m.addAttribute("allSellercreditinal", mysitecredential);
			m.addAttribute("edit", false);
			return "index";
		}
	}

	@RequestMapping("/seller/sellerprofile")
	public String sellerprofilePage(HttpSession httpsession, Model m) {
		m.addAttribute("registrationPage", true);
		m.addAttribute("edit", true);
		m.addAttribute("haserror", false);
		m.addAttribute("error", "");
		m.addAttribute("mySellerAttr",
				mysellerdao.SelectOneSellerID(Integer.parseInt(httpsession.getAttribute("sellerid").toString())));
		m.addAttribute("Credential", mysitecredentialdao.SelectAllSellerCredential());
		return "index";
	}

	@RequestMapping("/seller/updateSeller")
	public String updateSellerPage(@Valid @ModelAttribute("mySellerAttr") MySeller mySeller, BindingResult bres,
			Model m) {

		if (bres.hasErrors()) {

			m.addAttribute("registrationPage", true);
			m.addAttribute("mySellerAttr", mySeller);
			m.addAttribute("haserror", true);
			m.addAttribute("showmess", false);			
			m.addAttribute("edit", true);
			m.addAttribute("error", "Please check ur data");
			m.addAttribute("message", "");
			System.out.println(bres.toString());
			return "index";

		} else {
			try {
				mysellerdao.updateSeller(mySeller);
				m.addAttribute("registrationPage", true);
				m.addAttribute("haserror", false);
				m.addAttribute("showmess", true);
				m.addAttribute("edit", true);
				m.addAttribute("message", "Details are updated successfully.");
				return "index";

			} catch (Exception e) {
				m.addAttribute("registrationPage", true);
				m.addAttribute("haserror", true);
				m.addAttribute("showmess", false);
				m.addAttribute("edit", true);
				m.addAttribute("message", "");
				m.addAttribute("error", "Your details are not updated due to technical issue.");
				return "index";
			}
		}

	}
}
