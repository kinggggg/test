package com.zeek;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.zeek.springdataentity.Address;
import com.zeek.springdataentity.Person;
import com.zeek.springdataentity.PersonAdvance;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by weibo_li on 16/5/13.
 * 带用户名和密码认证的连接测试
 */
public class SpringDataMongoDBTest2 {

    private static final Log log = LogFactory.getLog(SpringDataMongoDBTest2.class);

    private static MongoOperations mongoOps = null;

    @BeforeClass
    public static void init(){
        //无法正常获得权限
        UserCredentials userCredentials = new UserCredentials("zjy", "zjy");
        //MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(new Mongo(), "test", userCredentials);

        //
        List<ServerAddress> list = new ArrayList<>();
        list.add(new ServerAddress("127.0.0.1", 27017));


        List<MongoCredential> list2 = new ArrayList<>();
        list2.add(MongoCredential.createCredential("zjy", "test", "zjy".toCharArray()));



        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(new MongoClient(list, list2), "test");
        mongoOps = new MongoTemplate(mongoDbFactory);
    }



    @Test
    public void testInsert(){

        mongoOps.save(new Person(UUID.randomUUID().toString(), "tom", 12));


    }

    @Test
    public void testInsertPersonAdvance(){

        PersonAdvance p = new PersonAdvance();
        p.setId(UUID.randomUUID().toString());
        p.setName("lisi");
        p.setAge(22);

        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        address.setName("beijing");

        p.setAddress(address);


        mongoOps.save(p);


    }

    @Test
    public void testFind(){

        List<Person> persons = mongoOps.find(new Query(), Person.class);

        for(Person person : persons){
            log.info(person);
        }

        log.info("-------------------");

        List<Person> result = mongoOps.find(new BasicQuery("{name:'Joe'}"), Person.class, "person");

        log.info(result);

    }

    @Test
    public void testUpdate(){
        mongoOps.updateFirst(new BasicQuery("{name:'Joe'}"), new BasicUpdate("{name:'jerry'}"), Person.class);
    }

    @Test
    public void testDelete(){
        mongoOps.remove(new BasicQuery("{name:'jerry'}"), Person.class);
    }

}
