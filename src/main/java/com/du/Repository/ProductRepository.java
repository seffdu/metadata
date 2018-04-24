package com.du.Repository;

import com.du.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author duqifeng
 * 2018/4/20 16:29
 */
@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository extends MongoRepository<Product, String> {

}
