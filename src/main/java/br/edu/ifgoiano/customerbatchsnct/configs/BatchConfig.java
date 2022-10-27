package br.edu.ifgoiano.customerbatchsnct.configs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.ifgoiano.customerbatchsnct.entities.Customer;
import br.edu.ifgoiano.customerbatchsnct.processors.CustomerProcessor;
import br.edu.ifgoiano.customerbatchsnct.readers.CustomerReader;
import br.edu.ifgoiano.customerbatchsnct.writer.CustomerWriter;

@Configuration
public class BatchConfig {
	
	@Autowired
	  private JobBuilderFactory jobBuilderFactory;
	 
	  @Autowired
	  private StepBuilderFactory stepBuilderFactory;
	  
	  @Bean
	  public Job customerJob(final Step customerStep) {
	    return jobBuilderFactory.get("customerJob")
	        .start(customerStep)
	        .build();
	  }
	 
	  @Bean
	  public Step customerStep(CustomerReader customerReader,
			  CustomerProcessor customerProcessor,
			  CustomerWriter customerWriter) {
	    return stepBuilderFactory.get("customerStep")
	        .<Customer, Customer>chunk(1)
	        .reader(customerReader)
	        .processor(customerProcessor)
	        .writer(customerWriter)
	        .build();
	  }
	 
	  

}
