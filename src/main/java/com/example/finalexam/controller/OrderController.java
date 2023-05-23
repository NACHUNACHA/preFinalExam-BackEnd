package com.example.finalexam.controller;


import com.example.finalexam.dtos.CreateOrderDTO;
import com.example.finalexam.dtos.OrderDTO;
import com.example.finalexam.dtos.PageDTO;
import com.example.finalexam.entities.Order;
import com.example.finalexam.servies.OrderService;
import com.example.finalexam.utils.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService service;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

//    @GetMapping
//    public List<Order> getAll() {
//        return service.getAllOrders();
//    }

    @GetMapping
    public PageDTO<OrderDTO> getAllOrders() {
        Page<Order> orders = service.getAll(0, 5);
        return listMapper.toPageDTO(orders, OrderDTO.class, modelMapper);
    }

    @PostMapping
    public Order createOrder(@RequestBody CreateOrderDTO order){
        return service.addOrder(order);
    }

    @PutMapping("{id}")
    public Order updateOrder(@RequestBody CreateOrderDTO order, @PathVariable Integer id){
        return service.updateOrder(order, id);
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable Integer id){
        service.deleteOrder(id);
    }
}
