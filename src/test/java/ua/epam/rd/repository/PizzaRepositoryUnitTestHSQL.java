package ua.epam.rd.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.rd.domain.Pizza;
import ua.epam.rd.domain.PizzaType;
import ua.epam.rd.repository.template.UTRepositoryTestsTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PizzaRepositoryUnitTestHSQL extends UTRepositoryTestsTemplate {

    @Autowired
    private iPizzaRepository pizzaRepository;

    @Test
    public void setPizzaTest() {
        Pizza pizza = new Pizza();
        pizza.setName("Meet");
        pizza.setType(PizzaType.SALYAMI);
        pizza.setPrice(123);

        Long id = pizzaRepository.setPizza(pizza);
        System.out.println("Pizza id=" + id);
        assertNotNull(id);
    }

    @Test
    public void setPizzaListTest() {
        Pizza pizza1 = new Pizza();
        pizza1.setName("Meet");
        pizza1.setType(PizzaType.SALYAMI);
        pizza1.setPrice(123);

        Pizza pizza2 = new Pizza();
        pizza2.setName("Meet");
        pizza2.setType(PizzaType.MARGARITA);
        pizza2.setPrice(123);

        List<Pizza> pizzaList = new ArrayList<Pizza>(2);
        pizzaList.add(pizza1);
        pizzaList.add(pizza2);

        pizzaRepository.setPizza(pizzaList);

        System.out.println("pizza1 id=" + pizza1.getID() + " pizza1 id=" + pizza2.getID());
        assertNotEquals(pizzaList.get(0).getID(), pizzaList.get(1).getID());
    }

    @Test
    public void getPizzaTest() {
        Pizza pizza1 = new Pizza();
        pizza1.setName("Meet");
        pizza1.setType(PizzaType.SALYAMI);
        pizza1.setPrice(123);

        pizzaRepository.setPizza(pizza1);

        Pizza pizza2 = pizzaRepository.getPizza(pizza1.getID());

        System.out.println("Must be equal:");
        System.out.println(pizza1);
        System.out.println(pizza2);

        assertEquals(pizza1, pizza2);
    }

    @Test
    public void getAllTest() {
        List<Pizza> pizzaList = pizzaRepository.getAll();
        int size = pizzaList.size();
        System.out.println("Pizzas in repository: " + size);


        Pizza pizza1 = new Pizza();
        pizza1.setName("Meet");
        pizza1.setType(PizzaType.SALYAMI);
        pizza1.setPrice(123);

        Pizza pizza2 = new Pizza();
        pizza2.setName("Meet");
        pizza2.setType(PizzaType.MARGARITA);
        pizza2.setPrice(123);

        pizzaList = new ArrayList<Pizza>(2);
        pizzaList.add(pizza1);
        pizzaList.add(pizza2);
        pizzaRepository.setPizza(pizzaList);

        pizzaList = pizzaRepository.getAll();
        size += 2;
        System.out.println("Must be " + size + " pizzas in repository");
        System.out.println(pizzaList.size());
        assertEquals(size, pizzaList.size());
    }

    @Test
    public void mergePizza() {
        Integer oldPrice = 100;
        Integer newPrice = 500;

        Pizza pizza = new Pizza();
        pizza.setName("Meet");
        pizza.setType(PizzaType.SALYAMI);
        pizza.setPrice(oldPrice);

        long id = pizzaRepository.setPizza(pizza);
        System.out.println("old id = " + id);


        pizza.setPrice(newPrice);
        pizzaRepository.mergePizza(pizza);

        System.out.println("new id = " + id);
        assertEquals(id, pizza.getID());

        System.out.println("new price = " + pizza.getPrice());
        assertEquals(newPrice, pizza.getPrice());
    }

    @Test
    public void deletePizza() {
        Pizza pizza = new Pizza();
        pizza.setName("Meet");
        pizza.setType(PizzaType.SALYAMI);
        pizza.setPrice(123);

        long id = pizzaRepository.setPizza(pizza);
        pizzaRepository.deletePizza(id);
        Pizza pizza2 = pizzaRepository.getPizza(id);

        assertNull(pizza2);
    }
}