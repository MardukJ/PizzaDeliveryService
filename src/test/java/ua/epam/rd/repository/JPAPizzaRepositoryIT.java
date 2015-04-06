/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.rd.repository;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.rd.domain.Pizza;
import ua.epam.rd.domain.PizzaType;
import ua.epam.rd.repository.template.ITRepositoryTestsTemplate;

import static org.junit.Assert.assertNotNull;

/**
 * @author andrii
 */
public class JPAPizzaRepositoryIT extends ITRepositoryTestsTemplate {

    @Autowired
    private iPizzaRepository pizzaRepository;

    @Ignore
    @Test
    public void testSomeMethod() {
        Pizza pizza = new Pizza();
        pizza.setName("Meet");
        pizza.setType(PizzaType.SALYAMI);
        pizza.setPrice(123);

        Long id = pizzaRepository.setPizza(pizza);
        System.out.println("testSomeMethod: realDB: id = " + id);

        assertNotNull(id);
        //fail("The test case is a prototype.");
    }

}
