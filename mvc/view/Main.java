package view;


import controller.AnimalController;
import entity.Animal;
import entity.Bird;
import entity.Mammal;
import entity.Reptile;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chào mừng bạn đến với trang quản lý Neverland Zoo");
        while (true) {
            System.out.println("1. Quản lý động vật");
            System.out.println("2. Quản lý nhân viên");
            System.out.println("3. Thoát");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    menuAnimal();
                    break;
                case 2:
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
    public static void menuAnimal() {
        Scanner scanner = new Scanner(System.in);
        AnimalController animalController = new AnimalController();
        System.out.println("Quản lý động vật");
        while (true) {
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm động vật");
            System.out.println("3. Xóa động vật");
            System.out.println("4. Tìm kiếm động vật");
            System.out.println("5. Quay lại");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    List<Animal> animals = animalController.display();
                    for (Animal animal : animals) {
                        System.out.println(animal);
                    }
                    break;
                case 2:
                    System.out.println("Thêm động vật");
                    animalController.add(inputAnimal());
                    System.out.println("Thêm mới thành công");
                    break;
                case 3:
                    System.out.print("Nhập ID động vật cần xóa: ");
                    int idToRemove = Integer.parseInt(scanner.nextLine());
                    animalController.remove(idToRemove);
                    System.out.println("Xóa thành công");
                    break;
                case 4:
                    System.out.print("Nhập loài động vật cần tìm: ");
                    String keyword = scanner.nextLine();
                    List<Animal> foundAnimals = animalController.search(keyword);
                    if (foundAnimals.isEmpty()) {
                        System.out.println("Không tìm thấy động vật nào");
                    } else {
                        for (Animal animal : foundAnimals) {
                            System.out.println(animal);
                        }
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
    public static Animal inputAnimal() {
        Scanner scanner = new Scanner(System.in);
        Animal animal = null;
        System.out.println("Chọn loại động vật:");
        System.out.println("1. Thú");
        System.out.println("2. Chim");
        System.out.println("3. Bò sát");
        System.out.print("Mời bạn chọn loại động vật: ");
        int choice = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên động vật: ");
        String name = scanner.nextLine();
        System.out.print("Nhập loài động vật: ");
        String species = scanner.nextLine();
        System.out.print("Nhập tuổi động vật: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập giới tính động vật: ");
        String gender = scanner.nextLine();
        System.out.print("Nhập chế độ ăn của động vật: ");
        String diet = scanner.nextLine();
        System.out.print("Nhập số chuồng của động vật: ");
        int cage = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                animal = new Mammal(id, name, species, age, gender, diet, cage);
                break;
            case 2:
                animal = new Bird(id, name, species, age, gender, diet, cage);
                break;
            case 3:
                animal = new Reptile(id, name, species, age, gender, diet, cage);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                return null;
        }
        return animal;
    }
}
