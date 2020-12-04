package org.starrier.sky.ladder.data.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author starrier
 * @date 2020/12/3
 */
public interface StudentRepository extends MongoRepository<Student, Integer> {
}
