package com.scratchwerk.repo;

import com.scratchwerk.models.Mentor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MentorRepository extends MongoRepository<Mentor, String> {

}
