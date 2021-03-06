package br.com.vnrg.sagaorderservice.repository.mapper;

import br.com.vnrg.sagaorderservice.domain.OrderDomain;
import br.com.vnrg.sagaorderservice.openapi.model.Order;
import br.com.vnrg.sagaorderservice.repository.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(imports = UUID.class, componentModel = "string",
        uses = {OrderStateMapper.class,
                OrderTypeMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    // @Mapping(target = "orderState.id", source = "orderState")
    // @Mapping(target = "orderType.id", source = "orderType")
    public OrderEntity toOrderEntity(Order order);

    @Mapping(source = "id", target = "orderId")
    public OrderDomain toOrderDomain(OrderEntity orderEntity);

}
