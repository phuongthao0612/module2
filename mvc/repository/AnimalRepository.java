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
        Animal animalToRemove = findById(id);
        if (animalToRemove != null) {
            animals.remove(animalToRemove);
        }
    }

    public List<Animal> searchAnimal(String keyword) {
        List<Animal> result = new ArrayList<>();
        if (keyword == null || keyword.isEmpty()) {
            return result;
        }
        for (Animal animal : animals) {
            if (animal.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(animal);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Không tìm thấy động vật nào khớp với từ khoá: " + keyword);
        }
        return result;
    }

    public Animal findById(int idToRemove) {
        List<Animal> animals = getAllAnimals();
        for (Animal animal : animals) {
            if (animal.getId() == idToRemove) {
                return animal;
            }
        }
        return null;
    }
}
