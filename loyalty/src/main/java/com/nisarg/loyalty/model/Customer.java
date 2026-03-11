package com.nisarg.loyalty.model;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int rewardPoints;

    public Customer() {}

    public Customer(String name) {
        this.name = name;
        this.rewardPoints = 0;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPoints(int points) {
        this.rewardPoints += points;
    }

    public void redeemPoints(int points) {
        this.rewardPoints -= points;
    }
}