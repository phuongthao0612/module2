package service;

import entity.Animal;

import java.util.List;

public interface IService {
    List<Animal> getAllAnimals();

    void addAnimal(Animal animal);

    void removeAnimal(int id);

    List<Animal> searchAnimal(String keyword);

    List<Animal> sortAnimalsByName();

    List<Animal> sortAnimalsByCage();
}
