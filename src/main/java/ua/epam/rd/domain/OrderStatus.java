package ua.epam.rd.domain;

/**
 * Created by Пользователь on 04.04.2015.
 */
public enum OrderStatus {
    NEW(1), SUBMITTED(2), ACCEPTED(3), IN_OVEN(4), DELIVERY(5), COMPLETED(6), CANELED(100);
    private int i;

    OrderStatus(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
