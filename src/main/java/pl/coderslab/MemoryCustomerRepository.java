package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryCustomerRepository implements CustomerRepository {

    List<Customer> customerList = new ArrayList<>();

    final CustomerLogger customerLogger;

    @Autowired
    public MemoryCustomerRepository(CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
        customerLogger.log();
    }

    @Override
    public void addClient(Customer customer) {
        customerList.add(customer);
        System.out.println("Adding customer = " + customer);
        customerLogger.log();
    }

    @Override
    public void removeClient(Customer customer) {
        customerList.remove(customer);
        System.out.println("Removing customer = " + customer);
        customerLogger.log();
    }

    @Override
    public List<Customer> printClients() {
        System.out.println("customerList = " + customerList);
        return customerList;
    }
}
