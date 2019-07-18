package com.shris.frontEnd.Controller;

import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shris.backEndConnectivity.DAO.ChangePasswordDAO;
import com.shris.backEndConnectivity.DAO.MyCustomerDAO;
import com.shris.backEndConnectivity.DAO.MySellerDAO;
import com.shris.backEndConnectivity.DAO.MysiteCredentialsDAO;
import com.shris.backEndConnectivity.model.ChangePassword;
import com.shris.backEndConnectivity.model.MyCustomer;
import com.shris.backEndConnectivity.model.MySeller;
import com.shris.backEndConnectivity.model.MysiteCredentials;




@Controller
public class LoginController {

	@Autowired
	MyCustomerDAO cutomerdao;
	@Autowired
	MySellerDAO sellerdao;
	@Autowired
	ChangePasswordDAO changepwddao;
	@Autowired
	MysiteCredentialsDAO mysitecredentialdao;
	@Autowired
	private MailSending mailsupplier;

	@RequestMapping("/login")
	String loginPage(Model m) {

		m.addAttribute("haserror", false);
		m.addAttribute("error", "");
		m.addAttribute("loginPage", true);
		return "index";
	}

	@RequestMapping("/flogin")
	String floginPage(Model m) {

		m.addAttribute("haserror", true);
		m.addAttribute("error", "check UserName and password");
		m.addAttribute("loginPage", true);
		return "index";
	}

	@RequestMapping("/loginsuccess")
	String loginsuccess(HttpSession httpSession) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals("ROLE_USER")) {
				MyCustomer customer = cutomerdao.SelectOneCustomer(email);
				httpSession.setAttribute("useremail", email);
				httpSession.setAttribute("usercartid", customer.getCustomerid());
				httpSession.setAttribute("username", customer.getCustomername());
				httpSession.setAttribute("userlogin", true);
				httpSession.setAttribute("sellerlogin", false);
				if(httpSession.getAttribute("pid")!=null)
				{
				int pid=Integer.parseInt(httpSession.getAttribute("pid").toString()); 
				return "redirect:/user/addCart?pid="+pid;	
				}
				else {
				return "redirect:/user/ViewAllProduct";}
			} else if (authority.getAuthority().equals("ROLE_SELLER")) {
				MySeller seller = sellerdao.SelectOneSeller(email);
				httpSession.setAttribute("useremail", email);
				httpSession.setAttribute("sellerid", seller.getSellerid());
				httpSession.setAttribute("username", seller.getSellername());
				httpSession.setAttribute("sellerlogin", true);
				httpSession.setAttribute("userlogin", false);
				return "redirect:/seller/product";
			} else {
				httpSession.setAttribute("useremail", email);
				httpSession.setAttribute("username", "Administrator");
				httpSession.setAttribute("sellerlogin", false);
				httpSession.setAttribute("userlogin", false);
				return "redirect:/admin/addCategory";
			}
		}
		return "";
	}

	@RequestMapping( {"/user/changepassword" , "/admin/changepassword" ,"/seller/changepassword"})
	public String changepasswordPage(Model m) {
		m.addAttribute("changepasswordPage", true);
		m.addAttribute("chngepwd", new ChangePassword());
		return "index";
	}

	@RequestMapping(value = "/chgepwd", method = RequestMethod.POST)
	public String chgepwd(@ModelAttribute("chngepwd") ChangePassword chngepwd, HttpSession httpsession, Model m) {

		System.out.println(chngepwd.getOldpassword());
		System.out.println(chngepwd.getNewpassword());
		m.addAttribute("changepasswordPage", true);
		m.addAttribute("chngepwd", chngepwd);
		System.out.println(httpsession.getAttribute("useremail"));

		String email = (String) httpsession.getAttribute("useremail");

		BCryptPasswordEncoder bCryptPasswordEncoder1 = new BCryptPasswordEncoder();
		String oldpwd = chngepwd.getOldpassword();
		String newpwd = chngepwd.getNewpassword();

		System.out.println("----Encryption----");

		MysiteCredentials mysitecredential = mysitecredentialdao.SelectPassword(email);

		if (bCryptPasswordEncoder1.matches(chngepwd.getOldpassword(), mysitecredential.getCredentialpassword())) {
			System.out.println("Match");

			mysitecredential.setCredentialpassword(bCryptPasswordEncoder1.encode(newpwd));
			mysitecredential.setCredentialemail(mysitecredential.getCredentialemail());
			mysitecredential.setCredentialrole(mysitecredential.getCredentialrole());
			mysitecredential.setCredentialstatus(mysitecredential.isCredentialstatus());
			mysitecredentialdao.updatepassword(mysitecredential);
			m.addAttribute("haserror", true);
			m.addAttribute("error", "password updated successfully");
		} else {
			System.out.println("Not match");
			m.addAttribute("haserror", true);
			m.addAttribute("error", "old password incorrect");

		}

		return "index";
	}

	@RequestMapping("/forgetpassword")
	public String forgetPasswordPage(Model m) {
		m.addAttribute("forgetPasswordPage", true);

		return "index";
	}

	@RequestMapping("/emailValiation")
	public String emailValidation(@RequestParam("email") String email, Model m) throws InterruptedException {
		m.addAttribute("forgetPasswordPage", true);
		m.addAttribute("emailValidation", true);
		MysiteCredentials mysitecredential = mysitecredentialdao.SelectOneUser(email);
		System.out.println("email valid"+mysitecredential.getCredentialemail());
		if (mysitecredential.getCredentialemail()!= null) {

			String token = mailsupplier.generateToken();
			String subject = "Requesting for password";
			String messgae = "Hi Member, \n\n. Please click here for resetting password.\n\n Your password is :"
					+ token;
		    mailsupplier.sendMail(email, subject, messgae);
			
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			MysiteCredentials mysitecredential1 = mysitecredentialdao.SelectOneUser(email);
			mysitecredential.setCredentialpassword(bCryptPasswordEncoder.encode(token));
			mysitecredential.setCredentialemail(mysitecredential.getCredentialemail());
			mysitecredential.setCredentialrole(mysitecredential1.getCredentialrole());
			mysitecredential.setCredentialstatus(mysitecredential1.isCredentialstatus());			
			mysitecredentialdao.updatepassword(mysitecredential);

		} else {
			String subject = "Requesting for password";
			String messgae = "Hi Member, \n\n. You are not registered in First Smile. Can you please register .";
			mailsupplier.sendMail(email, subject, messgae);
		}
		return "index";
	}

}
