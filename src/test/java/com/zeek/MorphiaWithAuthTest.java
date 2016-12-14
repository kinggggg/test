package com.zeek;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.zeek.morphia.entity.SubjectMessageSendLog;
import com.zeek.morphia.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by weibo_li on 16/5/10.
 */
public class MorphiaWithAuthTest {

    private Morphia morphia = null;

    private Datastore datastore = null;

    private String host = "192.168.25.91" ;

    private int port = 63007 ;

    private String username = "morphia" ;

    private String password = "morphia" ;

    private String dbName = "phoenix" ;


    @Before
    public void init() {
        morphia = new Morphia();
        morphia.mapPackage("com.zeek.morphia.entity");
        ServerAddress addr = new ServerAddress(host, port);
        List<MongoCredential> credentialsList = new ArrayList<>();
        MongoCredential credentia = MongoCredential.createCredential(
                username, dbName, password.toCharArray());
        credentialsList.add(credentia);
        MongoClient client = new MongoClient(addr, credentialsList);
        datastore = morphia.createDatastore(client, dbName);
    }

    @Test
    public void queryTest1() {
        List<SubjectMessageSendLog> users = new ArrayList<>();
        Query<SubjectMessageSendLog> query = datastore.createQuery(SubjectMessageSendLog.class).filter("subjectMessage.userIds in", Arrays.asList("e1562a12-875f-47c9-8238-7f383e871cbb"));

        users = query.asList();

        System.out.println(users);
    }

}
