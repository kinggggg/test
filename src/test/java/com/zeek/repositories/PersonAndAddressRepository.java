package com.zeek.repositories;

import com.zeek.springdataentity.NoAddresses;
import com.zeek.springdataentity.Person;
import com.zeek.springdataentity.PersonAdvance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by weibo_li on 16/5/17.
 */
public interface PersonAndAddressRepository extends MongoRepository<PersonAdvance, Long> {

    NoAddresses findByName(String name);
}
