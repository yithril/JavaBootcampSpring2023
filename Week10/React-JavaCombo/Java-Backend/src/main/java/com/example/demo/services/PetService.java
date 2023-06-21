package com.example.demo.services;

import com.example.demo.dao.PetRepository;
import com.example.demo.models.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private PetRepository petRepository;

    public PetService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets(){
        return this.petRepository.findAll();
    }
}
