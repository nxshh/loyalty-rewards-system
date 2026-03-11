package com.nisarg.loyalty.repository;

import com.nisarg.loyalty.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}