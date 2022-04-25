package com.cobra.petmanagement.services;

import com.cobra.petmanagement.exceptions.NotFoundException;
import com.cobra.petmanagement.model.Owner;
import com.cobra.petmanagement.repositories.OwnersRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class OwnersServiceImpl implements  OwnersService{

    private OwnersRepo ownersRepo;

    public OwnersServiceImpl(OwnersRepo ownersRepo){
        this.ownersRepo = ownersRepo;
    }

    public Iterable<Owner> getOwners(){
        return this.ownersRepo.findAll();
    }

    @Override
    public Owner findById(long id) {
        Optional<Owner> ownerOptional = this.ownersRepo.findById(id);

        if(!ownerOptional.isPresent()){
            throw new NotFoundException("Owner not found ! ID: " + id);
        }
        return ownerOptional.orElse(null);
    }

    @Override
    public  void deleteById(long id) {
         this.ownersRepo.deleteById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return this.ownersRepo.save(owner);
    }
}
