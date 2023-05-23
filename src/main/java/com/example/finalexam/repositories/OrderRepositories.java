package com.example.finalexam.repositories;

import com.example.finalexam.entities.Customer;
import com.example.finalexam.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepositories extends JpaRepository<Order, Integer> {
    @Transactional
    void deleteAllByCustomerId(Integer id);
}
