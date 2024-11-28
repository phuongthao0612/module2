package view;

import controller.AnimalController;
import entity.Animal;

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
            int choice = getChoice("Mời bạn nhập lựa chọn: ", scanner, 1, 3);
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
            System.out.println("5. Sắp xếp động vật theo tên");
            System.out.println("6. Sắp xếp động vật theo chuồng");
            System.out.println("7. Quay lại");
            int choice = getChoice("Mời bạn nhập lựa chọn: ", scanner, 1, 7);
            switch (choice) {
                case 1:
                    List<Animal> animals = animalController.display();
                    if (animals.isEmpty()) {
                        System.out.println("Không có động vật nào.");
                    } else {
                        for (Animal animal : animals) {
                            System.out.println(animal);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Thêm động vật");
                    animalController.add(inputAnimal());
                    System.out.println("Thêm mới thành công");
                    break;
                case 3:
                    System.out.print("Nhập ID của động vật cần xóa: ");
                    int idToRemove = Integer.parseInt(scanner.nextLine());
                    Animal animalToRemove = animalController.findById(idToRemove);
                    if (animalToRemove != null) {
                        animalController.remove(idToRemove);
                        System.out.println("Xóa thành công");
                    } else {
                        System.out.println("Không tìm thấy động vật với ID: " + idToRemove);
                    }
                    break;
                case 4:
                    System.out.print("Nhập từ khóa tìm kiếm: ");
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
                    List<Animal> sortedByName = animalController.sortByName();
                    if (sortedByName.isEmpty()) {
                        System.out.println("Không có động vật nào để sắp xếp.");
                    } else {
                        System.out.println("Danh sách động vật sau khi sắp xếp theo tên:");
                        for (Animal animal : sortedByName) {
                            System.out.println(animal);
                        }
                    }
                    break;
                case 6:
                    List<Animal> sortedByCage = animalController.sortByCage();
                    if (sortedByCage.isEmpty()) {
                        System.out.println("Không có động vật nào để sắp xếp.");
                    } else {
                        System.out.println("Danh sách động vật sau khi sắp xếp theo chuồng:");
                        for (Animal animal : sortedByCage) {
                            System.out.println(animal);
                        }
                    }
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    public static Animal inputAnimal() {
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        while (true) {
            System.out.print("Nhập ID: ");
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (id <= 0) {
                    System.out.println("ID phải là số dương. Vui lòng thử lại.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("ID không hợp lệ. Vui lòng thử lại.");
            }
        }
        String name = "";
        while (true) {
            System.out.print("Nhập tên động vật: ");
            name = scanner.nextLine();
            if (name.matches("^[A-Z][a-z]+$")) {
                break;
            } else {
                System.out.println("Tên động vật không hợp lệ. Vui lòng nhập lại.");
            }
        }
        String species = "";
        while (true) {
            System.out.print("Nhập loài động vật: ");
            species = scanner.nextLine();
            if (species.matches("^[A-Z][a-z]+$")) {
                break;
            } else {
                System.out.println("Không hợp lệ. Vui lòng nhập lại.");
            }
        }
        int age = 0;
        while (true) {
            System.out.print("Nhập tuổi động vật: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age < 0) {
                    System.out.println("Tuổi động vật không hợp lệ. Vui lòng nhập lại.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Tuổi động vật không hợp lệ. Vui lòng thử lại.");
            }
        }
        String gender = "";
        while (true) {
            System.out.print("Nhập giới tính động vật: ");
            gender = scanner.nextLine();
            if (gender.matches("^(male|female)$")) {
                break;
            } else {
                System.out.println("Giới tính động vật male hay female.");
            }
        }
        System.out.print("Nhập chế độ ăn của động vật: ");
        String diet = scanner.nextLine();
        int cage = 0;
        while (true) {
            System.out.print("Nhập số chuồng của động vật: ");
            try {
                cage = Integer.parseInt(scanner.nextLine());
                if (cage <= 0) {
                    System.out.println("Số chuồng phải là số dương. Vui lòng nhập lại.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Số chuồng không hợp lệ. Vui lòng thử lại.");
            }
        }
        Animal animal = new Animal(id, name, species, age, gender, diet, cage);
        return animal;
    }

    private static int getChoice(String s, Scanner scanner, int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            System.out.print(s);
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < min || choice > max) {
                    System.out.println("Vui lòng nhập lại từ " + min + " đến " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
        return choice;
    }
}