package br.com.vnrg.sagapaymentservice.repository.mapper;

import br.com.vnrg.sagapaymentservice.domain.OrderDomain;
import br.com.vnrg.sagapaymentservice.repository.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentOrderMapper {

    PaymentOrderMapper INSTANCE = Mappers.getMapper(PaymentOrderMapper.class);

    public PaymentEntity toEntity(OrderDomain order);

}
