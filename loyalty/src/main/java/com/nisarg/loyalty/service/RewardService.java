package com.nisarg.loyalty.service;

import com.nisarg.loyalty.model.Customer;
import com.nisarg.loyalty.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
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
}