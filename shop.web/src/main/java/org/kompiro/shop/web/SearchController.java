package org.kompiro.shop.web;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/search.htm")
public class SearchController {

	@RequestMapping(method = RequestMethod.GET)
	public String showSearchForm(String searchString, ModelMap model) {
		System.out.println("SearchController.showSearchForm()");
	if(searchString != null) return doSearch(searchString, model);
	return "searchForm" ;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doSearch(String searchString, ModelMap model) {
		return "searchResults";
	}
	
}
