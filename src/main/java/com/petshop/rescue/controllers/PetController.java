package com.petshop.rescue.controllers;

import com.petshop.rescue.models.Pet;
import com.petshop.rescue.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PetController implements WebMvcConfigurer {

    //autowire some adoption system?
    @Autowired
    PetService petService;

    @GetMapping("/")
    public String showFormOrigin(Pet pet){
        return "pet-form";
    }

    @GetMapping("/results")
    public String showForm(Pet pet){
        return "pet-form";
    }

    @PostMapping("/results")
    public String getSearchResults(Model model, @ModelAttribute @Valid Pet pet, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "pet-form";
        }
        List<Pet> results = petService.findByAllFields(pet.getDateArrived(), pet.getAnimalType(), pet.getAge());
        model.addAttribute("results", results);
        return "pet-form";
    }
}
