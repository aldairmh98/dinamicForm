/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.anaproject;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import javax.swing.text.AbstractDocument;
import org.bson.Document;

/**
 *
 * @author aldai
 */
public class DAOForm {
    private MongoCollection mongoCollection = null;
    private static DAOForm dao = null;

    private DAOForm() {
        mongoCollection = MongoConnection.getMongoConnection().getDatabase().getCollection("forms");
    }

    public static DAOForm getDaoForm() {
        if (dao == null) {
            dao = new DAOForm();
        }
        return dao;
    }
    
    public void agregar(ArrayList<Field> fields)
    {
        System.out.println("Executing");
        Document docto = new Document();
        for (Field f : fields) {
            docto.append(f.gettField().getText(), f.getCombo().getSelectedItem().toString());
        }
        mongoCollection.insertOne(docto);
    }

    public ArrayList<Document> getForms(){
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
