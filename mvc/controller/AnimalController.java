package controller;

import entity.Animal;
import service.IService;
import service.impl.AnimalService;

import java.util.List;


public class AnimalController {
    private IService animalService = new AnimalService();
    public List<Animal> display() {
        return animalService.getAllAnimals();
    }

    public void add(Animal animal) {
        animalService.addAnimal(animal);
    }

    public void remove(int id) {
        animalService.removeAnimal(id);
    }

    public List<Animal> search(String keyword) {
        return animalService.searchAnimal(keyword);
    }

    public List<Animal> sortByName() {
        return animalService.sortAnimalsByName();
    }

    public List<Animal> sortByCage() {
        return animalService.sortAnimalsByCage();
    }
}
