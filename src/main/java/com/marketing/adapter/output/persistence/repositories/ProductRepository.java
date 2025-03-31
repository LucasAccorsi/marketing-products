package com.marketing.adapter.output.persistence.repositories;

import com.marketing.adapter.output.persistence.entity.ProductEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ProductRepository extends CrudRepository<ProductEntity, String> {

}