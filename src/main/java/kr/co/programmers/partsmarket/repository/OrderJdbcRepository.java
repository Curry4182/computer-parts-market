package kr.co.programmers.partsmarket.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import kr.co.programmers.partsmarket.model.Order;
import kr.co.programmers.partsmarket.model.OrderItem;

public class OrderJdbcRepository implements OrderRepository{

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public OrderJdbcRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Order insert(Order order) {
		namedParameterJdbcTemplate.update(
			"INSERT INTO orders(order_id, address, postcode, order_status, created_at) " +
				"VALUES(UNHEX(REPLACE(:order_id, '-', '')), :address, :orderStatus, :postcode, :createdAt)"
		, toOrderParamMap(order));

		order.getOrderItems()
			.forEach(
				orderItem ->
					namedParameterJdbcTemplate.update(
						"INSERT INTO order_items(order_id, part_id, part_category, price, quantity, created_at) " +
							"VALUES(UNHEX(REPLACE(:orderId, '-', '')), UNHEX(REPLACE(:productId, '-', '')), :partCategory, :price, :quantity, :createdAt)", toOrderItemParamMap(order, orderItem)
					)
			);

		return order;
	}

	private Map<String, Object> toOrderParamMap(Order order) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("orderId", order.getOrderId().toString().getBytes());
		paramMap.put("address", order.getAddress());
		paramMap.put("orderStatus", order.getOrderStatus().toString());
		paramMap.put("postcode", order.getPostcode());
		paramMap.put("createdAt", order.getCreatedAt());
		return paramMap;
	}

	private Map<String, Object> toOrderItemParamMap(Order order, OrderItem orderItem) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("orderId", order.getOrderId().toString().getBytes());
		paramMap.put("partId", orderItem.getPartId().toString().getBytes());
		paramMap.put("partCategory", orderItem.getPartCategory().toString());
		paramMap.put("price", orderItem.getPrice());
		paramMap.put("quantity", orderItem.getQuantity());
		paramMap.put("createdAt", order.getCreatedAt());
		return paramMap;
	}
}
