package com.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
/*@NamedQuery(name="Product.findByPrice",
query = "select p from Product p where p.price=?1")*/
@NamedQueries({
        @NamedQuery(name = "Product.findAllOrderByNameDesc",
                query = "select p from Product p order by p.name desc"),
        @NamedQuery(name = "Product.findByPrice",
                query = "select p from Product p where p.price=:price")
})

//Named NAtive Queries
/*@NamedNativeQuery(name="Product.findByDescription",
        query="select * from products p where p.description=?1",
        resultClass = Product.class)*/
/*@NamedNativeQuery(name="Product.findByDescription",
        query="select * from products p where p.description=:description",
        resultClass = Product.class)*/
@NamedNativeQueries({
        @NamedNativeQuery(name = "Product.findByDescription",
                query = "select * from products p where p.description=:description",
                resultClass = Product.class),
        @NamedNativeQuery(name = "Product.findAllOrderByNameASC",
                query = "select * from products order by name asc",
                resultClass = Product.class)
})
@Table(
        name = "products",
        schema = "javaguides_udemy_jpa",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "stock_keeping_unit"
                )
        }
)
public class Product {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator"
    )
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    private long id;
    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;//stock keeping unit
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
