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
        Animal animalToRemove = findById(id);
        if (animalToRemove != null) {
            animalService.removeAnimal(id);
        } else {
            System.out.println("Không tìm thấy động vật với ID: " + id);
        }
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

    public Animal findById(int id) {
        return animalService.findById(id);
    }
}



