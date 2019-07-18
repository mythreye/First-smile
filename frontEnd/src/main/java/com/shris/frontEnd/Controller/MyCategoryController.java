package com.shris.frontEnd.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shris.backEndConnectivity.DAO.MyCategoryDAO;
import com.shris.backEndConnectivity.model.MyCategory;



@Controller
@RequestMapping("/admin")
public class MyCategoryController {

	@Autowired
	MyCategoryDAO mycategorydao;

	@RequestMapping("/addCategory")
	public String addCategoryPage(Model m) {
		m.addAttribute("addCategoryPage", true);
		m.addAttribute("myCategory", new MyCategory());
		m.addAttribute("edit",false);
		m.addAttribute("allCategory", mycategorydao.SelectAllCateogory());
		m.addAttribute("haserror", false);
		
		m.addAttribute("error", "");

		return "index";
	}

	@RequestMapping("/addnewcaegory")
	public String addCategoryNewPage(@Valid @ModelAttribute("myCategory") MyCategory mycategory, BindingResult bres,
			Model m) 
	{
			if (bres.hasErrors()) {
				m.addAttribute("addCategoryPage", true);
				m.addAttribute("myCategory",mycategory);
				m.addAttribute("edit",false);
				m.addAttribute("allCategory", mycategorydao.SelectAllCateogory());
				m.addAttribute("haserror", false);
				m.addAttribute("error", "Pls Check Data");

			return "index";
		} else {
			try {
				mycategorydao.insertCategory(mycategory);
				return "redirect:/addCategory";
			} catch (Exception e) {
				m.addAttribute("myCategory", mycategory);
				m.addAttribute("addCategoryPage", true);
				m.addAttribute("allCategory", mycategorydao.SelectAllCateogory());
				m.addAttribute("haserror", true);
				m.addAttribute("error", "Data already present.Please check your data.");
				return "index";

			}
		}
	}

	@RequestMapping("/editCategory")
	public String editCategoryPage(@RequestParam int categoryid , @Valid @ModelAttribute("myCategory") MyCategory mycategory , BindingResult bres , Model m) 
	{
		m.addAttribute("addCategoryPage", true);		
		m.addAttribute("myCategory", mycategorydao.SelectOneCategory(categoryid));
		m.addAttribute("allCategory", mycategorydao.SelectAllCateogory());
		m.addAttribute("haserror", false);
		m.addAttribute("error", "");
		m.addAttribute("edit",true);
		return "index";
	}
	
	@RequestMapping("/editexistcaegory")
	public String editCategoryNewPage(@Valid @ModelAttribute("myCategory") MyCategory mycategory, BindingResult bres,
			Model m) 
	{
			if (bres.hasErrors()) {
				m.addAttribute("addCategoryPage", true);
				m.addAttribute("myCategory", mycategory);
				m.addAttribute("allCategory", mycategorydao.SelectAllCateogory());
				m.addAttribute("haserror", false);
				m.addAttribute("edit",true);
				m.addAttribute("error", "Please check data");
			return "index";
		} else {
			try {
				System.out.println(mycategory.getCategoryname());
				mycategorydao.updateCategory(mycategory);
				return "redirect:/addCategory";
			} catch (Exception e) {
				m.addAttribute("addCategoryPage", true);
				m.addAttribute("myCategory", new MyCategory());
				m.addAttribute("allCategory", mycategorydao.SelectAllCateogory());
				m.addAttribute("haserror", false);
				m.addAttribute("edit",true);
				m.addAttribute("error", "Data already present.Please check your data.");
				return "index";

			}
		}
	}
	
	@RequestMapping("/deleteCategory")
	public String deleteCategoryPage(@RequestParam("categoryid") int categoryid, Model m )
	{
		
		if(mycategorydao.deleteCategry(categoryid))
		{
			m.addAttribute("haserror", true);
			m.addAttribute("edit",true);
			m.addAttribute("error", "Deleted Success");	
		}
		else
		{
			m.addAttribute("haserror", true);
			m.addAttribute("edit",true);
			m.addAttribute("error", "This Category product is in used.So we cant delete the category.");
		}
		return "redirect:/addCategory";
		
	}

}
