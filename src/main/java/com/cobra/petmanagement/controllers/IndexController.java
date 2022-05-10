package com.cobra.petmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cobra.petmanagement.services.LogginService;


@Controller
public class IndexController {

	private LogginService loggingService;
	
	@Autowired // no need for the autowired in constructor injection
	public IndexController(LogginService loggingService) {
		this.loggingService = loggingService;
	}
	
    private static final String HOME_PAGE = "index";

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getHomePage(){
    	this.loggingService.log("I am here");
        return HOME_PAGE;
    }

}
