package com.nisarg.loyalty.service;

import com.nisarg.loyalty.model.Customer;
import com.nisarg.loyalty.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.cache.annotation.Cacheable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Cacheable("customers")
public class RewardService {

    private final CustomerRepository repository;

    public RewardService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer createCustomer(String name) {
        Customer customer = new Customer(name);
        return repository.save(customer);
    }

    public Customer addPoints(Long id, int points) {

        Optional<Customer> customer = repository.findById(id);

        if(customer.isPresent()) {
            Customer c = customer.get();
            c.addPoints(points);
            return repository.save(c);
        }

        return null;
    }

    public Customer redeemPoints(Long id, int points) {

        Optional<Customer> customer = repository.findById(id);

        if(customer.isPresent()) {

            Customer c = customer.get();

            if(c.getRewardPoints() >= points) {
                c.redeemPoints(points);
                return repository.save(c);
            }
        }

        return null;
    }

    public void simulateConcurrentRewards(Long customerId) {

    ExecutorService executor = Executors.newFixedThreadPool(10);

    for (int i = 0; i < 100; i++) {
        executor.submit(() -> {
            addPoints(customerId, 10);
        });
    }

    executor.shutdown();
}
public Customer getCustomer(Long id) {
    return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));
}
private static final Logger log =
LoggerFactory.getLogger(RewardService.class);
}

