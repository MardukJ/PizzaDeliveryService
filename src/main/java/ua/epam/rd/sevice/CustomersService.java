package ua.epam.rd.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.epam.rd.domain.Customer;
import ua.epam.rd.repository.iCustomerRepository;

import java.util.List;

/**
 * Created by Пользователь on 04.04.2015.
 */
@Service("customerService")
public class CustomersService implements iCustomersService {

    @Autowired
    @Qualifier("customerRepository")
    iCustomerRepository customersRepository;

    public CustomersService() {
    }

    public CustomersService(iCustomerRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public long setCustomer(Customer customer) {
        return customersRepository.setCustomer(customer);
    }

    @Override
    public void setCustomer(List<Customer> customers) {
        customersRepository.setCustomer(customers);
    }

    @Override
    public Customer getCustomer(long id) {
        return customersRepository.getCustomer(id);
    }

    @Override
    public List<Customer> getAll() {
        return customersRepository.getAll();
    }

    @Override
    public void mergeCustomer(Customer customer) {
        customersRepository.mergeCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customersRepository.deleteCustomer(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        customersRepository.deleteCustomer(id);
    }
}
