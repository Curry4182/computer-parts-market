package kr.co.programmers.partsmarket.repository;

import kr.co.programmers.partsmarket.model.Order;

public interface OrderRepository {
	Order insert(Order order);
}
