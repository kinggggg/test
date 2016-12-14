package com.zeek;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.zeek.springdataentity.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by weibo_li on 16/5/13.
 */
public class SpringDataMongoDBTest3 {

    private static final Log log = LogFactory.getLog(SpringDataMongoDBTest3.class);

    public static void main(String[] args){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml");
        /*MongoTemplate template = applicationContext
                .getBean(MongoTemplate.class);




        template.save(new Person(UUID.randomUUID().toString(), "tom", 12));

        log.info(template.find(new Query(), Person.class));*/

       /* MongoClient mongoClient = (MongoClient) applicationContext.getBean("mongoClient");
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient, "test");
        MongoOperations mongoOps = new MongoTemplate(mongoDbFactory);

        List<Person> persons = mongoOps.find(new Query(), Person.class);

        for(Person person : persons){
            log.info(person);
        }*/

        MongoTemplate template = applicationContext
                .getBean(MongoTemplate.class);
        log.info(template.find(new Query(), Person.class));

        applicationContext.close();
    }


}
