package com.zeek;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.zeek.springdataentity.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.UUID;

/**
 * Created by weibo_li on 16/5/13.
 *  不带用户名和密码认证的连接测试
 */
public class SpringDataMongoDBTest {

    private static final Log log = LogFactory.getLog(SpringDataMongoDBTest.class);

    private static MongoOperations mongoOps = null;

    @BeforeClass
    public static void init(){
        //已经过时的方法
        //mongoOps = new MongoTemplate(new Mongo(), "test");

        //使用MongoClient
        mongoOps = new MongoTemplate(new MongoClient(), "test");
    }



    @Test
    public void testInsert(){

        mongoOps.insert(new Person(UUID.randomUUID().toString(), "Joe", 34));

    }

    @Test
    public void testFind(){
        List<Person> persons = mongoOps.find(new Query(), Person.class);

        log.info(persons);
    }

    @Test
    public void testUpdate(){

    }

}
