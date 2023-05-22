package com.telusko2M.ProductManagement;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    Repository repository;

    public List<Product> getAllProducts(){
        return repository.getAllProducts();
    }

    public List<Product> getProductByName(String name){
        return repository.getAllProducts().stream().filter(product -> {
            return product.getName().toLowerCase().contains(name.toLowerCase());
        }).toList();
    }

    public List<Product> getProductWithText(String text){
        return repository.getAllProducts().stream().filter(product -> {
            return product.getName().toLowerCase().contains(text.toLowerCase()) ||
                    product.getType().toLowerCase().contains(text.toLowerCase()) ||
                    product.getPlace().toLowerCase().contains(text.toLowerCase());
        }).toList();
    }

    public List<Product> getProductByPlace(String place){
        return repository.getAllProducts().stream().filter(product -> {
            return product.getPlace().toLowerCase().contains(place.toLowerCase());
        }).toList();
    }

    public List<Product> getProductsOutOfWarranty(int year){
        return repository.getProductsOutOfWarranty(year);
    }
}
