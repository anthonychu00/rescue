package com.petshop.rescue.services;

import com.petshop.rescue.models.Pet;
import com.petshop.rescue.models.PetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetDAO petDAO;

    public void save(Pet pet){
        petDAO.save(pet);
    }

    public List<Pet> findByAllFields(Pet pet){
        Pageable pageable = PageRequest.of(0, 5);
        Page<Pet> results = petDAO.findAll(pet, pageable);
        return results.getContent();
    }
}
