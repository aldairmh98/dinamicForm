/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.anaproject;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author aldai
 */
public class DAOData {

    private MongoCollection mongoCollection = null;
    private static DAOData dao = null;

    private DAOData() {
        mongoCollection = MongoConnection.getMongoConnection().getDatabase().getCollection("data2");
    }

    public static DAOData getDaoData() {
        if (dao == null) {
            dao = new DAOData();
        }
        return dao;
    }

    public void insert(Document document) {
        mongoCollection.insertOne(document);
    }

    public ArrayList<Document> getData() {
        MongoCursor<Document> cursor = mongoCollection.find().iterator();
        ArrayList<Document> documents = new ArrayList<>();

        try {
            while (cursor.hasNext()) {
                documents.add(cursor.next());
            }
        }
        finally {
            cursor.close();
        }
        return documents;
    }
}
