package br.com.vnrg.sagaproductservice.service;

import br.com.vnrg.sagaproductservice.domain.Order;
import br.com.vnrg.sagaproductservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void reserveProduct(final Order order) {
        var r = repository.updateProductItemReserved(order.getProductId());
        if (r > 0) {
            log.info("reserved-product");
            // TODO create event
        } else {
            log.info("product-not-available");
            // TODO create event
        }
        log.info("reserved-product completed");
    }

    public void createProductOrder() {
        log.info("created-product-order completed");
    }
}
