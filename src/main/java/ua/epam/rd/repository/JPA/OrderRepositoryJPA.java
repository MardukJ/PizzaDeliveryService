package ua.epam.rd.repository.JPA;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ua.epam.rd.domain.Order;
import ua.epam.rd.repository.iOrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Пользователь on 04.04.2015.
 */
@Repository
@Qualifier("orderRepository")

public class OrderRepositoryJPA implements iOrderRepository {
    @PersistenceContext(name = "myPersistentUnitMySql")
    private EntityManager em;

    @Transactional
    @Override
    public long setOrder(Order order) {
        em.persist(order);
        return order.getId();
    }

    @Transactional
    @Override
    public void setOrder(List<Order> orders) {
        for (Order o : orders) {
            em.persist(o);
        }
    }

    @Transactional
    @Override
    public Order getOrder(long id) {
        return em.find(Order.class, id);
    }

    @Transactional
    @Override
    public List<Order> getAllOrders() {
        TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o", Order.class);
        List<Order> results = query.getResultList();
        return results;
    }

    @Override
    public List<Order> getOrdersByCustomer(long customerId) {
        TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o where o.orderCutomer.id  = :customerId ", Order.class);
        query.setParameter("customerId", customerId);
        List<Order> results = query.getResultList();
        return results;
    }

    @Transactional
    @Override
    public void mergeOrder(Order order) {
        em.merge(order);
        order = em.find(Order.class, order.getId());
    }

    @Transactional
    @Override
    public void deleteOrder(long id) {
        em.remove(em.find(Order.class, id));
    }

    @Transactional
    @Override
    public void deleteOrder(Order order) {
        em.remove(order);
    }
}
