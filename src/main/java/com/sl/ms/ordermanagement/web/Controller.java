package com.sl.ms.ordermanagement.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sl.ms.ordermanagement.dto.OrderDto;
import com.sl.ms.ordermanagement.entity.Orders;
import com.sl.ms.ordermanagement.service.OrderService;

@RestController
@RequestMapping("/orders")
public class Controller {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping(path = "/{order_id}")
	public String newOrder(@RequestBody OrderDto dto,@PathVariable(name = "order_id") int orderid) {
		orderService.saveOrder(dto,orderid);
		return "Ordered items";
	}
	
	@GetMapping(path = "/{order_id}")
	public Orders getOrder(@PathVariable(name = "order_id") int orderid) {
		return orderService.getOrder(orderid);
	}
	
	@GetMapping(path = "/")
	public List<Orders> getOrdersList() {
		return orderService.getOrdersList();
	}
	
	@DeleteMapping(path = "/{order_id}")
	public String deleteOrder(@PathVariable(name = "order_id") int orderid) {
		orderService.deleteOrder(orderid);
		return "deleted order successfully";
	}

}
