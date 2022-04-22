package com.cobra.petmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private static final String HOME_PAGE = "index";

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getHomePage(){
        return HOME_PAGE;
    }

}
