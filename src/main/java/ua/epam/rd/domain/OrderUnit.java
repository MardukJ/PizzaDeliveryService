package ua.epam.rd.domain;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;

/**
 * Created by Пользователь on 04.04.2015.
 */
@Scope("prototype")
@Entity(name = "orderUnit")
@Table(name = "order_units")
public class OrderUnit {

    @Id
    @GeneratedValue
    @Column(name = "order_unit_id")
    private long id = 0;

    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderUnitOwner;

    public OrderUnit() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Order getOrderUnitOwner() {
        return orderUnitOwner;
    }

    public void setOrderUnitOwner(Order orderOwner) {
        this.orderUnitOwner = orderOwner;
    }

    @Override
    public String toString() {
        return "OrderUnit{" +
                "id=" + id +
                ", amount=" + amount +
                ", pizza=" + pizza +
                //", orderOwner=" + orderOwner +
                '}';
    }
}
