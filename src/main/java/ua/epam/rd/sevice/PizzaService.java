package ua.epam.rd.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.epam.rd.domain.Pizza;
import ua.epam.rd.repository.iPizzaRepository;

import java.util.List;

/**
 * Created by Пользователь on 20.03.2015.
 */
@Service("PizzaService")
public class PizzaService implements iPizzaService {
    @Autowired
    //без @Qualifier может быть неоднозначность выбора
    @Qualifier("pizzaRepository")
    iPizzaRepository pizzaRepository = null;

    public PizzaService() {
    }

    public PizzaService(iPizzaRepository repository) {
        this.pizzaRepository = repository;
    }

    @Override
    public long setPizza(Pizza pizza) {
        return pizzaRepository.setPizza(pizza);
    }

    @Override
    public void setPizza(List<Pizza> pizzas) {
        pizzaRepository.setPizza(pizzas);
    }

    @Override
    public Pizza getPizza(long id) {
        return pizzaRepository.getPizza(id);
    }

    @Override
    public List<Pizza> getAll() {
        return pizzaRepository.getAll();
    }

    @Override
    public void mergePizza(Pizza pizza) {
        pizzaRepository.mergePizza(pizza);
    }

    @Override
    public void deletePizza(Pizza pizza) {
        pizzaRepository.deletePizza(pizza);
    }

    @Override
    public void deletePizza(long id) {
        pizzaRepository.deletePizza(id);
    }
}
