package com.example.finalexam.dtos;

import com.example.finalexam.entities.Customer;
import lombok.Data;

import java.sql.Date;

@Data
public class OrderDTO {
    private Integer orderNumber;
    private Date orderDate;
    private String status;
    private Customer customer;

    public String getCustomer() {
        return this.customer.getId() + "-" + this.customer.getContactFirstName() + " " + this.customer.getContactLastName();
    }
}
