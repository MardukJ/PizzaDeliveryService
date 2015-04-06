package ua.epam.rd.repository.JPA;

import org.springframework.stereotype.Repository;
import ua.epam.rd.domain.Pizza;
import ua.epam.rd.repository.iPizzaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Пользователь on 27.03.2015.
 */
@Repository("pizzaRepository")
public class PizzaRepositoryJPA implements iPizzaRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public long setPizza(Pizza pizza) {
        em.persist(pizza);
        return pizza.getID();
    }

    @Transactional
    @Override
    public void setPizza(List<Pizza> pizza) {
        for (Pizza p : pizza) {
            em.persist(p);
        }
    }

    @Transactional
    @Override
    public Pizza getPizza(long id) {
        Pizza result = em.find(Pizza.class, id);
        return result;
    }

    @Transactional
    @Override
    public void mergePizza(Pizza pizza) {
        em.merge(pizza);
    }

    @Transactional
    @Override
    public List<Pizza> getAll() {
        TypedQuery<Pizza> query =
                em.createQuery("SELECT p FROM Pizza p", Pizza.class);
        List<Pizza> results = query.getResultList();
        return results;
    }

    @Transactional
    @Override
    public void deletePizza(Pizza pizza) {
        em.remove(pizza);
    }

    @Transactional
    @Override
    public void deletePizza(long id) {
        em.remove(em.find(Pizza.class, id));
    }
}

