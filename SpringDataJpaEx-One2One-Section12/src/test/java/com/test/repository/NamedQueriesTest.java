package com.test.repository;

import com.test.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueriesTest {
    @Autowired
    ProductRepository repository;

    @Test
    void findByPriceMethod() {
        List<Product> products = repository.findByPrice(new BigDecimal(10000));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    void findByNamedJPQLQueriesMethod(){
        System.out.println("===========================================================");
        List<Product> products = repository.findAllOrderByNameDesc();
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
        System.out.println("===========================================================");
        List<Product> priceProducts = repository.findByPrice(new BigDecimal(10000));
        priceProducts.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
        System.out.println("===========================================================");
    }
    @Test
    void findByNamedNativeQuery(){
        System.out.println("===========================================================");
        List<Product> products = repository.findByDescription("mobile");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
        System.out.println("===========================================================");
    }
    @Test
    void findByNamedNativeQueries(){
        System.out.println("===========================================================");
        List<Product> products = repository.findByDescription("mobile");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
        System.out.println("===========================================================");
        List<Product> orderProducts = repository.findAllOrderByNameASC();
        orderProducts.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
        System.out.println("===========================================================");
    }
}
