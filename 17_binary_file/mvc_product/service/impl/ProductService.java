package service.impl;

import entity.Product;
import repository.ProductRepository;
import service.IService;

import java.util.List;

public class ProductService implements IService {
    private ProductRepository productRepository = new ProductRepository();

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }


    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }


    @Override
    public Product searchProduct(int id) {
        return productRepository.searchProduct(id);

    }
}
