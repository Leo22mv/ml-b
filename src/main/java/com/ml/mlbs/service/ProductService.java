package com.ml.mlbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.mlbs.model.Product;
import com.ml.mlbs.repository.ProductRepository;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }

    @Override
    public List<Product> getProducts() {
       List<Product> listaProducts = productRepository.findAll();
       return listaProducts; 
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
