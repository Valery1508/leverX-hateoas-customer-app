package by.leverx.hateoas.hateoastask.service.impl;

import by.leverx.hateoas.hateoastask.dto.OrderItemDto;
import by.leverx.hateoas.hateoastask.entity.OrderItem;
import by.leverx.hateoas.hateoastask.exception.EntityNotFoundException;
import by.leverx.hateoas.hateoastask.mapper.OrderItemMapper;
import by.leverx.hateoas.hateoastask.repository.OrderItemRepository;
import by.leverx.hateoas.hateoastask.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Valeryia Zubrytskaya
 */
@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    private final OrderItemMapper orderItemMapper;

    @Override
    @Transactional(readOnly = true)
    public Optional<OrderItemDto> getOrderItemById(Long id) {

        if (!checkExistence(id)) {
            throw new EntityNotFoundException(OrderItem.class.getName(), id);
        }

        Optional<OrderItem> orderItem = orderItemRepository.findById(id);

        return orderItem
                .map(orderItemMapper::toDto);

    }

    @Override
    @Transactional
    public OrderItemDto createOrderItem(OrderItemDto orderItemDto) {

        OrderItem orderItem = orderItemMapper.toEntity(orderItemDto);
        orderItemRepository.save(orderItem);

        return getOrderItemById(orderItem.getId()).get();

    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderItemDto> getOrderItems() {

        List<OrderItem> orderItems = orderItemRepository.findAll();
        return orderItemMapper.listToDtos(orderItems);

    }

    @Override
    @Transactional
    public void deleteOrderItemById(Long id) {

        if (checkExistence(id)) {
            orderItemRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(OrderItem.class.getName(), id);
        }
    }

    @Override
    @Transactional
    public OrderItemDto updateOrderItemById(Long id, OrderItemDto orderItemDto) {

        if (!checkExistence(id)) {
            throw new EntityNotFoundException(OrderItem.class.getName(), id);
        }

        orderItemDto.setId(id);
        OrderItem orderItem = orderItemMapper.toEntity(orderItemDto);

        OrderItem savedOrderItem = orderItemRepository.save(orderItem);

        return orderItemMapper.toDto(savedOrderItem);

    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkExistence(Long id) {
        return orderItemRepository.existsById(id);
    }
}
