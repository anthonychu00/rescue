package com.petshop.rescue.models;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PetDAO extends PagingAndSortingRepository<Pet, Long> {
    //Spring Data repositories parse the method name, using the criteria defined after
    //"by" to  construct a query, with criteria separated by And and Or
    List<Pet> findByDateArrivedAndAnimalTypeAndAge(Date dateArrived, String animalType, int age);
    List<Pet> findByAnimalType(String animalType);
}