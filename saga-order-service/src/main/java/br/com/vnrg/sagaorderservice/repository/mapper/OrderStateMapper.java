package br.com.vnrg.sagaorderservice.repository.mapper;

import br.com.vnrg.sagaorderservice.repository.entity.OrderStateEntity;
import br.com.vnrg.sagaorderservice.openapi.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderStateMapper {

    OrderStateMapper INSTANCE = Mappers.getMapper(OrderStateMapper.class);

    @Mapping(target = "id", source = "orderState")
    public OrderStateEntity toOrderStateEntity(Order order);
}
