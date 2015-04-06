package ua.epam.rd.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.rd.domain.Order;
import ua.epam.rd.domain.Pizza;
import ua.epam.rd.sevice.iOrderService;
import ua.epam.rd.sevice.iPizzaService;

import java.util.Date;
import java.util.List;

/**
 * Created by Пользователь on 18.03.2015.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("Hello");
        long time = -new Date().getTime();
        //ApplicationContext repositoriesContext = new ClassPathXmlApplicationContext("springRepository.xml");
        ConfigurableApplicationContext appContex = new ClassPathXmlApplicationContext(new String[]{"springConfig.xml"});///,repositoriesContext);


        time += new Date().getTime();
        System.out.println("Spring context creation time  = " + time + " ms");

        /* 1 */
        //iPizzaRepository pizzaRepository = new PizzaRepositoryTest();
        //iPizzaService pizzaService = new PizzaServiceTest(pizzaRepository);

        /* 2 */
        //iPizzaRepository pizzaRepository = appContex.getBean("pizzaRepositoryTest",iPizzaRepository.class);
        //iPizzaService pizzaService = new PizzaServiceTest(pizzaRepository);

        /* 3 */
        iPizzaService pizzaService = appContex.getBean("pizzaServiceTest", iPizzaService.class);

        List<Pizza> pizzas = pizzaService.getAll();

        System.out.println("Menu:");
        pizzas.stream().forEach(System.out::println);

        /* 1 */
        //iOrderRepository orderRepository= new OrderRepositoryTest();
        //iOrderService orderService = new OrderServiceTest(orderRepository);

        /* 2 */
        //iOrderRepository orderRepository= appContex.getBean("orderRepositoryTest",iOrderRepository.class);
        //iOrderService orderService = new OrderServiceTest(orderRepository);

        /* 3 */
        iOrderService orderService = appContex.getBean("orderServiceTest", iOrderService.class);

        Order newOrder = orderService.createOrder();//orderService.createNewOrder();
        ///newOrder.addItem(pizzas.get(3));
        orderService.setOrder(newOrder);

        Order newOrder1 = orderService.createOrder();//orderService.createNewOrder();
        ///newOrder1.addItem(pizzas.get(2));
        orderService.setOrder(newOrder1);

        ///List<Order> orders = orderService.getAllOrders();
        ///orders.stream().forEach(System.out::println);

    }

}
