package com.cobra.petmanagement.controllers;

import com.cobra.petmanagement.model.Owner;
import com.cobra.petmanagement.services.OwnersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        //model.addAttribute("owners",this.ownersService.findById(Long.valueOf(id)));
        return "redirect:" + LIST_OWNERS_HTML_PAGE;
    }

}
