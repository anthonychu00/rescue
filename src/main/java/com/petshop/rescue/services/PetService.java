package com.petshop.rescue.services;

import com.petshop.rescue.models.Pet;
import com.petshop.rescue.models.PetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetDAO petDAO;

    public void save(Pet pet){
        petDAO.save(pet);
    }

    public Pet findById(Long id){
        Pet pet = petDAO.findById(id).get();
        return pet;
    }

    public List<Pet> findByAnimalType(String animalType){
        List<Pet> results = petDAO.findByAnimalType(animalType);

        return results;
    }

    public List<Pet> findByAllFields(Date dateArrived, String animalType, int age){
        List<Pet> results = petDAO.findByDateArrivedAndAnimalTypeAndAge(dateArrived, animalType, age);

        return results;
    }
}
