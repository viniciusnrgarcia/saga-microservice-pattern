package br.com.vnrg.sagaproductservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductService {

    public void reserveProduct() {
        log.info("reserved-product completed");
    }

    public void createProductOrder() {
        log.info("created-product-order completed");
    }
}
