package br.edu.ifgoiano.customerbatchsnct.readers;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Component;

import br.edu.ifgoiano.customerbatchsnct.entities.Customer;
import br.edu.ifgoiano.customerbatchsnct.mappers.CustomerMapper;

@Component
public class CustomerReader extends FlatFileItemReader<Customer> {
	 
	  public CustomerReader() {
	    DefaultLineMapper<Customer> defaultLineMapper = new DefaultLineMapper<>();
	    defaultLineMapper.setLineTokenizer(new DelimitedLineTokenizer());
	    defaultLineMapper.setFieldSetMapper(new CustomerMapper());
	    this.setLineMapper(defaultLineMapper);
	    this.setResource(new PathResource("data/customers.dat"));
	  }
	}