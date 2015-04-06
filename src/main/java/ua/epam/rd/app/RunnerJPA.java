package ua.epam.rd.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.rd.domain.*;
import ua.epam.rd.sevice.iCustomersService;
import ua.epam.rd.sevice.iOrderService;
import ua.epam.rd.sevice.iPizzaService;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Пользователь on 27.03.2015.
 */
public class RunnerJPA {
    public static void main(String[] args) {

        ConfigurableApplicationContext appContext
                = new ClassPathXmlApplicationContext("springConfig.xml");

        //iPizzaRepository pizzaRepository
        // = appContext.getBean("pizzaRepository", iPizzaRepository.class);

        iPizzaService pizzaService = appContext.getBean("pizzaService", iPizzaService.class);

        Pizza pizza = new Pizza();
        pizza.setName("Oliva");
        pizza.setType(PizzaType.CHEESE);
        pizza.setPrice(123);

        System.out.println("Before: " + pizza);
        pizzaService.setPizza(pizza);

        System.out.println("After: " + pizza);

        List<Pizza> plist = new LinkedList<Pizza>();
        plist = pizzaService.getAll();
        for (Pizza p : plist) {
            System.out.println(p);
        }

        //iCustomerRepository customerRepository = appContext.getBean("customerRepository", iCustomerRepository.class);

        iCustomersService customerService = appContext.getBean("customerService", iCustomersService.class);

        Customer customer = new Customer();
        customer.setName("Mr Holmes");
        customer.setAdress("Baker str.");
        customer.setPhone("322 233");

        customerService.setCustomer(customer);
        for (Customer c : customerService.getAll()) {
            System.out.println(c);
        }

        iOrderService orderService = appContext.getBean("orderService", iOrderService.class);

        Order order = new Order();
        order.addPizzas(pizzaService.getPizza(1), 1);
        order.addPizzas(pizzaService.getPizza(2), 2);
        order.addPizzas(pizzaService.getPizza(3), 3);
        order.addPizzas(pizzaService.getPizza(1), 4);
        order.setOrderCutomer(customer);

        System.out.println("Before");
        System.out.println(order);

        System.out.println("Init");
        orderService.setOrder(order);
        System.out.println(order);

        System.out.println("After");
        order.changeStatus(OrderStatus.COMPLETED);
        orderService.mergeOrder(order);
        for (Order o : orderService.getAllOrders()) {
            System.out.println(o);
        }

        System.out.println("After cleaning type 1");
        order.removeByPizzaType(pizzaService.getPizza(1));
        orderService.mergeOrder(order);
        for (Order o : orderService.getAllOrders()) {
            System.out.println(o);
        }

        //хуита! но без нее javax.persistence.EntityNotFoundException
        order = orderService.getOrder(order.getId());
        orderService.mergeOrder(order);


        System.out.println("Orders by customer");
        order.removeAllPizzas();
        orderService.mergeOrder(order);
        for (Order o : orderService.getOrdersByCustomer(customer.getId())) {
            System.out.println(o);
        }

        appContext.close();
    }
}