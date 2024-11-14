package org.muhikira.awsDemo.repository;

import org.muhikira.awsDemo.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT * FROM prouct_inventory WHERE product_name = ?1", nativeQuery = true)
    List   <Product> getProductsByName(String productName);
}
