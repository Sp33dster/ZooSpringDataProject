package com.sda.ZooSpringDataProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AnimalService {

    private AnimalRepository repository;

    @Autowired
    private AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public Page<Animal> findAllByAgeAndName(Pageable pageable, Integer age, String name) {
        return repository.findAllByAgeAndName(pageable, age, name);
    }

    public void createAnimal(CreateAnimalRequest request) {

        Animal animal = Animal.builder()
                .age(request.getAge())
                .species(request.getSpecies())
                .name(request.getName())
                .country(request.getCountry())
                .weight(request.getWeight())
                .height(request.getHeight())
                .numberOfLegs(request.getNumberOfLegs())
                .birth(request.getBirth())
                .build();
        repository.save(animal);
    }


    public Page<Animal> findAllByAgeBetweenAndWeightBetween(@PageableDefault (size = 2) Pageable pageable, Integer minAge, Integer maxAge, Integer minWeight, Integer maxWeight) {
    return repository.findAllByAgeBetweenAndWeightBetween(pageable, minAge,maxAge,minWeight,maxWeight);
    }

    public Page<Animal> findAllByWeightAndHeightAndNumberOfLegsBetween(Pageable pageable, Integer weight, Integer height, Integer minLegs, Integer maxLegs) {
        return repository.findAllByWeightAndHeightAndNumberOfLegsBetween(pageable, weight, height, minLegs, maxLegs);
    }

    public Page<Animal> findAllByNameLikeAndCountry(Pageable pageable, String name, String country) {
        return repository.findAllByNameLikeAndCountry(pageable, name, country);
    }

    public Page<Animal> findAllByBirthBetween(Pageable pageable, LocalDate min, LocalDate max) {
        return repository.findAllByBirthBetween(pageable, min, max);
    }

    public Page<Animal> getAllAnimals(Pageable pageable) {
        return repository.findAllBy(pageable);
    }

    public Page<Animal> findAllByNameInCountryIn(Pageable pageable, String[] name, String[] country) {
        return repository.findAllByNameInAndCountryIn(pageable, name, country);
    }

    public Page<Animal> findAllByWeightInAndHeightIn(Pageable pageable, Integer[] weight, Integer[] height) {
        return repository.findAllByWeightInAndHeightIn(pageable, weight, height);
    }

    public Page<Animal> findAllByNameOrCountryOrHeight(Pageable pageable, String name, String country, Integer height) {
            return repository.findAllByNameOrCountryOrHeight(pageable, name, country, height);
    }

    public Page<Animal> findAllByWeightLessOrHeightHigher(Pageable pageable, Integer weight, Integer height) {
            return repository.findAllByWeightLessThanOrHeightIsGreaterThan(pageable, weight, height);
    }

    public Page<Animal> findAllByNameOrNumberOfLegs(Pageable pageable, String name, Integer noOfLegs) {
        return repository.findAllByNameOrNumberOfLegs(pageable, name, noOfLegs);
    }

    public Page<Animal> findAllByBirthAfter(Pageable pageable, LocalDate date) {
        return repository.findAllByBirthAfter(pageable, date);
    }
}