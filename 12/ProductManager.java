import java.util.ArrayList;
import java.util.Comparator;

public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void addProduct(int id, String name, double price) {
        Product product = new Product(id, name, price);
        products.add(product);
    }

    public void editProduct(int id, String name, double price) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(name);
                product.setPrice(price);
                System.out.println("Sửa thông tin sản phẩm thành công.");
                return;
            }
        }
        System.out.println("Sản phẩm không tìm thấy." + id);
    }

    public void deleteProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                System.out.println("Xóa sản phẩm thành công.");
                return;
            }
        }
        System.out.println("Sản phẩm không tìm thấy." + id);
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void searchProduct(String name) {
        boolean found = false;
        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm với tên: " + name);
        }
    }

    public void sortProductsAscending() {
        products.sort(Comparator.comparingDouble(Product::getPrice));
        System.out.println("Sản phẩm đã được sắp xếp tăng dần theo giá.");

    }

    public void sortProductsDescending() {
        products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        System.out.println("Sản phẩm đã được sắp xếp giảm dần theo giá.");
    }
}
