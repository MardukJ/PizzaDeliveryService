package ua.epam.rd.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Пользователь on 03.04.2015.
 */

@Entity(name = "Customer")
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    long id;

    @Column(name = "name")
    @NotNull
    private String name = "";

    @Column(name = "phones")
    @NotNull
    private String phone = "";

    @Column(name = "adresses")
    @NotNull
    private String adress = "";

    @Temporal(value = TemporalType.DATE)
    @Column(name = "registration_date")
    private Calendar registrationDate = new GregorianCalendar();

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", registrationDate=" + registrationDate.getTimeInMillis() +
                '}';
    }
}
