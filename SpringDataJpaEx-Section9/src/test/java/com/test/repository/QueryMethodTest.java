package com.test.repository;

import com.test.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

@SpringBootTest
public class QueryMethodTest {

    @Autowired
    private ProductRepository repository;

    @Test
    void findByNameMethod() {
        Product p = repository.findByName("Motorola mobile");
        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.getDescription());
        System.out.println(p.getPrice());

    }

    @Test
    void findByIdMethod() {
        Optional<Product> product = repository.findById(12L);

        if (product.isPresent()) {
            Product p = product.get();
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
            System.out.println(p.getPrice());
        }
        /*Product p = repository.findById(12L).get();

        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.getDescription());
        System.out.println(p.getPrice());*/
    }

    @Test
    void findByIdNameAndDescriptionMethod() {
        List<Product> products = repository.findByNameAndDescription("Motorola mobile", "Mobile");
        //approach1
        products.forEach(System.out::println);
        //Approach2
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByIdNameOrDescriptionMethod() {
        List<Product> products = repository.findByNameOrDescription("Motorola mobile", "Mobile");

        //approach1
        products.forEach(System.out::println);
        //Approach2
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    public void findDistincyByNameMethod() {
        Product p = repository.findDistinctByName("Motorola mobile");
        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.getDescription());
    }

    @Test
    public void findByPriceGreaterThanMethod() {
        List<Product> products = repository.findByPriceGreaterThan(new BigDecimal(15000));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    public void findByPriceLessThanMethod() {
        List<Product> products = repository.findByPriceLessThan(new BigDecimal(15000));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    public void findByNameContainingMethod(){
        List<Product> products = repository.findByNameContaining("mobile");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    public void findByNameLikeMethod(){
        List<Product> products = repository.findByNameLike("Samsung Mobile");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    public void findByPriceBetweenMethod(){
        List<Product> products = repository.findByPriceBetween(new BigDecimal(10000),new BigDecimal(15000));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    public void findByDateCreatedBetweenMethod(){
        //start date
        LocalDateTime startDate = LocalDateTime.of(2025,8,22,9,20,20);

        //end date
        LocalDateTime endDate = LocalDateTime.of(2025,8,22,9,59,44);
        List<Product> products = repository.findByDateCreatedBetween(startDate,endDate);
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });

    }
    @Test
    public void findByNameInMethod(){
        //List<String> productNames = Arrays.asList("Samsung mobile","MI Mobile");
        List<Product> products = repository.findByNameIn(List.of("Samsung mobile","MI Mobile"));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    public void findFirst2ByOrderByNameAscMethod() {
        List<Product> products = repository.findFirst2ByOrderByNameAsc();
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    public void findTop3ByOrderByNameAscMethod() {
        List<Product> products = repository.findTop3ByOrderByNameAsc();
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
}
