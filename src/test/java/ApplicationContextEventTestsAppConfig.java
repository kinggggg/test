import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weibo_li on 16/5/17.
 */
@Configuration
public class ApplicationContextEventTestsAppConfig extends AbstractMongoConfiguration {

    @Override
    public String getDatabaseName() {
        return "database";
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        List<ServerAddress> list = new ArrayList<>();
        list.add(new ServerAddress("127.0.0.1", 27017));


        List<MongoCredential> list2 = new ArrayList<>();
        list2.add(MongoCredential.createCredential("name", "db", "pwd".toCharArray()));


        return new MongoClient(list, list2);
    }
}
