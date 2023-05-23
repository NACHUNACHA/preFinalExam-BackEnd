package com.example.finalexam.dtos;
import lombok.Data;

import java.sql.Date;

@Data
public class CreateOrderDTO {
    private Integer orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String comments;
    private Integer customer;
}
