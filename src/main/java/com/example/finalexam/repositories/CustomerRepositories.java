package com.example.finalexam.repositories;

import com.example.finalexam.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositories extends JpaRepository<Customer, Integer> {
}
