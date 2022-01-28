package com.mongoapp;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    public MongoClient getClient(){
        return new MongoClient("localhost",27017);
    }

    @Override
    public void run(String... strings) throws Exception {
        //inside this method we can initialize mongodb database
        MongoClient mongoClient= getClient();
        MongoDatabase database= mongoClient.getDatabase("test");
        MongoCollection<Document> employeeCollection= database.getCollection("employee");

        Document employee1= new Document();
        employee1.append("firstName","BAT");
        employee1.append("lastName","BAT");
        employee1.append("address","BATCAVE");

        employeeCollection.insertOne(employee1);
    }
}
