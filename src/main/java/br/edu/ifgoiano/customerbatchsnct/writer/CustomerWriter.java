package br.edu.ifgoiano.customerbatchsnct.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifgoiano.customerbatchsnct.entities.Customer;
import br.edu.ifgoiano.customerbatchsnct.repositories.CustomerRepository;

@Component
public class CustomerWriter implements ItemWriter<Customer> {
	
	@Autowired
    private CustomerRepository repository;

    @Override
    public void write(List<? extends Customer> list) {
        repository.saveAll(list);
        
        final var customers = repository.findAll();
    	
        System.out.println("=====================");

        customers.forEach(customer -> {
        	System.out.println(customer.toString());
        });
    }
}