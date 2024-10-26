package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AnimalService.java
 * This service handles the operations for managing Animal data,
 * acting as the intermediary between the AnimalController and AnimalRepository.
 */



@Service
public class AnimalService {

    @Autowired
    private static AnimalRepository animalRepository;

    /**
     * Retrieves a list of all animals in the database.
     *
     * @return a list containing all Animal objects.
     */
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    /**
     * Retrieves a specific Animal by its unique ID.
     *
     * @param animalId the ID of the animal to retrieve.
     * @return the Animal object, or null if not found.
     */
    public static Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    /**
     * Retrieves all animals that belong to a specific species.
     *
     * @param species the species to filter animals by.
     * @return a list of animals that match the species.
     */
    public List<Animal> getAnimalsBySpecies(String species) {
        return animalRepository.getAnimalsBySpecies(species);
    }

    /**
     * Retrieves animals whose names contain the provided search keyword.
     *
     * @param keyword the name keyword to search for.
     * @return a list of animals whose names contain the search keyword.
     */
    public List<Animal> getAnimalsByName(String keyword) {
        return animalRepository.getAnimalsByName(keyword);
    }

    /**
     * Adds a new Animal record to the database.
     *
     * @param animal the Animal object to be added.
     */
    public void addNewAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    /**
     * Updates an existing Animal record with new details.
     *
     * @param animalId the ID of the animal to update.
     * @param animal   the updated Animal object with new details.
     */
    public void updateAnimal(int animalId, Animal animal) {
        Animal existing = getAnimalById(animalId);
        existing.setName(animal.getName());
        existing.setScientificName(animal.getScientificName());
        existing.setDescription(animal.getDescription());

        // This process is simplified as the save method automatically merges changes.
        animalRepository.save(existing);
    }

    /**
     * Deletes an Animal record from the database based on its ID.
     *
     * @param animalId the ID of the animal to be deleted.
     */
    public void deleteAnimalById(int animalId) {
        animalRepository.deleteById(animalId);
    }
}


