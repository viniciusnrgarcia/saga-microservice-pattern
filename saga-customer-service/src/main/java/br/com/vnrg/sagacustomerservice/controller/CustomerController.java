package br.com.vnrg.sagacustomerservice.controller;

import br.com.vnrg.sagacustomerservice.openapi.api.CustomersApi;
import br.com.vnrg.sagacustomerservice.openapi.model.Customer;
import br.com.vnrg.sagacustomerservice.openapi.model.ModelApiResponse;
import br.com.vnrg.sagacustomerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
class CustomerController implements CustomersApi {

    private final CustomerService service;

    CustomerController(CustomerService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<ModelApiResponse> addCustomer(Customer customer) {
        this.service.createCustomer(customer);
        ModelApiResponse response = new ModelApiResponse();
        return ResponseEntity.ok(response);
    }
}
