package com.du.Repository;

import com.du.entity.InfoSet;
import com.du.resp.BaseResp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author duqifeng
 * 2018/4/24 18:07
 */
@RepositoryRestResource(collectionResourceRel = "infoSet", path = "infoSet")
public interface InfoSetRepository extends MongoRepository<BaseResp<InfoSet>, Long> {
}
