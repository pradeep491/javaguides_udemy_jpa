package com.test.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="addresses")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;

}
