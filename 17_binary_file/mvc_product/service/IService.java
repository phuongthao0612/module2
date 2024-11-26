package service;

import entity.Product;

import java.util.List;

public interface IService {
    List<Product> getAll();

    void save(Product product);

    Product searchProduct(int id);
}
