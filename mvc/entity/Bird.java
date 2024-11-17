package entity;

import entity.impl.Flyable;

public class Bird extends Animal implements Flyable {
    public Bird(int id, String name, String species, int age, String gender, String diet, int cage) {
        super(id, name, species, age, gender, diet, cage);
    }
    @Override
    public void eat() {
        System.out.println("Chim ăn hạt, côn trùng");
    }
    @Override
    public void fly(){
        System.out.println("Chim có thể bay");
    }
    @Override
    public void reproduce(){
        System.out.println("Chim đẻ trứng");
    }
}
