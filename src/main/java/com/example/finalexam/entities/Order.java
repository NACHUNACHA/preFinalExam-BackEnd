package com.example.finalexam.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@NoArgsConstructor
@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    private Integer orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String comments;
    @ManyToOne
    @JoinColumn(name = "customerNumber")
    private Customer customer;
}
