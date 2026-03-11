package com.nisarg.loyalty.controller;

import com.nisarg.loyalty.model.Customer;
import com.nisarg.loyalty.repository.CustomerRepository;
import com.nisarg.loyalty.service.RewardService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final RewardService rewardService;
    private final CustomerRepository repository;

    public CustomerController(RewardService rewardService, CustomerRepository repository) {
        this.rewardService = rewardService;
        this.repository = repository;
    }

    @PostMapping
    public Customer createCustomer(@RequestParam String name) {
        return rewardService.createCustomer(name);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @PostMapping("/{id}/addPoints")
    public Customer addPoints(@PathVariable Long id, @RequestParam int points) {
        return rewardService.addPoints(id, points);
    }

    @PostMapping("/{id}/redeem")
    public Customer redeemPoints(@PathVariable Long id, @RequestParam int points) {
        return rewardService.redeemPoints(id, points);
    }

    @PostMapping("/{id}/simulate")
    public String simulateRewards(@PathVariable Long id) {
        rewardService.simulateConcurrentRewards(id);
        return "Reward simulation started";
    }
}