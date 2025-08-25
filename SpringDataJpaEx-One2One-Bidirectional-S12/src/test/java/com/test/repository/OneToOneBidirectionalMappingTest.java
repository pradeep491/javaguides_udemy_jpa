package com.test.repository;

import com.test.entity.Address;
import com.test.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneBidirectionalMappingTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void saveAddress(){
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
        address.setOrder(order);

        addressRepository.save(address);
    }

    @Test
    void updateAddress(){
        Address address = addressRepository.findById(1L).get();
        address.setZipcode("518166");
        address.getOrder().setStatus("Delivered");

        addressRepository.save(address);
    }

    @Test
    void fetchAddress(){
        System.out.println("==========================================");
        Address address = addressRepository.findById(1L).get();
        System.out.println(address.getOrder().getId());
        System.out.println(address.getOrder().getOrderTrackingNumber());
        System.out.println(address.getOrder().getStatus());
        System.out.println(address.getOrder().getTotalPrice());
        System.out.println(address.getOrder().getTotalQuantity());
        System.out.println(address.getOrder().getDateCreated());
        System.out.println(address.getOrder().getLastUpdated());
        System.out.println("==========================================");
        System.out.println(address.getCity());
        System.out.println(address.getCountry());
        System.out.println(address.getState());
        System.out.println(address.getZipcode());
        System.out.println("==========================================");
    }
    @Test
    void deleteAddress(){
        addressRepository.deleteById(1L);
    }
}
