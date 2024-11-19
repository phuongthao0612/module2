import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager manager = new ProductManager();
        while (true) {
            System.out.println("Welcome to the Product Manager");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm");
            System.out.println("6. Sắp xếp sản phẩm tăng dần theo giá");
            System.out.println("7. Sắp xếp sản phẩm giảm dần theo giá");
            System.out.println("8. Thoát");
            System.out.println("Nhập lựa chọn: ");
            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                continue;
            }
            switch (choice) {
                case 1:
                    addProduct(manager, sc);
                    break;
                case 2:
                    editProduct(manager, sc);
                    break;
                case 3:
                    deleteProduct(manager, sc);
                    break;
                case 4:
                    manager.displayProducts();
                    break;
                case 5:
                    searchProduct(manager, sc);
                    break;
                case 6:
                    manager.sortProductsAscending();
                    break;
                case 7:
                    manager.sortProductsDescending();
                    break;
                case 8:
                    System.out.println("Thoát");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    private static void addProduct(ProductManager manager, Scanner sc) {
        System.out.print("Nhập id sản phẩm: ");
        int id = 0;
        try {
            id = Integer.parseInt(sc.nextLine());
            if (id <= 0) {
                System.out.println("ID sản phẩm phải là số dương. Vui lòng thử lại.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("ID sản phẩm không hợp lệ. Vui lòng thử lại.");
            return;
        }

        System.out.print("Nhập tên sản phẩm: ");
        String name = sc.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double price = 0;
        try {
            price = Double.parseDouble(sc.nextLine());
            if (price <= 0) {
                System.out.println("Giá sản phẩm phải là số dương. Vui lòng nhập lại.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Giá sản phẩm không hợp lệ. Vui lòng nhập lại.");
            return;
        }

        manager.addProduct(id, name, price);
    }

    private static void editProduct(ProductManager manager, Scanner sc) {
        System.out.print("Nhập id sản phẩm cần sửa: ");
        int editId = 0;
        try {
            editId = Integer.parseInt(sc.nextLine());
            if (editId <= 0) {
                System.out.println("ID sản phẩm phải là số dương. Vui lòng thử lại.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("ID sản phẩm không hợp lệ. Vui lòng thử lại.");
            return;
        }

        System.out.print("Nhập tên mới sản phẩm: ");
        String newName = sc.nextLine();

        System.out.print("Nhập giá mới sản phẩm: ");
        double newPrice = 0;
        try {
            newPrice = Double.parseDouble(sc.nextLine());
            if (newPrice <= 0) {
                System.out.println("Giá sản phẩm phải là số dương. Vui lòng nhập lại.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Giá sản phẩm không hợp lệ. Vui lòng nhập lại.");
            return;
        }

        manager.editProduct(editId, newName, newPrice);
    }

    private static void deleteProduct(ProductManager manager, Scanner sc) {
        System.out.print("Nhập id sản phẩm cần xóa: ");
        int deleteId = 0;
        try {
            deleteId = Integer.parseInt(sc.nextLine());
            if (deleteId <= 0) {
                System.out.println("ID sản phẩm phải là số dương. Vui lòng thử lại.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("ID sản phẩm không hợp lệ. Vui lòng thử lại.");
            return;
        }
        manager.deleteProduct(deleteId);
    }

    private static void searchProduct(ProductManager manager, Scanner sc) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String searchName = sc.nextLine();
        manager.searchProduct(searchName);
    }
}
