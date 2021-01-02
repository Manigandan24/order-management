package com.sl.ms.ordermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.ms.ordermanagement.dto.OrderDto;
import com.sl.ms.ordermanagement.entity.Items;
import com.sl.ms.ordermanagement.entity.Orders;
import com.sl.ms.ordermanagement.repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	OrderRepo orderRepo;

	public void saveOrder(OrderDto dto, int orderid) {
		Orders orders = new Orders();
		Items items = new Items();
		List<Items> list = new ArrayList<>();

		items.setAmount(1.1);
		items.setPrice(10.1);
		items.setQuantity(10);

		orders.setName(dto.getName());
		orders.setTotalAmount(dto.getTotalAmount());
		list.add(items);

		orders.setItems(list);

		orderRepo.save(orders);

	}

	public Orders getOrder(int orderid) {
		Optional<Orders> orders = orderRepo.findById(orderid);

		if (orders.isPresent())
			return orders.get();

		return null;
	}

	public List<Orders> getOrdersList() {
		return orderRepo.findAll();
	}

	public void deleteOrder(int orderid) {
		orderRepo.deleteById(orderid);
	}

}
