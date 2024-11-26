package controller;

import entity.Product;
import service.IService;
import service.impl.ProductService;

import java.util.List;

public class ProductController {
    private IService productService = new ProductService();


    public void addProduct(Product product) {
        productService.save(product);
    }

    public List<Product> displayAllProducts() {
        return productService.getAll();

    }

    public Product searchProduct(int id) {
        return productService.searchProduct(id);
    }


}
