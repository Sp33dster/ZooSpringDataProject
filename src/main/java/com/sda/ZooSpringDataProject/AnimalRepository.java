package com.sda.ZooSpringDataProject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface AnimalRepository extends MongoRepository<Animal, String> {

    Page<Animal> findAllByAgeAndName(Pageable pageable, Integer age, String name);

    Page<Animal> findAllByAgeBetweenAndWeightBetween(Pageable pageable, Integer minAge, Integer maxAge, Integer minWeight, Integer maxWeight);

    Page<Animal> findAllByWeightAndHeightAndNumberOfLegsBetween(Pageable pageable, Integer weight, Integer height, Integer minLegs, Integer maxLegs);

    Page<Animal> findAllByNameLikeAndCountry(Pageable pageable, String name, String country);

    Page<Animal> findAllByBirthBetween(Pageable pageable, LocalDate min, LocalDate max);

    Page<Animal> findAllBy(Pageable pageable);

    Page<Animal> findAllByNameInAndCountryIn(Pageable pageable, String[] name, String[] country);


    Page<Animal> findAllByWeightInAndHeightIn(Pageable pageable, Integer[] weight, Integer[] height);


    Page<Animal> findAllByNameOrCountryOrHeight(Pageable pageable, String name, String country, Integer height);
    Page<Animal> findAllByWeightLessThanOrHeightIsGreaterThan(Pageable pageable, Integer weight, Integer height);

    Page<Animal> findAllByNameOrNumberOfLegs(Pageable pageable, String name, Integer noOfLegs);

    Page<Animal> findAllByBirthAfter(Pageable pageable, LocalDate date);


}
