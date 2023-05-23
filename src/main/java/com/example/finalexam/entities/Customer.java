package com.example.finalexam.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "customerNumber")
    private Integer id;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private Integer salesRepEmployeeNumber;
    private String country;
    private Double creditLimit;
}
