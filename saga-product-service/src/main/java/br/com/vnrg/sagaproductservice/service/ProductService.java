package br.com.vnrg.sagaproductservice.service;

import br.com.vnrg.sagaproductservice.domain.OrderDomain;
import br.com.vnrg.sagaproductservice.messaging.producer.ProductNotAvailablePublisher;
import br.com.vnrg.sagaproductservice.messaging.producer.ReservedProductPublisher;
import br.com.vnrg.sagaproductservice.repository.ProductOrderRepository;
import br.com.vnrg.sagaproductservice.repository.ProductRepository;
import br.com.vnrg.sagaproductservice.repository.mapper.ProductOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductOrderRepository productOrderRepository;
    private final ProductNotAvailablePublisher productNotAvailablePublisher;
    private final ReservedProductPublisher reservedProductPublisher;

    public ProductService(ProductRepository repository, ProductOrderRepository productOrderRepository, ProductNotAvailablePublisher productNotAvailablePublisher, ReservedProductPublisher reservedProductPublisher) {
        this.repository = repository;
        this.productOrderRepository = productOrderRepository;
        this.productNotAvailablePublisher = productNotAvailablePublisher;
        this.reservedProductPublisher = reservedProductPublisher;
    }

    public void reserveProduct(final OrderDomain order) {
        var rowsUpdated = repository.updateProductItemReserved(order.getProductId());
        if (rowsUpdated == 0) {
            order.setOrderState(7);
            order.setProductItems(0);
            this.productNotAvailablePublisher.send(order);
        }
    }

    public void createProductOrder(final OrderDomain order) {
        if (order.getOrderState() != 7) {
            var entity = ProductOrderMapper.INSTANCE.toEntity(order);
            // 0-pendente pagamento, 1-pagamento confirmado, 2-pagamento não autorizado
            entity.setProductOrderStatus(0);
            entity.setUserCreated("saga-product-service");
            entity.setUserUpdated("saga-product-service");
            entity.setCreatedAt(LocalDateTime.now());
            entity.setUpdateAt(LocalDateTime.now());
            this.productOrderRepository.save(entity);
            this.reservedProductPublisher.send(order);
            log.info("reserved-product send {}", order.toString());
        }
    }
}
