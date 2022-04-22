package com.cobra.petmanagement.repositories;

import com.cobra.petmanagement.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnersRepo extends CrudRepository<Owner, Long> {
}
