package kr.co.programmers.partsmarket.service;

import java.util.List;

import kr.co.programmers.partsmarket.model.Order;
import kr.co.programmers.partsmarket.model.OrderItem;

public interface OrderService {
	Order createOrder(String address, String postcode, List<OrderItem> orderItems);
}
