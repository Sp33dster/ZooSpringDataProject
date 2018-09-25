package com.sda.ZooSpringDataProject;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoRepositories(basePackages = {"com.sda"})
public class MongoDBConfiguration extends AbstractMongoConfiguration {

    public static final String MONGODB_BEAN_NAME = "Mongo";

    @Value("${hrprojects.mongodb.port:13003}")
    private Integer mongoPort;

    @Value("${hrprojects.mongodb.host:ds113003.mlab.com}")
    private String mongoHost;

    @Value("${hrprojects.mongodb.dbname:zoodatabase}")
    private String mongoDBName;

    @Value("${hrprojects.mongodb.user:admin1}")
    private String user;

    @Value("${hrprojects.mongodb.password:admin1}")
    private String password;

    @Override
    protected String getDatabaseName() {
        return mongoDBName;
    }

    public @Bean(name = MONGODB_BEAN_NAME)
    Mongo mongo() throws Exception {
        MongoCredential m = MongoCredential.createCredential(user, mongoDBName, password.toCharArray());
        List<ServerAddress> addresses = new ArrayList<>();
        addresses.add(new ServerAddress(mongoHost + ":" + mongoPort));

        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(m);
        return new MongoClient(addresses, credentials);
    }

}
