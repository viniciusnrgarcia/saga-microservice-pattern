package br.com.vnrg.sagacustomerservice.service;

import br.com.vnrg.sagacustomerservice.mapper.CustomerMapper;
import br.com.vnrg.sagacustomerservice.openapi.model.Customer;
import br.com.vnrg.sagacustomerservice.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void createCustomer(Customer customer) {
        log.info("Creating new customer: {}", customer.toString());
        var entity = CustomerMapper.INSTANCE.toCustomerEntity(customer);
        entity.setCustomerStatus(0);
        entity.setUserCreated("saga-customer-service");
        entity.setUserUpdated("saga-customer-service");
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        this.repository.save(entity);
    }
}
