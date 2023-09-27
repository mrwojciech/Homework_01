package pl.coderslab;

import org.springframework.context.annotation.*;

/**
 * Hello world!
 */

@ComponentScan(basePackages = "pl.coderslab")
@Configuration
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);

   //     SimpleCustomerLogger logger = context.getBean(SimpleCustomerLogger.class);

        FileCustomerLogger fileLogger = context.getBean(FileCustomerLogger.class);

   //     logger.log();

        fileLogger.log();

        CustomerRepository repository = context.getBean(CustomerRepository.class);
        repository.addClient(new Customer("1", "Jan", "Pan"));
        Customer customer = new Customer("2", "Janek", "Panek");
        repository.addClient(customer);
        repository.printClients();
        repository.removeClient(customer);
        repository.printClients();

        context.close();
    }


}
