package com.zeek.repositories;

import com.zeek.springdataentity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by weibo_li on 16/5/17.
 */
public interface PersonRepository extends MongoRepository<Person, Long> {

    List<Person> findByName(String name);
}
