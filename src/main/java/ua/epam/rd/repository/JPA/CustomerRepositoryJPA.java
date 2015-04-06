package ua.epam.rd.repository.JPA;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ua.epam.rd.domain.Customer;
import ua.epam.rd.repository.iCustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Пользователь on 04.04.2015.
 */
@Repository("customerRepository")
@Qualifier("customerRepository")
public class CustomerRepositoryJPA implements iCustomerRepository {
    @PersistenceContext(name = "myPersistentUnitMySql")
    private EntityManager em;

    @Transactional
    @Override
    public long setCustomer(Customer customer) {
        em.persist(customer);
        return customer.getId();
    }

    @Transactional
    @Override
    public void setCustomer(List<Customer> customers) {
        for (Customer c : customers) {
            em.persist(c);
        }
    }

    @Transactional
    @Override
    public Customer getCustomer(long id) {
        return em.find(Customer.class, id);
    }

    @Transactional
    @Override
    public List<Customer> getAll() {
        TypedQuery<Customer> query =
                em.createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> results = query.getResultList();
        return results;
    }

    @Transactional
    @Override
    public void mergeCustomer(Customer customer) {
        em.merge(customer);
    }

    @Transactional
    @Override
    public void deleteCustomer(Customer customer) {
        em.remove(customer);
    }

    @Transactional
    @Override
    public void deleteCustomer(long id) {
        em.remove(em.find(Customer.class, id));
    }
}
