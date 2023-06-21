package com.example.demo.controllers;

import com.example.demo.models.Pet;
import com.example.demo.services.PetService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController {
    private PetService petService;

    public PetController(PetService petService){
        this.petService = petService;
    }

    @CrossOrigin
    @GetMapping("api/Pet")
    public List<Pet> getAllPets(){
        return this.petService.getAllPets();
    }
}
