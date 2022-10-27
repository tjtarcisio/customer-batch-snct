package br.edu.ifgoiano.customerbatchsnct.processors;

import java.time.LocalDateTime;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import br.edu.ifgoiano.customerbatchsnct.entities.Customer;

@Component
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
	 
	  @Override
	  public Customer process(final Customer customer) {
	  final var creationDate = LocalDateTime.now();  
	    
      customer.setCreationDate(creationDate);
      return customer;
	  }
	}