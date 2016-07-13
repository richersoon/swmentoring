package com.scratchwerk.repo;

import com.scratchwerk.model.Parent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParentRepository extends MongoRepository<Parent, String> {

}
