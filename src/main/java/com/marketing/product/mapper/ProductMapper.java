package com.marketing.product.mapper;

import com.marketing.adapter.input.rest.contract.input.ProductCreateContract;
import com.marketing.adapter.input.rest.contract.input.ProductUpdateContract;
import com.marketing.adapter.input.rest.contract.output.ProductContract;
import com.marketing.adapter.output.persistence.entity.ProductEntity;
import com.marketing.product.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product productCreateContractToDomain(final ProductCreateContract productCreateContract);

    Product productUpdateContractToDomain(final String name, final ProductUpdateContract productUpdateContract);

    ProductEntity productCreateDomainToEntity(final Product product);

    ProductContract productCreateDomainToContract(final Product product);

    Product productCreateEntityToDomain(final ProductEntity productEntity);
}
