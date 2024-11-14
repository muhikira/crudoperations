package org.muhikira.awsDemo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CollectionId;


@Entity
@Table(name = "product_inventory")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "color")
    private  String color;

    @Column(name = "price")
    private double price;

}
