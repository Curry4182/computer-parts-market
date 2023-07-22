package kr.co.programmers.partsmarket.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.programmers.partsmarket.controller.CreateOrderRequest;
import kr.co.programmers.partsmarket.model.Order;
import kr.co.programmers.partsmarket.service.OrderService;

@RestController
public class OrderRestController {

	private final OrderService orderService;
	public OrderRestController(OrderService orderService) {
		this.orderService = orderService;
	}
	@PostMapping("/api/orders")
	public Order createOrder(@RequestBody CreateOrderRequest orderRequest) {
		return orderService.createOrder(
			orderRequest.getAddress(),
			orderRequest.getPostcode(),
			orderRequest.getOrderItems()
		);
	}
}
