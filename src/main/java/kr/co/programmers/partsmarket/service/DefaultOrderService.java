package kr.co.programmers.partsmarket.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import kr.co.programmers.partsmarket.model.Order;
import kr.co.programmers.partsmarket.model.OrderItem;
import kr.co.programmers.partsmarket.model.OrderStatus;
import kr.co.programmers.partsmarket.repository.OrderRepository;

@Service
public class DefaultOrderService implements OrderService {

	private final OrderRepository orderRepository;

	public DefaultOrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order createOrder(String address, String postcode, List<OrderItem> orderItems) {
		UUID orderId = UUID.randomUUID();
		OrderStatus orderStatus = OrderStatus.ACCEPTED;
		return orderRepository.insert(
			new Order(orderId, address, postcode, orderStatus, orderItems, LocalDateTime.now()));
	}
}
