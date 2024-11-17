package repository;

import entity.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {
    private List<Animal> animals = new ArrayList<>();

    public List<Animal> getAllAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(int id) {
        animals.removeIf(animal -> animal.getId() == id);
    }

    public List<Animal> searchAnimals(String keyword) {
        return animals;
    }

}
