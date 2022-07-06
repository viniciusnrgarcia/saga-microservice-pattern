package br.com.vnrg.sagaproductservice.repository.mapper;

import br.com.vnrg.sagaproductservice.domain.OrderDomain;
import br.com.vnrg.sagaproductservice.repository.entity.ProductOrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(imports = UUID.class, componentModel = "string",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductOrderMapper {

    ProductOrderMapper INSTANCE = Mappers.getMapper(ProductOrderMapper.class);

    public ProductOrderEntity toEntity(OrderDomain order);

}
