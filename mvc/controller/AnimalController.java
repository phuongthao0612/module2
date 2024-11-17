package controller;

import entity.Animal;
import service.AnimalService;

import java.util.List;

public class AnimalController {
    private AnimalService animalService = new AnimalService();

    public List<Animal> display() {
        return animalService.displayAnimals();
    }

    public void add(Animal animal) {
        animalService.addAnimal(animal);
    }

    public void remove(int id) {
        animalService.removeAnimal(id);
    }

    public List<Animal> search(String keyword) {
        return animalService.searchAnimals(keyword);
    }
}
