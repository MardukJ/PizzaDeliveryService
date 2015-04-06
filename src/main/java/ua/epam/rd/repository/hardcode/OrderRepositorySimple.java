package ua.epam.rd.repository.hardcode;

import org.springframework.stereotype.Repository;
import ua.epam.rd.domain.Order;
import ua.epam.rd.repository.iOrderRepository;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Пользователь on 20.03.2015.
 */

@Repository

public class OrderRepositorySimple implements iOrderRepository {
    private List<Order> orders = new LinkedList<Order>();

    @Override
    public long setOrder(Order order) {
        orders.add(order);
        return (orders.size() - 1);
    }

    @Override
    public void setOrder(List<Order> orders) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public void deleteOrder(long id) {
        Iterator<Order> it = orders.iterator();
        while (it.hasNext()) {
            Order o = it.next();
            if (o.getId() == id) {
                it.remove();
            }
        }
    }

    @Override
    public Order getOrder(long id) {
        Iterator<Order> it = orders.iterator();
        Order o;
        while (it.hasNext()) {
            o = it.next();
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }

    @Override
    public List<Order> getOrdersByCustomer(long customerId) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public void deleteOrder(Order order) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public void mergeOrder(Order order) {
        throw new UnsupportedOperationException("");
    }
}
