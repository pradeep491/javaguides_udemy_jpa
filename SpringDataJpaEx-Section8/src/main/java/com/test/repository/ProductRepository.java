package com.test.repository;

import com.test.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

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
     * */

    public Product findByName(String name);

    /****
     * returns an optional which contains the found product
     * entry by using its id as search criteria. if no product entry
     * is found, this method returns an empty optional
     */
    public Optional<Product> findById(Long id);

    /**
     *returns the found list of product entries whose name and description given.
     * as a method parameter. If no product entries is found, this method returns
     * an empty list
     */
    public List<Product> findByNameAndDescription(String name,String description);

    /**
     *returns the found list of product entries whose name or description given.
     * as a method parameter. If no product entries is found, this method returns
     * an empty list
     */
    public List<Product> findByNameOrDescription(String name,String description);

    /**
     * Returns the distinct product entry whose name is given as a method parameter
     * if no product entry is found, this method returns null.
     */
    Product findDistinctByName(String name);

    /**
     *return the products whose price is greater than given price as a parameter
     */
    List<Product> findByPriceGreaterThan(BigDecimal price);

    /**
     *return the products whose price is lesser than given price as a parameter
     */
    List<Product> findByPriceLessThan(BigDecimal price);

    /**
     *return the filtered products whose product name contains the given test
     */
    List<Product> findByNameContaining(String name);

    /**
     *return the filtered products whose product name contains the given test
     */
    List<Product> findByNameLike(String name);

    /**
     *returns a products whose price is in between start & end price
     */
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    /**
     *returns a products whose date created is in between start & end date
     */
    List<Product> findByDateCreatedBetween(LocalDateTime startDate,LocalDateTime endDate);

    /**
     *returns the products whose name is in the given list
     */
    List<Product> findByNameIn(List<String> names);

    List<Product> findFirst2ByOrderByNameAsc();

    List<Product> findTop3ByOrderByNameAsc();

}
