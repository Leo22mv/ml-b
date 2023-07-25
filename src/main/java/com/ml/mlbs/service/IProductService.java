package com.ml.mlbs.service;

import java.util.List;

import com.ml.mlbs.model.Product;

public interface IProductService {
    public List<Product> getProducts();
    public void saveProduct (Product product);
    public Product findProduct (Long id);
    public void deleteProduct (Long id);
}

