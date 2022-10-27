package br.edu.ifgoiano.customerbatchsnct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifgoiano.customerbatchsnct.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

