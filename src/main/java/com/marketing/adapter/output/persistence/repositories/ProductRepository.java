package com.marketing.adapter.output.persistence.repositories;

import com.marketing.adapter.output.persistence.entity.ProductEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;

@EnableScan
public interface ProductRepository extends CrudRepository<ProductEntity, String> {

    ProductEntity findByName(String name);

    @NonNull
    List<ProductEntity> findAll();
}