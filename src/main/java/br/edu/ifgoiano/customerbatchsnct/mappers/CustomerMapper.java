package br.edu.ifgoiano.customerbatchsnct.mappers;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.boot.context.properties.bind.BindException;

import br.edu.ifgoiano.customerbatchsnct.entities.Customer;

public class CustomerMapper implements FieldSetMapper<Customer> {
	 
	  public Customer mapFieldSet(FieldSet fieldSet) throws BindException {
	    Customer customer = new Customer();
	    customer.setFullName(fieldSet.readString(0));
	    customer.setDocumentNumber(fieldSet.readString(1));
	    return customer;
	  }
	}
