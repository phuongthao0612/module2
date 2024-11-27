import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        while (true) {
            System.out.println("Welcome to the Product Manager");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("4. Thoát");
            System.out.println("Nhập lựa chọn: ");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                continue;
            }
            switch (choice) {
                case 1:
                    addProduct(scanner, productManager);
                    break;
                case 2:
                    productManager.displayAllProducts();
                    break;
                case 3:
                    System.out.print("Nhập tên sản phẩm cần tìm: ");
                    String searchName = scanner.nextLine();
                    productManager.searchProduct(searchName);
                    break;
                case 4:
                    System.out.println("Thoát");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    private static void addProduct(Scanner scanner, ProductManager productManager) {
        System.out.print("Nhập mã sản phẩm: ");
        int id = 0;
        try {
            id = Integer.parseInt(scanner.nextLine());
            if (id <= 0) {
                System.out.println("ID sản phẩm phải là số dương. Vui lòng thử lại.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("ID sản phẩm không hợp lệ. Vui lòng thử lại.");
            return;
        }
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = 0;
        try {
            price = Double.parseDouble(scanner.nextLine());
            if (price <= 0) {
                System.out.println("Giá sản phẩm phải là số dương. Vui lòng nhập lại.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Giá sản phẩm không hợp lệ. Vui lòng nhập lại.");
            return;
        }
        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập mô tả sản phẩm: ");
        String description = scanner.nextLine();
        Product product = new Product(id, name, price, manufacturer, description);
        productManager.addProduct(product);
    }
}