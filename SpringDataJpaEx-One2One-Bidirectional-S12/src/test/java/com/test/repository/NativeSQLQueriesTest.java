package com.test.repository;

import com.test.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class NativeSQLQueriesTest {
    @Autowired
    private ProductRepository repository;

    @Test
    void findByNameOrDescriptionNativeSqlIndexParamMethod() {
        List<Product> products = repository.findByNameOrDescriptionNativeIndexParam("samsung mobile","mobile");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    void findByNameOrDescriptionNativeSqlNamedParamMethod() {
        List<Product> products = repository.findByNameOrDescriptionNativeSQLNamedParam("samsung mobile","mobile");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
}
