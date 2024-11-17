package service;

import entity.Animal;
import repository.AnimalRepository;

import java.util.List;

public class AnimalService {
    private AnimalRepository animalRepository = new AnimalRepository();

    public List<Animal> displayAnimals() {
        return animalRepository.getAllAnimals();
    }

    public void addAnimal(Animal animal) {
        animalRepository.addAnimal(animal);
    }

    public void removeAnimal(int id) {
        animalRepository.removeAnimal(id);
    }

    public List<Animal> searchAnimals(String keyword) {
        return animalRepository.searchAnimals(keyword);
    }


}
