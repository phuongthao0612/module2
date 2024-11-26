package repository;

import entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private String path = "product.txt";

    public void save(Product product) {
        List<Product> products = getProducts();
        products.add(product);
        saveProducts(products);
    }

    public List<Product> getAll() {
        return getProducts();
    }

    public Product searchProduct(int id) {
        List<Product> products = getProducts();
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
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
