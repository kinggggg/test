package com.zeek;

import com.google.gson.JsonObject;
import com.mongodb.MongoClient;
import com.zeek.morphia.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.CriteriaContainerImpl;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by weibo_li on 16/5/10.
 */
public class MorphiaTest {

    private Morphia morphia = null;

    private Datastore datastore = null;


    @Before
    public void init() {
        morphia = new Morphia();
        morphia.mapPackage("com.zeek.morphia.entity");
        datastore = morphia.createDatastore(new MongoClient(), "test");
    }

    @Test
    public void deleteTest() {
        datastore.delete(User.class, 10);
    }

    @Test
    public void findAndDeleteTest() {
        User user = datastore.findAndDelete(datastore.createQuery(User.class).filter("age", 23));

//        datastore.find(User.class, "name", "zhangsan")

        System.out.println(user);

    }

    @Test
    public void testSaveJsonObject() {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name","lisi");

        datastore.save(jsonObject);

    }

    @Test
    public void testSave() {

        List<User> users = new ArrayList<User>();

        for (int count = 0; count < 100; count++) {
            User user = new User();
//            user.setId(count);
            user.setName("zhangsan" + count);
            user.setAge(23 + count);
            user.setSalary(34.32f + count);

            users.add(user);
        }

        datastore.save(users);

    }

    /**
     * 如果没有查询到相应的数据的话,morphia返回的值不是null,而是size为0的一个list
     */
    @Test
    public void queryTest1() {
        List<User> users = datastore.createQuery(User.class).filter("salary", 100).asList();
        System.out.println(users);
    }

    /**
     * 通过这种方式在默认的情况下为两个查询条件的关系为and:
     { "$and" : [ { "salary" : 53.31999969482422} , { "salary" : 52.31999969482422}]}
     */
    @Test
    public void queryTest2(){
        Query<User> query = datastore.createQuery(User.class);

        query.criteria("salary").equal(53.31999969482422);
        query.criteria("salary").equal(52.31999969482422);

        System.out.println(query.getQueryObject().toString());
        System.out.println(query.asList());
    }

    @Test
    public void queryTest3(){
        Query<User> query = datastore.createQuery(User.class);

        query.or(query.criteria("salary").equal(53.31999969482422), query.criteria("salary").equal(52.31999969482422));

        System.out.println(query.getQueryObject().toString());
        System.out.println(query.asList());
    }

    /**
     * 通过这种方式进行的查询在默认的情况下不同的查询条件之间的关系为and
     * { "salary" : 53.31999969482422 , "nickname" : "zhangsan19"}
     */
    @Test
    public void queryTest4() {
        Query<User> query = datastore.createQuery(User.class);
        query.field("salary").equal(53.31999969482422);
        query.field("nickname").equal("zhangsan19");

        System.out.println(query.getQueryObject().toString());
        System.out.println(query.asList());
    }

    @Test
    public void nearTest(){
        Query query = datastore.find(User.class);
        User user = (User) query.field("loc").near(5, 6);

        sout(query);
        System.out.println(user);
    }

    @Test
    public void testSave1() {
        User user = new User();
        user.setAge(12);
        user.setName("test");
        user.setLoc(new double[]{5, 6});
        user.setSalary(20);

        datastore.save(user);

    }

    public static void sout(Query query){
        System.out.println(query.getQueryObject().toString());
        System.out.println(query.asList());
    }

}
