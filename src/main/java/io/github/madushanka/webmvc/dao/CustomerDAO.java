package io.github.madushanka.webmvc.dao;


import io.github.madushanka.webmvc.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerDAO extends JpaRepository<Customer, String> {
    @Query(value = "SELECT customerId FROM Customer ORDER BY customerId DESC LIMIT 1",nativeQuery = true)
    String getLastCustomerId();

}
