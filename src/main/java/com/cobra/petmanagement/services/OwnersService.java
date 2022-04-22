package com.cobra.petmanagement.services;

import com.cobra.petmanagement.model.Owner;

public interface OwnersService {

    public Iterable<Owner> getOwners();

    public Owner findById(long id);

    public void deleteById(long id);

    public Owner save(Owner owner);
}
