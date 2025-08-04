package com.test.repository;

import com.test.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.BigDecimalConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
//@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductRepository productRepository;

    //To Save an Entity
    @Test
    void saveMethod() {
        //create product
        Product product = new Product();
        product.setName("samsung mobile");
        product.setDescription("Mobile");
        product.setPrice(new BigDecimal(50000));
        product.setSku("100AMC");
        product.setActive(true);
        product.setImageUrl("product.jpeg");

        //save product
        Product product1 = repository.save(product);

        //display product info
        System.out.println(product1.getId());
        System.out.println(product1.toString());
    }
    //To Update an Entity
    @Test
    void updateUsingSaveMethod() {
        //find and retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        //update the retrieved entity
        product.setName("Samsung Washing Machine");
        product.setDescription("Washing Machine");
        //save an entity into DB
        Product product1 = productRepository.save(product);
        System.out.println(product1.getId());
        System.out.println(product1.toString());
    }
    @Test
    void findByIdMethod() {
        //find and retrieve an entity by id
        Long id = 1L;
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            Product product1 = product.get();
            System.out.println(product1.getId());
            System.out.println(product1.toString());
        }
    }
    @Test
    void saveAllMethod() {

        List<Product> list = new ArrayList<>();

        Product product1 = new Product();
        product1.setName("Motorola mobile");
        product1.setDescription("Mobile");
        product1.setPrice(new BigDecimal(10000));
        product1.setSku("16AMC");
        product1.setActive(true);
        product1.setImageUrl("motorola.jpeg");


        Product product2 = new Product();
        product2.setName("MI Mobile");
        product2.setDescription("Mobile");
        product2.setPrice(new BigDecimal(15000));
        product2.setSku("17AMC");
        product2.setActive(true);
        product2.setImageUrl("MI.jpeg");

        //adding to list
        list.add(product1);
        list.add(product2);

        //saving into DB
        //repository.saveAll(list);
        repository.saveAll(List.of(product1, product2));
    }
    @Test
    void findAllMethod() {

        List<Product> list =repository.findAll();
        System.out.println("==========================");
        list.stream().forEach(System.out::println);
        System.out.println("==========================");
        list.forEach((product) -> System.out.println(product.getName()));
        System.out.println("==========================");
    }
    @Test
    void deleteByIdMethod() {
        System.out.println("==========================");
        repository.deleteById(7L);
        System.out.println("id deleted successfully");
        System.out.println("==========================");

    }
    @Test
    void deleteMethod() {
        System.out.println("==========================");
        Product p = repository.findById(6L).get();
        repository.delete(p);
        System.out.println("product deleted successfully");
        System.out.println("==========================");

    }
    @Test
    void deleteAllMethod() {
        System.out.println("==========================");
        repository.deleteAll();
        System.out.println("products deleted successfully");
        System.out.println("==========================");

    }
    @Test
    void deleteAllListMethod() {
        System.out.println("==========================");
        Product p1 = repository.findById(8L).get();
        Product p2 = repository.findById(9L).get();
        Product p3 = repository.findById(10L).get();
        Product p4 = repository.findById(11L).get();
        repository.deleteAll(List.of(p1, p2, p3, p4));
        System.out.println("products deleted successfully");
        System.out.println("==========================");

    }
    @Test
    void countEntitiesMethod() {
        System.out.println("==========================");
        Long count = repository.count();
        System.out.println(count+" products are available in Products Table");
        System.out.println("==========================");

    }
    @Test
    void existsByIdMethod() {
        System.out.println("==========================");
        Boolean flag = repository.existsById(7L);
        if(flag) {
            System.out.println(flag+ "-product is available in Products Table");
        }else {
            System.out.println(flag + "-product is not available in Products Table");
        }
        System.out.println("==========================");
    }

}