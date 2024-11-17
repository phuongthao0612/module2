package entity;

public class Reptile extends Animal {
    public Reptile(int id, String name, String species, int age, String gender, String diet, int cage) {
        super(id, name, species, age, gender, diet, cage);
    }
    @Override
    public void eat() {
        System.out.println("Bò sát ăn thịt hoặc thực vật.");
    }

    @Override
    public void reproduce() {
        System.out.println("Bò sát đẻ trứng.");
    }

}
