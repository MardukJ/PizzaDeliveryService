package ua.epam.rd.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

/**
 * Created by Пользователь on 20.03.2015.
 */
@Entity(name = "Pizza")
@Table(name = "pizzas")
public class Pizza {
    @NotNull
    @Column(name = "name")
    String name = "";
    @Column(name = "price")
    Integer price = -1;
    @Enumerated(EnumType.STRING)
    PizzaType type = PizzaType.MARGARITA;
    @Id
    @Column(name = "pizza_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;


    public Pizza() {
    }

    public Pizza(String name, int price, PizzaType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public PizzaType getType() {
        return type;
    }

    public void setType(PizzaType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pizza pizza = (Pizza) o;

        return ID == pizza.ID;

    }
}
