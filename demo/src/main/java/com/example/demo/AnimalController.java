package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java
 * This controller defines all REST API endpoints for managing Animal objects.
 */
@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Retrieve a list of all Animal records in the database.
     * Endpoint: GET http://localhost:8080/animals/all
     *
     * @return a list of all Animal objects.
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return service.getAllAnimals();
    }

    /**
     * Retrieve a specific Animal by its unique ID.
     * Endpoint: GET http://localhost:8080/animals/{animalId}
     *
     * @param animalId the ID of the Animal to retrieve.
     * @return the Animal object with the specified ID.
     */
    @GetMapping("/{animalId}")
    public Animal getOneAnimal(@PathVariable int animalId) {
        return service.getAnimalById(animalId);
    }

    /**
     * Retrieve a list of Animals based on their species.
     * Endpoint: GET http://localhost:8080/animals/species_search?species={species}
     *
     * @param species the species to search for.
     * @return a list of Animal objects matching the specified species.
     */
    @GetMapping("/species_search")
    public List<Animal> getAnimalsBySpecies(@RequestParam(name = "species", defaultValue = "") String species) {
        return service.getAnimalsBySpecies(species);
    }

    /**
     * Retrieve a list of Animals based on a search keyword in their names.
     * Endpoint: GET http://localhost:8080/animals/name_search?name={keyword}
     *
     * @param keyword the search keyword for animal names.
     * @return a list of Animal objects that match the search keyword.
     */
    @GetMapping("/name_search")
    public List<Animal> getAnimalsByName(@RequestParam(name = "name", defaultValue = "") String keyword) {
        return service.getAnimalsByName(keyword);
    }

    /**
     * Create a new Animal record in the database.
     * Endpoint: POST http://localhost:8080/animals/new
     * Request body example:
     * {
     *   "animalId": 4,
     *   "name": "Bengal tiger",
     *   "scientificName": "Panthera tigris tigris",
     *   "species": "Tigris",
     *   "habitat": "Asia",
     *   "description": "Largest living cat species. Large and powerful with orange fur and black stripes."
     * }
     *
     * @param animal the new Animal object to be added.
     * @return the updated list of all Animal objects.
     */
    @PostMapping("/new")
    public List<Animal> addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return service.getAllAnimals();
    }

    /**
     * Update an existing Animal record.
     * Endpoint: PUT http://localhost:8080/animals/update/{animalId}
     * Request body example:
     * {
     *   "animalId": 90,
     *   "name": "Siberian tiger",
     *   "scientificName": "Panthera tigris altaica",
     *   "species": "Tigris",
     *   "habitat": "habitat",
     *   "description": "description"
     * }
     *
     * @param animalId the ID of the Animal to update.
     * @param animal the new Animal object with updated details.
     * @return the updated Animal object.
     */
    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return service.getAnimalById(animalId);
    }

    /**
     * Delete an Animal record by its unique ID.
     * Endpoint: DELETE http://localhost:8080/animals/delete/{animalId}
     *
     * @param animalId the ID of the Animal to delete.
     * @return the updated list of all Animal objects.
     */
    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return service.getAllAnimals();
    }
}

