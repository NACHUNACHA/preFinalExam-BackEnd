package com.example.finalexam.servies;

import com.example.finalexam.dtos.CreateOrderDTO;
import com.example.finalexam.entities.Customer;
import com.example.finalexam.entities.Order;
import com.example.finalexam.repositories.CustomerRepositories;
import com.example.finalexam.repositories.OrderRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepositories repository;

    @Autowired
    private CustomerRepositories customerRepositories;

    public Page<Order> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order addOrder(CreateOrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderNumber(orderDTO.getOrderNumber());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setComments(orderDTO.getComments());
        order.setStatus(orderDTO.getStatus());
        order.setRequiredDate(orderDTO.getRequiredDate());
        order.setShippedDate(orderDTO.getShippedDate());
        Customer customers = customerRepositories.findById(orderDTO.getCustomer()).get();
        order.setCustomer(customers);

        return repository.saveAndFlush(order);
    }

    public Order updateOrder(CreateOrderDTO orderDTO, Integer id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Order not found" + id)
        );
        order.setOrderDate(orderDTO.getOrderDate());
        order.setComments(orderDTO.getComments());
        order.setStatus(orderDTO.getStatus());
        order.setRequiredDate(orderDTO.getRequiredDate());
        order.setShippedDate(orderDTO.getShippedDate());

        return repository.saveAndFlush(order);
    }


    public void deleteOrder(Integer id) {
//        Customer customer = customerRepositories.findById(id).orElseThrow(
//                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Customer Id " + id + " Not Found")
//        );

        repository.deleteAllByCustomerId(id);
    }
}
