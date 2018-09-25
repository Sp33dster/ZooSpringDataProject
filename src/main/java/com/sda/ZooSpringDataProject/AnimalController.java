package com.sda.ZooSpringDataProject;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AnimalController {

        private AnimalService animalService;

        @PostMapping("/create")
        @ResponseStatus(HttpStatus.CREATED)
        public void createAnimal(@RequestBody CreateAnimalRequest request){
            animalService.createAnimal(request);
        }
        @Autowired
    public AnimalController(AnimalService animalService){
            this.animalService = animalService;
        }


        @GetMapping("/searchAgeName")
public Page<Animal> findAllByAgeAndName(@PageableDefault (size = 2) Pageable pageable,
                                        @RequestParam Integer age, @RequestParam String name){
            return animalService.findAllByAgeAndName(pageable, age, name);

        }

        @GetMapping("/searchBAgeAndBWeight")
    public Page<Animal> findAllByAgeBetweenAndWeightBetween(@PageableDefault (size = 2) Pageable pageable,
                                                            @RequestParam Integer minAge, @RequestParam Integer maxAge,
                                                            @RequestParam Integer minWeight, @RequestParam Integer maxWeight){
            return animalService.findAllByAgeBetweenAndWeightBetween(pageable, minAge,maxAge,minWeight,maxWeight);
        }

        @GetMapping("/searchByWeightHeightAndNumberOfLegsBetween")
    public Page<Animal> findAllByWeightAndHeightAndNumberOfLegsBetween(@PageableDefault (size = 2) Pageable pageable,
                                                                       @RequestParam Integer weight,
                                                                       @RequestParam Integer height,
                                                                       @RequestParam Integer minLegs,
                                                                       @RequestParam Integer maxLegs){
            return animalService.findAllByWeightAndHeightAndNumberOfLegsBetween(pageable, weight, height, minLegs, maxLegs);
        }

        @GetMapping("/searchByNameLikeAndCountry")
    public  Page<Animal> findAllByNameLikeAndCountry(@PageableDefault (size = 2) Pageable pageable,
                                                     @RequestParam String name, @RequestParam String country){
            return animalService.findAllByNameLikeAndCountry(pageable, name, country);
        }

        @GetMapping("/searchBirthBetween")
    public Page<Animal> findAllByBirthBetween(@PageableDefault (size = 2) Pageable pageable,
                                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate min,
                                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate max){
            return animalService.findAllByBirthBetween(pageable, min, max);
        }
    @GetMapping("/all")
    public Page<Animal> findAll(@PageableDefault(size = 2) Pageable pageable){
        return animalService.getAllAnimals(pageable);
    }

    @GetMapping("/multipleSearchNameCountry")
    public Page<Animal> findAllByNameInAndCountryIn(@PageableDefault (size = 2) Pageable pageable,
                                                    @RequestParam String[] name, @RequestParam String[] country){
            return animalService.findAllByNameInCountryIn(pageable, name, country);
    }

    @GetMapping("/multipleSearchByWeightAndHeight")
    public Page<Animal> findAllByWeightInAndHeightIn(@PageableDefault (size = 2) Pageable pageable,
                                                     @RequestParam Integer[] weight, @RequestParam Integer[] height){
            return animalService.findAllByWeightInAndHeightIn(pageable,weight, height);
    }

    @GetMapping("/searchNameOrCountryOrHeight")
    public Page<Animal> findAllByNameOrCountryOrHeight(@PageableDefault (size = 2) Pageable pageable,
                                                       @RequestParam String name, @RequestParam String country,
                                                       @RequestParam Integer height){
            return animalService.findAllByNameOrCountryOrHeight(pageable, name, country, height);
    }

    @GetMapping("/searchWeightLessOrHeightHigher")
    public Page<Animal> findAllByWeightLessOrHeightHigher(@PageableDefault (size = 2) Pageable pageable,
                                                          @RequestParam Integer weight, @RequestParam Integer height){
            return animalService.findAllByWeightLessOrHeightHigher(pageable, weight, height);
    }

    @GetMapping("/searchNameOrNoOfLegs")
    public Page<Animal> findAllByNameOrNumberOfLegs(@PageableDefault (size = 2) Pageable pageable,
                                                    @RequestParam String name, @RequestParam Integer noOfLegs){
            return  animalService.findAllByNameOrNumberOfLegs(pageable, name, noOfLegs);
    }

    @GetMapping("/searchBirthGreaterThan")
    public Page<Animal> findAllByBirthGreaterThan(@PageableDefault (size = 2) Pageable pageable,
                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
            return animalService.findAllByBirthAfter(pageable, date);
    }

}
