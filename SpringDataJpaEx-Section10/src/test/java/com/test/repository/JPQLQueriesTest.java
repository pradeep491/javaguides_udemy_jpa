package com.test.repository;

import com.test.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JPQLQueriesTest {
    @Autowired
    private ProductRepository repository;

    @Test
    void findByNameOrDescriptionJPQLIndexParam() {
    List<Product> products = repository.findByNameOrDescriptionJPQLIndexParam("samsung mobile","mobile");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameOrDescriptionJPQLNamedParam() {
        List<Product> products = repository.findByNameOrDescriptionJPQLNamedParam("samsung mobile","mobile");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
}
