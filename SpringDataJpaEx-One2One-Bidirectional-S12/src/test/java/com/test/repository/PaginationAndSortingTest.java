package com.test.repository;

import com.test.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {
    @Autowired
    private ProductRepository repository;

    @Test
    void pagination() {
        int pageNo = 0;
        int pageSize = 5;

        //create Pageable Object
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        //findAll() method and pass Pageable instance
        Page<Product> page = repository.findAll(pageable);

        List<Product> products = page.getContent();
        System.out.println("======================================================");
        products.forEach((p) -> {
            System.out.println(p);
        });

        //Total Pages
        int totalPages = page.getTotalPages();
        System.out.println("Total Pages: " + totalPages);
        //Total Elements
        long totalElements = page.getTotalElements();
        System.out.println("Total Elements: " + totalElements);
        //number of elements
        int numberOfElements = page.getNumberOfElements();
        //size
        long size = page.getSize();
        System.out.println("Page Size: " + pageSize);
        //page is last
        boolean isFirst = page.isFirst();
        System.out.println("isFirst: " + isFirst);
        // page is first
        boolean isLast = page.isLast();
        System.out.println("isLast: " + isLast);
        System.out.println("======================================================");
    }

    @Test
    void sorting() {
        String sortBy = "price";

        //The below code wrks but the problem is we are hardcoding,we need to dynamically sort based on the client requirements
        //List<Product> products = repository.findAll(Sort.by(sortBy).descending());
        String sortDirection = "desc";

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        List<Product> products = repository.findAll(sort);
        products.forEach((p) -> {
            System.out.println(p);
        });

    }

    @Test
    void sortByMultipleFields() {
        String sortBy = "name";
        String sortByDesc = "description";
        String sortDirection = "desc";

        Sort sortByName = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Sort sortByDescription = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortByDesc).ascending() : Sort.by(sortByDesc).descending();

        Sort groupBySort = sortByName.and(sortByDescription);

        List<Product> products = repository.findAll(groupBySort);
        products.forEach((p) -> {
            System.out.println(p);
        });
    }

    @Test
    void paginationAndSortingTogether() {
        String sortBy = "price";
        String sortDirection = "desc";
        int pageNo = 1;
        int pageSize = 5;

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> page = repository.findAll(pageable);
        List<Product> products = page.getContent();
        System.out.println("======================================================");
        products.forEach((p) -> {
            System.out.println(p);
        });

        //Total Pages
        int totalPages = page.getTotalPages();
        System.out.println("Total Pages: " + totalPages);
        //Total Elements
        long totalElements = page.getTotalElements();
        System.out.println("Total Elements: " + totalElements);
        //number of elements
        int numberOfElements = page.getNumberOfElements();
        //size
        long size = page.getSize();
        System.out.println("Page Size: " + pageSize);
        //page is last
        boolean isFirst = page.isFirst();
        System.out.println("isFirst: " + isFirst);
        // page is first
        boolean isLast = page.isLast();
        System.out.println("isLast: " + isLast);
        System.out.println("======================================================");
    }
}

