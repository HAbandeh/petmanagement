package com.cobra.petmanagement.controllers;

import com.cobra.petmanagement.exceptions.NotFoundException;
import com.cobra.petmanagement.model.Owner;
import com.cobra.petmanagement.services.OwnersService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/owners")
public class OwnersController {

    private final String LIST_OWNERS_HTML_PAGE = "/owners/list";
    private final String VIEW_OWNER_HTML_PAGE = "/owners/ownerdetails";
    private final String OWNERS_FORM = "/owners/ownerform";

    private final OwnersService ownersService;

    public OwnersController(OwnersService ownersService) {
        this.ownersService = ownersService;
    }

    @RequestMapping("/list")
    public String listOfOwners(Model model){

        model.addAttribute("owners",this.ownersService.getOwners());
        return LIST_OWNERS_HTML_PAGE;
    }

    @RequestMapping("/{id}/view")
    public String viewOwner(@PathVariable String id, Model model){

        Owner owner = this.ownersService.findById(Long.valueOf(id));

        model.addAttribute("owner",owner);
        return VIEW_OWNER_HTML_PAGE;
    }

    @RequestMapping("/{id}/edit")
    public String editOwner(@PathVariable String id, Model model){

        Owner owner = this.ownersService.findById(Long.valueOf(id));
        model.addAttribute("owner",owner);
        return OWNERS_FORM;
    }

    @RequestMapping("/new")
    public String newOwner( Model model){

        model.addAttribute("owner",new Owner());
        return OWNERS_FORM;
    }

    @PostMapping
    public String save(Owner owner, Model model){

        Owner savedOwner = this.ownersService.save(owner);
//        model.addAttribute("owner",savedOwner);
        return "redirect:/owners/" + savedOwner.getId() + "/view";
    }


    @RequestMapping("/{id}/delete")
    public String deleteOwner(@PathVariable String id, Model model){

        this.ownersService.deleteById(Long.valueOf(id));
        //model.addAttribute("owners",this.ownersService.findById(Long.valueOf(id)));
        return "redirect:" + LIST_OWNERS_HTML_PAGE;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // without this the code will make the response 200
    public ModelAndView handleNotFound(Exception e){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404notfound");
        modelAndView.addObject("exception", e);
        return modelAndView;
    }

    // to avoid writing this multiple times we are moving to ContollerExceptionHandler
//    @ExceptionHandler(NumberFormatException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND) // without this the code will make the response 200
//    public ModelAndView handleNumberFormatException(Exception e){
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("404notfound");
//        modelAndView.addObject("exception", e);
//        return modelAndView;
//    }

}
