package com.zeek;

import com.google.gson.JsonObject;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.zeek.morphia.entity.User;
import org.bson.Document;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by weibo_li on 16/5/10.
 */
public class MongoDBTest {

    private static MongoClient mongoClient = null;

    private static MongoCredential credential = null;

    private static ServerAddress serverAddress = null;

    private static String host = "123.57.154.183";

    private static int port = 61111;

    private static String username = "reader" ;

    private static String password = "wusong@123" ;

    private static String db = "victory";

    @BeforeClass
    public static void init() {
        credential = MongoCredential.createCredential(username,
                db,
                password.toCharArray());
        serverAddress = new ServerAddress( host , port );
        mongoClient = new MongoClient(Arrays.asList(serverAddress), Arrays.asList(credential));
    }

    @Test
    public void saveTest() {
        MongoDatabase database = mongoClient.getDatabase("victory");
        MongoCollection<Document> collection = database.getCollection("tt");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name","lisi");
        jsonObject.addProperty("number", UUID.randomUUID().toString());


        collection.insertOne(Document.parse(jsonObject.toString()));

    }

    @Test
    public void findTest() throws ParseException {
        MongoDatabase database = mongoClient.getDatabase("victory");
        MongoCollection<Document> collection = database.getCollection("article");

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date first = fmt.parse("2015-01-01 00:00:00");
        Date second = fmt.parse("2016-01-05 00:00:01");
        Document doc = new Document("publishDate", new Document("$gt", first).append("$lt", second));
        System.out.println(doc.toJson(new JsonWriterSettings(JsonMode.SHELL)));

        FindIterable<Document> documents =
                collection.find(doc);
        for (Document one : documents) {
            System.out.println(one.toJson());
        }


    }

    @Test
    public void findTest2() throws ParseException {
        MongoDatabase database = mongoClient.getDatabase("victory");
        MongoCollection<Document> collection = database.getCollection("article");

        BasicDBObject andQuery = new BasicDBObject();
        List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
        obj.add(new BasicDBObject("number", 2));
        obj.add(new BasicDBObject("name", "mkyong-2"));
        andQuery.put("$and", obj);


    }

}
