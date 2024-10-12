package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Gives access to the real database transactions.
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> getAnimalsBySpecies(String species);

    // Determines if a name contains the keyword.
    @Query(value = "SELECT * FROM animals WHERE animals.name LIKE %:keyword%", nativeQuery = true)
    List<Animal> getAnimalsByName(@Param("keyword") String keyword);

}
