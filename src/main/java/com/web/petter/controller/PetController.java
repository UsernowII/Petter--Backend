package com.web.petter.controller;

import com.web.petter.model.Pet;
import com.web.petter.service.api.FileService;
import com.web.petter.service.api.PetServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetServiceAPI petServiceAPI;

    @Autowired
    private FileService fileService;

    @GetMapping("/find/all")
    public List<Pet> readPets() {
        return petServiceAPI.getAll();
    }


    @GetMapping("/find/{id}")
    public Pet readPet(@PathVariable int id) {
        return petServiceAPI.get(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        Pet obj = petServiceAPI.save(pet);
        return new ResponseEntity<Pet>(obj, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Pet> deleteCustomer(@PathVariable int id) {
        Pet pet = petServiceAPI.get(id);
        if (pet != null) {
            petServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Pet>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Pet>(pet, HttpStatus.OK);
    }

    @PostMapping("/upload-file")
    public ResponseEntity uploadFile(@RequestParam(value = "file", required = false) MultipartFile file) {

        fileService.process(file);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
