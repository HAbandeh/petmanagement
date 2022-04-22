package com.cobra.petmanagement.repositories;

import com.cobra.petmanagement.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetsRepo extends CrudRepository<Pet, Long> {
}
