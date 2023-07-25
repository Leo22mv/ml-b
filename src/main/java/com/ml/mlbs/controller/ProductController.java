package com.ml.mlbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ml.mlbs.model.Product;
import com.ml.mlbs.service.IProductService;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://e-commerce-f.web.app")
public class ProductController {
    @Autowired
    private IProductService iproductService;

    @GetMapping("/productos")
    public List<Product> getProducts() {
        return iproductService.getProducts();
    }

    @PostMapping ("/productos/agregar")
    public void saveProduct(@RequestBody Product product) {
        iproductService.saveProduct(product);
    }

    @DeleteMapping ("/productos/eliminar")
    public void deleteProduct(@RequestBody Long id) {
        iproductService.deleteProduct(id);
    }
}
