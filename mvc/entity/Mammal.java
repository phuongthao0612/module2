package entity;


public class Mammal extends Animal {
    public Mammal(int id, String name, String species, int age, String gender, String diet, int cage) {
        super(id, name, species, age, gender, diet, cage);
    }
    @Override
    public void eat() {
        System.out.println("Lớp thú ăn thịt hoặc thực vật.");
    }

    @Override
    public void reproduce() {
        System.out.println("Lớp thú sinh con.");
    }
}
