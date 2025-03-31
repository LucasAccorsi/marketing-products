package com.marketing.product.mapper;

import com.marketing.adapter.input.rest.contract.input.ProductCreateContract;
import com.marketing.adapter.input.rest.contract.input.ProductUpdateContract;
import com.marketing.adapter.input.rest.contract.output.ProductContract;
import com.marketing.adapter.output.persistence.entity.ProductEntity;
import com.marketing.product.domain.Product;
import com.marketing.product.util.DateTimeUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(imports = {DateTimeUtil.class})
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product productCreateContractToDomain(final ProductCreateContract productCreateContract);

    Product productUpdateContractToDomain(final String name, final ProductUpdateContract productUpdateContract);

    ProductEntity productCreateDomainToEntity(final Product product);

    ProductContract productDomainToContract(final Product product);

    Product productEntityToDomain(final ProductEntity productEntity);

    List<Product> productListEntityToDomain(final List<ProductEntity> productEntity);

    List<ProductContract> productListDomainToContract(final List<Product> productByName);

    @Mapping(target = "name", source = "product.name", defaultExpression = "java(productExistent.getName())")
    @Mapping(target = "status", source = "product.status", defaultExpression = "java(productExistent.getStatus().name())")
    @Mapping(target = "description", source = "product.description", defaultExpression = "java(productExistent.getDescription())")
    @Mapping(target = "imageUrl", source = "product.imageUrl", defaultExpression = "java(productExistent.getImageUrl())")
    @Mapping(target = "price", source = "product.price", defaultExpression = "java(productExistent.getPrice().toString())")
    @Mapping(target = "category", source = "product.category", defaultExpression = "java(productExistent.getCategory().name())")
    @Mapping(target = "createdAt", source = "productExistent.createdAt")
    @Mapping(target = "updatedAt", source = "product.updatedAt")
    ProductEntity productUpdateDomainToEntity(Product product, Product productExistent);

    @Mapping(target = "status", constant = "UNAVAILABLE")
    @Mapping(target = "updatedAt", expression = "java(DateTimeUtil.getDateTimeNow())")
    ProductEntity productUnavailableDomainToEntity(Product productExistent);
}