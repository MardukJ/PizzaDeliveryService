package ua.epam.rd.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.epam.rd.domain.Order;
import ua.epam.rd.repository.iOrderRepository;

import java.util.List;

/**
 * Created by Пользователь on 20.03.2015.
 */

@Component("orderService")
public class OrderService implements iOrderService {
    private static int lastOrder = 0;

    @Autowired
    @Qualifier("orderRepository")
    iOrderRepository orderRepository = null;

    public OrderService() {
    }

    public OrderService(iOrderRepository repository) {
        orderRepository = repository;
    }

    @Override
    public long setOrder(Order order) {
        return orderRepository.setOrder(order);
    }

    @Override
    public void setOrder(List<Order> orders) {
        orderRepository.setOrder(orders);
    }

    @Override
    public Order getOrder(long id) {
        return orderRepository.getOrder(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public List<Order> getOrdersByCustomer(long customerId) {
        return orderRepository.getOrdersByCustomer(customerId);
    }

    @Override
    public void deleteOrder(long id) {
        orderRepository.deleteOrder(id);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.deleteOrder(order);
    }

    @Override
    public void mergeOrder(Order order) {
        orderRepository.mergeOrder(order);
    }

    @Deprecated
    public Order createOrder() {
        return new Order(lastOrder++);
    }
}
