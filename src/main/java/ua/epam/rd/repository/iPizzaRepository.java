package ua.epam.rd.repository;

import ua.epam.rd.domain.Pizza;

import java.util.List;

/**
 * Created by Пользователь on 20.03.2015.
 */
public interface iPizzaRepository {
    long setPizza(Pizza pizza);

    void setPizza(List<Pizza> pizza);

    Pizza getPizza(long id);

    List<Pizza> getAll();

    void mergePizza(Pizza pizza);

    void deletePizza(Pizza pizza);

    void deletePizza(long id);
}
