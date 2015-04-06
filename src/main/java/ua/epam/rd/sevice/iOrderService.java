package ua.epam.rd.sevice;

import ua.epam.rd.domain.Order;

import java.util.List;

/**
 * Created by Пользователь on 20.03.2015.
 */
public interface iOrderService {
    long setOrder(Order order);

    void setOrder(List<Order> orders);

    Order getOrder(long id);

    List<Order> getAllOrders();

    List<Order> getOrdersByCustomer(long customerId);

    void mergeOrder(Order order);

    void deleteOrder(long id);

    void deleteOrder(Order order);

    @Deprecated
    Order createOrder();
}
