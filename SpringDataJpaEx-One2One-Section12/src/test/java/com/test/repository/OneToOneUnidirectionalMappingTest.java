package com.test.repository;

import com.test.entity.Address;
import com.test.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.*;

@SpringBootTest
public class OneToOneUnidirectionalMappingTest {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrderMethod() {
        Order order = new Order();
        order.setOrderTrackingNumber("100abc");
        order.setTotalQuantity(5);
        order.setStatus("in Progress");
        order.setTotalPrice(new BigDecimal(1000));

        Address address = new Address();
        address.setCity("Hyderabad");
        address.setStreet("New Balaji Nagar");
        address.setState("Andhra Pradesh");
        address.setCountry("INDIA");
        address.setZipcode("500072");

        order.setBillingAddress(address);
        orderRepository.save(order);
    }

    @Test
    void updateOrderMethod() {
        Order order = orderRepository.findById(1L).get();
        order.setStatus("delivered");
        order.getBillingAddress().setZipcode("518166");
        orderRepository.save(order);
    }

    @Test
    void deleteOrder() {
        orderRepository.deleteById(1L);
    }
    @Test
    void getOrder(){
        Order order = orderRepository.findById(2L).get();
        System.out.println(order);
    }
}
