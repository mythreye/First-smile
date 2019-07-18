package com.shris.frontEnd.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {
	@RequestMapping({ "/", "/home" })
	String indexPage(Model m) {
		m.addAttribute("title", "First-Smile");
		m.addAttribute("indexPage", true);
		return "index";
	}

	@RequestMapping("/aboutus")
	String aboutusPage(Model m) {
		m.addAttribute("aboutusPage", true);
		return "index";
	}


	@RequestMapping("/contactus")
	String contactusPage(Model m) {
		m.addAttribute("contactusPage", true);
		return "index";
	}

}
