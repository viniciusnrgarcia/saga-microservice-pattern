package br.com.vnrg.sagaorderservice.mapper;

import br.com.vnrg.sagaorderservice.entity.OrderStateEntity;
import br.com.vnrg.sagaorderservice.openapi.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderTypeMapper {

    OrderTypeMapper INSTANCE = Mappers.getMapper(OrderTypeMapper.class);

    @Mapping(target = "id", source = "orderType")
    public OrderStateEntity toOrderStateEntity(Order order);
}
