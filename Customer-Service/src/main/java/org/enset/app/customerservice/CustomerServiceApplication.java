package org.enset.app.customerservice;

import org.enset.app.customerservice.entities.Customer;
import org.enset.app.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("Youness").email("youness@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Yassine").email("yassine@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Mohammed").email("mohammed@gmail.com")
                    .build());
            customerRepository.findAll().forEach(c->{
                System.out.println("===================");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
                System.out.println("===================");
            });

        };
    }
}
