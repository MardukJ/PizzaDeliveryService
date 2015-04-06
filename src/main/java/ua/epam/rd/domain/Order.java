package ua.epam.rd.domain;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Пользователь on 20.03.2015.
 */

@Entity
@Table(name = "orders")
public class Order {
    @Deprecated
    static int idGenerator = -1;

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    long id;

    @Column(name = "order_creation_time")
    @Temporal(value = TemporalType.TIMESTAMP)
    @NotNull
    Calendar orederCreationTime = new GregorianCalendar();

    @Column(name = "order_accept_time")
    @Temporal(value = TemporalType.TIMESTAMP)
    @NotNull
    Calendar acceptTime = Calendar.getInstance();

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    OrderStatus status = OrderStatus.NEW;

    @Column(name = "total_value")
    Long totalValue = new Long(0);

    @OneToMany(mappedBy = "orderUnitOwner", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<OrderUnit> order_units = new LinkedList<OrderUnit>();

    @ManyToOne
    @NotNull
    @JoinColumn(name = "customer_id")
    private Customer orderCutomer;// = new Customer();

    public Order() {
    }

    public Order(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getOrederCreationTime() {
        return orederCreationTime;
    }

    public void setOrederCreationTime(Calendar orederCreationTime) {
        this.orederCreationTime = orederCreationTime;
    }

    public Calendar getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Calendar acceptTime) {
        this.acceptTime = acceptTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Long getTotalValue() {
        return totalValue;
    }

    public Customer getOrderCutomer() {
        return orderCutomer;
    }

    public void setOrderCutomer(Customer orderCutomer) {
        this.orderCutomer = orderCutomer;
    }

    public void addPizzas(Pizza pizza, int quantity) {
        /*quantity < 0 в параметре- допускается. но не допустимо пристутсвие в заказе отрицательного количества пиц */
        if ((order_units == null) || (order_units.size() == 0)) {
            //гарантированное добавление нового заказа
            if (quantity <= 0) return;//throw new IllegalArgumentException();????
            addNewPizza(pizza, quantity);
        } else {
            //поиск пиццы в заказе
            for (OrderUnit ou : order_units) {
                if (pizza.equals(ou.getPizza())) {
                    ou.setAmount(ou.getAmount() + quantity);
                    if (ou.getAmount() <= 0) {
                        order_units.remove(ou);
                    }
                    calculateTotalValue();
                    return;
                }
            }

            //нет такой пиццы в заказе
            if (quantity <= 0) return;//throw new IllegalArgumentException();????
            addNewPizza(pizza, quantity);
        }
    }

    private void addNewPizza(Pizza pizza, int quantity) {
        OrderUnit orderUnit = new OrderUnit();
        orderUnit.setAmount(quantity);
        orderUnit.setPizza(pizza);
        orderUnit.setOrderUnitOwner(this);

        if (order_units == null) {
            order_units = new LinkedList<OrderUnit>();
        }

        //хуита! но каскадная запись упорно не работает
        order_units.add(orderUnit);

        calculateTotalValue();
    }

    public void removeAllPizzas() {
        if (order_units != null) {
            order_units.clear();
        }
        calculateTotalValue();
    }

    public void removeByPizzaType(Pizza pizza) {
        if (order_units != null) {
            for (OrderUnit ou : order_units) {
                if (pizza.equals(ou.getPizza())) {
                    order_units.remove(ou);
                    calculateTotalValue();
                    return;
                }
            }

        }
    }

    public void changeStatus(OrderStatus newStatus) {
        if (newStatus.getI() > status.getI()) {
            if ((status == OrderStatus.NEW) && (newStatus != OrderStatus.CANELED)) {
                if (totalValue == 0) {
                    throw new IllegalStateException("Order status change error - order is empty");
                } else if ((orderCutomer == null)) {
                    throw new IllegalStateException("Order status change error - no customer");
                }
            }
            status = newStatus;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void calculateTotalValue() {
        totalValue = 0l;
        if (order_units != null) {
            for (OrderUnit ou : order_units) {
                totalValue += (ou.getAmount() * ou.getPizza().getPrice());
            }
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "\n\tid=" + id +
                ", \n\tcustomer=" + orderCutomer +
                ", \n\torederCreationTime=" + orederCreationTime.getTimeInMillis() +
                ", \n\tacceptTime=" + acceptTime.getTimeInMillis() +
                ", \n\tstatus=" + status +
                ", \n\ttotal_value=" + getTotalValue() +
                ", \n\torder_units_class=" + order_units.getClass() +
                ", \n\torder_units=" + order_units +
                '}';
    }
}
