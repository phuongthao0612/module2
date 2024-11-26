import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private String path = "product.txt";

    public void addProduct(Product product) {
        List<Product> products = getProducts();
        products.add(product);
        saveProducts(products);
    }

    public void displayAllProducts() {
        List<Product> products = getProducts();
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void searchProduct(String name) {
        List<Product> products = getProducts();
        boolean found = false;
        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.println(product);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Sản phẩm không tìm thấy.");
        }
    }

    private void saveProducts(List<Product> products) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()) {
            return products;
        }
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            products = (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
}
