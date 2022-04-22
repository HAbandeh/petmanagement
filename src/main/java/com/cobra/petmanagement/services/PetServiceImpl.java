package com.cobra.petmanagement.services;

import com.cobra.petmanagement.model.Pet;
import com.cobra.petmanagement.repositories.PetsRepo;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements  PetService{

    private PetsRepo petsRepo;

    public PetServiceImpl(PetsRepo petsRepo){
        this.petsRepo = petsRepo;
    }
    @Override
    public Pet findById(long id) {
        return this.petsRepo.findById(id).orElse(null);
    }


    @Override
    public Pet save(Pet pet) {
        return this.petsRepo.save(pet);
    }
}
