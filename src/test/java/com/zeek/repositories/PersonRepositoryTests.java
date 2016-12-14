package com.zeek.repositories;

import com.zeek.springdataentity.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by weibo_li on 16/5/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-repository.xml")
public class PersonRepositoryTests {

    private static final Log log = LogFactory.getLog(PersonRepositoryTests.class);

    @Autowired
    PersonRepository repository;

    @Test
    public void findAllTest() {

        List<Person> person = repository.findAll();

        log.info(person);

    }

    @Test
    public void customFindTest() {

        List<Person> person = repository.findByName("Joe");

        log.info(person);

    }
}
