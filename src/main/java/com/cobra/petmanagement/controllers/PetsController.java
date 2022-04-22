package com.cobra.petmanagement.controllers;

import com.cobra.petmanagement.model.Owner;
import com.cobra.petmanagement.model.Pet;
import com.cobra.petmanagement.services.OwnersService;
import com.cobra.petmanagement.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetsController {

    private static final String PET_DETAILS = "/pets/petdetails";

    private final String PET_FORM = "/pets/petform";

    private final PetService petService;
    private final OwnersService ownersService;

    public PetsController(PetService petService, OwnersService ownersService) {
        this.petService = petService;
        this.ownersService = ownersService;
    }


    @RequestMapping("/{ownerId}/{petId}/view")
    public String getPetDetails(@PathVariable String ownerId, @PathVariable String petId, Model model){

        model.addAttribute("pet", this.petService.findById(Long.valueOf(petId)));
        return PET_DETAILS;

    }

    @RequestMapping("/{petId}/edit")
    public String editPet(@PathVariable String petId, Model model){
        model.addAttribute("pet", this.petService.findById(Long.valueOf(petId)));
        model.addAttribute("owner", this.petService.findById(Long.valueOf(petId)).getOwner());
        return PET_FORM;
    }

    @RequestMapping("/{ownerId}/add")
    public String addPet(@PathVariable String ownerId, Model model){
        Owner owner = this.ownersService.findById(Long.valueOf(ownerId));
        System.out.println("****************************");
        System.out.println(owner.getId());
        System.out.println("****************************");
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return PET_FORM;
    }

//    @ModelAttribute("owner_id")
//    public Owner findOwner(@PathVariable("owner_id") String owner_id) {
//        System.out.println("&&&&&&&&&&&&&&&");
//
//        return this.ownersService.findById(Long.valueOf(owner_id));
//    }

    @PostMapping("/{owner_Id}/save")
    public String save(@PathVariable("owner_Id") String owner_Id, Pet pet, Model model){

        Owner owner = this.ownersService.findById(Long.valueOf(owner_Id));

        Pet savedPet = null;

        if(pet.getId() == null || pet.getId() == 0){

            pet.setOwner(owner);
            this.petService.save(pet);
            owner.getPets().add(pet);
            savedPet = pet;
        } else {

            for(Pet p: owner.getPets()){
                if(p.getId() == pet.getId()){
                    p.setName(pet.getName());
                    p.setAge(pet.getAge());
                    this.ownersService.save(owner);
                    savedPet = p;
                    break;
                }
            }

        }

       // return "redirect:/pets/" + owner_Id + "/" + savedPet.getId() + "/view";
        return "redirect:/owners/" + owner_Id  + "/view";
    }

}
