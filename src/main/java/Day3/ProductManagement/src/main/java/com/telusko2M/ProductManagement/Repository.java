package com.telusko2M.ProductManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM products", nativeQuery = true)
    public List<Product> getAllProducts();
    @Query(value = "SELECT * FROM products WHERE warranty < :year", nativeQuery = true)
    public List<Product> getProductsOutOfWarranty(@Param("year") int year);
}
