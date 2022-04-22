package com.cobra.petmanagement.services;

import com.cobra.petmanagement.model.Pet;

public interface PetService {

    public Pet findById(long id);

    public Pet save(Pet pet);
}
