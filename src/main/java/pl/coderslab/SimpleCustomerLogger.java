package pl.coderslab;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SimpleCustomerLogger implements CustomerLogger {
    @Override
    public void log() {
        System.out.println("Simple customer logger:");
        System.out.println("Local date/ time: " + LocalDateTime.now());
    }
}
