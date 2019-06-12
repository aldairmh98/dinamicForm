/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.anaproject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author aldai
 */
public class MongoConnection {

    private MongoClient mcli = null;
    private MongoDatabase mbd = null;
    private static MongoConnection mc = null;

    private MongoConnection() {
        mcli = new MongoClient();
        mbd = mcli.getDatabase("ana3");
    }

    public static MongoConnection getMongoConnection() {
        if (mc == null) {
            mc = new MongoConnection();
        }
        return mc;
    }
    
    public MongoDatabase getDatabase(){
        return mbd;
    }
}
