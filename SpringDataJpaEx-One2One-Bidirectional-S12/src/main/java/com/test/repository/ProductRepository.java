package com.test.repository;

import com.test.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Query Method to find or Retrieve Product by Name

    /**
     * returns the found product entry by using its name as search
     * criteria.If no product entry is found this method
     * returns null.
     */

    public Product findByName(String name);

    /****
     * returns an optional which contains the found product
     * entry by using its id as search criteria. if no product entry
     * is found, this method returns an empty optional
     */
    public Optional<Product> findById(Long id);

    /**
     * returns the found list of product entries whose name and description given.
     * as a method parameter. If no product entries is found, this method returns
     * an empty list
     */
    public List<Product> findByNameAndDescription(String name, String description);

    /**
     * returns the found list of product entries whose name or description given.
     * as a method parameter. If no product entries is found, this method returns
     * an empty list
     */
    public List<Product> findByNameOrDescription(String name, String description);

    /**
     * Returns the distinct product entry whose name is given as a method parameter
     * if no product entry is found, this method returns null.
     */
    Product findDistinctByName(String name);

    /**
     * return the products whose price is greater than given price as a parameter
     */
    List<Product> findByPriceGreaterThan(BigDecimal price);

    /**
     * return the products whose price is lesser than given price as a parameter
     */
    List<Product> findByPriceLessThan(BigDecimal price);

    /**
     * return the filtered products whose product name contains the given test
     */
    List<Product> findByNameContaining(String name);

    /**
     * return the filtered products whose product name contains the given test
     */
    List<Product> findByNameLike(String name);

    /**
     * returns a products whose price is in between start & end price
     */
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    /**
     * returns a products whose date created is in between start & end date
     */
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    /**
     * returns the products whose name is in the given list
     */
    List<Product> findByNameIn(List<String> names);

    List<Product> findFirst2ByOrderByNameAsc();

    List<Product> findTop3ByOrderByNameAsc();

    //Define JPQL Query using @query annotation with index or position parameters

    @Query("select p from Product p where p.name=?1 or p.description=?2")
    List<Product> findByNameOrDescriptionJPQLIndexParam(String name, String description);

    //Define JPQL Query using @query annotation with named parameters
    @Query("select p from Product p where p.name=:name or p.description=:description")
    List<Product> findByNameOrDescriptionJPQLNamedParam(@Param("name") String name,
                                                        @Param("description") String description);


    //Define Native Query using @query annotation with index or position parameters
    @Query(value = "select * from products p where p.name=?1 or p.description=?2",nativeQuery = true)
    List<Product> findByNameOrDescriptionNativeIndexParam(String name,
                                                          String description);

    //Define Native Query using @query annotation with named parameters
    @Query(value = "select * from products p where p.name=:name or p.description=:description",
            nativeQuery = true)
    List<Product> findByNameOrDescriptionNativeSQLNamedParam(@Param("name") String name,
                                                             @Param("description") String description);

    //Define Named JPQL Query
    //List<Product> findByPrice(BigDecimal price);

    //Multiple Named Queries
    List<Product> findAllOrderByNameDesc();

    List<Product> findByPrice(@Param("price") BigDecimal price);

    //define Named native SQL Queries
   /* @Query(nativeQuery = true)
    List<Product> findByDescription(@Param("description") String description);*/

    //Define multiple Named native SQL Queries
    @Query(nativeQuery = true)
    List<Product> findByDescription(@Param("description") String description);

    @Query(nativeQuery = true)
    List<Product> findAllOrderByNameASC();
}
