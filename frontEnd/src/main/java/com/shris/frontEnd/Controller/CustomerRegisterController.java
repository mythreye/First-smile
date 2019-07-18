package com.shris.frontEnd.Controller;

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

import com.shris.backEndConnectivity.DAO.MyCustomerDAO;
import com.shris.backEndConnectivity.DAO.MysiteCredentialsDAO;
import com.shris.backEndConnectivity.model.MyCustomer;
import com.shris.backEndConnectivity.model.MySeller;





@Controller
public class CustomerRegisterController {

	@Autowired
	private MailSending mail;

	@Autowired
	MyCustomerDAO mycustomerdao;
	
	@Autowired
	MysiteCredentialsDAO mysitedao;

	@RequestMapping("/register")
	String registerPage(Model m) {
		m.addAttribute("registerPage", true);
		m.addAttribute("myCustomer", new MyCustomer());
		m.addAttribute("haserror", false);
		m.addAttribute("error", "");
		m.addAttribute("showmess", false);
		m.addAttribute("message", "");
		m.addAttribute("edit" , false);
		return "index";
	}

	@RequestMapping("/addcustomer")
	String customerPage(@Valid @ModelAttribute("myCustomer") MyCustomer mycustomer, BindingResult br, Model m) {
		if (br.hasErrors()) {
			m.addAttribute("registerPage", true);
			m.addAttribute("myCustomer", mycustomer);
			m.addAttribute("haserror", true);
			m.addAttribute("error", "Please Check all data");
			m.addAttribute("showmess", false);
			m.addAttribute("message", "");
			m.addAttribute("edit" , false);
			return "index";

		} else {
			try {
				BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
				mycustomer.setCustomerpassword(bCryptPasswordEncoder.encode(mycustomer.getCustomerpassword()));
				if (mycustomerdao.insertCustomer(mycustomer)) {
					m.addAttribute("registerPage", true);
					m.addAttribute("myCustomer", new MyCustomer());
					m.addAttribute("haserror", false);
					m.addAttribute("error", "");
					String subject = "Thanks for Registering";
					String message = "Click Here to Validate your email id\n\n\n  http://localhost:8080/frontEnd/validateemail?emailid="
							+ mycustomer.getCustomeremail();
					System.out.println(mycustomer.getCustomeremail());
					mail.sendMail(mycustomer.getCustomeremail(), subject, message);
				}
				m.addAttribute("showmess", true);
				m.addAttribute("edit" , false);
				m.addAttribute("message", "Your registered succesfully. Please check your mail for verification.");
				return "index";
			} catch (Exception e1) {
				m.addAttribute("registerPage", true);
				m.addAttribute("myCustomer", mycustomer);
				m.addAttribute("haserror", true);
				m.addAttribute("error", "Data already present.Please check your data.");
				m.addAttribute("showmess", false);
				m.addAttribute("message", "");
				m.addAttribute("edit" , false);
				return "index";
			}
		}

	}

	@RequestMapping("/user/userprofile")
	public String userprofilePage(HttpSession httpsession ,Model m)
	{
		m.addAttribute("registerPage", true);
		m.addAttribute("edit" , true);
		m.addAttribute("haserror", false);
		m.addAttribute("error", "");		
		m.addAttribute("myCustomer", mycustomerdao.SelectOneCustomer(httpsession.getAttribute("useremail").toString()));
		m.addAttribute("Credential", mysitedao.SelectOneUser(httpsession.getAttribute("useremail").toString()));
		return  "index";
	}
	
	@RequestMapping("/user/updateUser")
	public String updateSellerPage(@Valid @ModelAttribute("myCustomer") MyCustomer mycustomer, BindingResult bres , Model m)
	{
		
		if (bres.hasErrors()) {
			
			m.addAttribute("registerPage", true);
			m.addAttribute("myCustomer", mycustomer);
			m.addAttribute("haserror", true);
			m.addAttribute("showmess", false);			
			m.addAttribute("edit", true);
			m.addAttribute("error", "Please check ur data");
			m.addAttribute("message", "");
			System.out.println(bres.toString());
			return "index";

		} else 
		{
			try
			{
				mycustomerdao.updateCustomer(mycustomer);
				m.addAttribute("registerPage", true);
				m.addAttribute("haserror", true);
				m.addAttribute("showmess", false);			
				m.addAttribute("edit", true);
				m.addAttribute("error", "Please check ur data");
				m.addAttribute("message", "");
				System.out.println(bres.toString());
				return "index";
				
			}catch (Exception e) {
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


	
	@RequestMapping("/validateemail")
	String verfiyemail(@RequestParam("emailid") String email, Model M) {
		
		M.addAttribute("thankyouPage", true);
		M.addAttribute("error", true);
		
		if (mycustomerdao.verifyemail(email)) {
			M.addAttribute("message", "email id validated");
		} else {
			
			M.addAttribute("message", "Email id already validated");
		}

		return "index";

	}

}
