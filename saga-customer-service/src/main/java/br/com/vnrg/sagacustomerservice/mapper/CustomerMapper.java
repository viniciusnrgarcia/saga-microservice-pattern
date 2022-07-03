package br.com.vnrg.sagacustomerservice.mapper;

import br.com.vnrg.sagacustomerservice.entity.CustomerEntity;
import br.com.vnrg.sagacustomerservice.openapi.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(imports = UUID.class, componentModel = "string", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    // @Mapping(target = "orderState.id", source = "orderState")
    // @Mapping(target = "orderType.id", source = "orderType")
    public CustomerEntity toCustomerEntity(Customer order);

}
