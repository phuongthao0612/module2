package entity;

public class Animal {
    private int id;
    private String name;
    private String species;
    private int age;
    private String gender;
    private String diet;
    private int cage;

    public Animal(int id, String name, String species, int age, String gender, String diet, int cage) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.gender = gender;
        this.diet = diet;
        this.cage = cage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public int getCage() {
        return cage;
    }

    public void setCage(int cage) {
        this.cage = cage;
    }

    @Override
    public String toString() {
        return "Animal [id=" + id + ", name=" + name + ", species=" + species
                + ", age=" + age + ", gender=" + gender
                + ", diet=" + diet + ", cage=" + cage + "]";
    }
}
