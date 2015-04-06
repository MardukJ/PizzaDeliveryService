package ua.epam.rd.repository.hardcode;

import ua.epam.rd.domain.Pizza;
import ua.epam.rd.repository.iPizzaRepository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Пользователь on 20.03.2015.
 */
public class PizzaRepositorySimple implements iPizzaRepository {

    List<Pizza> pizzas = new LinkedList<>();

    PizzaRepositorySimple() {

    }

    @Override
    public void deletePizza(Pizza pizza) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public long setPizza(Pizza pizza) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public void setPizza(List<Pizza> pizzas) {
        pizzas.addAll(pizzas);
    }

    @Override
    public Pizza getPizza(long id) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public void mergePizza(Pizza pizza) {
        throw new UnsupportedOperationException("");
    }

    public List<Pizza> getAll() {
        return pizzas;
    }

    @Override
    public void deletePizza(long id) {
        throw new UnsupportedOperationException("");
    }
}
