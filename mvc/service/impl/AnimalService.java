package service.impl;

import entity.Animal;
import repository.AnimalRepository;
import service.IService;

import java.util.Collections;
import java.util.List;

public class AnimalService implements IService {
    private AnimalRepository animalRepository = new AnimalRepository();

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.getAllAnimals();
    }

    @Override
    public void addAnimal(Animal animal) {
        animalRepository.addAnimal(animal);
    }

    @Override
    public void removeAnimal(int id) {
        animalRepository.removeAnimal(id);
    }

    @Override
    public List<Animal> searchAnimal(String keyword) {
        return animalRepository.searchAnimal(keyword);
    }

    @Override
    public List<Animal> sortAnimalsByName() {
        List<Animal> animals = animalRepository.getAllAnimals();
        Collections.sort(animals, (a1, a2) -> a1.getName().compareTo(a2.getName()));
        return animals;
    }

    @Override
    public List<Animal> sortAnimalsByCage() {
        List<Animal> animals = animalRepository.getAllAnimals();
        Collections.sort(animals, (a1, a2) -> Integer.compare(a1.getCage(), a2.getCage()));
        return animals;
    }
}
