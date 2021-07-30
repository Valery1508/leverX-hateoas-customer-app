package by.leverx.hateoas.hateoastask.service;

import by.leverx.hateoas.hateoastask.dto.OrderItemDto;

import java.util.List;
import java.util.Optional;

/**
 * @author Valeryia Zubrytskaya
 */
public interface OrderItemService {

    Optional<OrderItemDto> getOrderItemById(Long id);

    OrderItemDto createOrderItem(OrderItemDto orderItemDto);

    List<OrderItemDto> getOrderItems();

    void deleteOrderItemById(Long id);

    OrderItemDto updateOrderItemById(Long id, OrderItemDto orderItemDto);

    boolean checkExistence(Long id);

}
