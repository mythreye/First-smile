package com.shris.frontEnd.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
	
	@RequestMapping("/srtxt")
	public String searchPage(@RequestParam("searchTXT") String searchTXT , Model m)
	{
		
		return "index";
	}

}
