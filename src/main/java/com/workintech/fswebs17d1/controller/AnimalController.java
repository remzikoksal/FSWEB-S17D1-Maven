package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerName;

    // Tüm hayvanlar listesi
    @GetMapping
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    // ID'ye göre hayvan getir
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animals.get(id);
    }

    // Yeni hayvan ekle
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }
    // Hayvanı güncelle
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal updatedAnimal) {
        if (animals.containsKey(id)) {
            animals.put(id, updatedAnimal);
            return updatedAnimal;
        } else {
            return null;
        }
    }

    // Hayvan sil
    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable Integer id) {
        return animals.remove(id);
    }
}
