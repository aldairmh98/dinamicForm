/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.anaproject;

import com.mycompany.anaproject.views.FormLogin;
import com.mycompany.anaproject.views.MainWindow;
import com.mycompany.anaproject.views.NewJFrame;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author aldai
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //DAOData.getDaoData().getData();
        
//        NewJFrame njf = new NewJFrame();
//        njf.setVisible(true);
        
        FormLogin fc = new FormLogin();
        fc.setVisible(true);

//        while ((dataType = sc.nextInt()) != 0) {
//            switch (dataType) {
//                case 1:
//                    System.out.println("Ingrese nombre del campo: ");
//                    fieldName = sc.next();
//                    System.out.println("Ingrese valor del campo: ");
//                    value = sc.nextInt();
//                    doc.append(fieldName, value);
//                    break;
//                case 2:
//                    System.out.println("Ingrese nombre del campo: ");
//                    fieldName = sc.next();
//                    System.out.println("Ingrese valor del campo: ");
//                    val = sc.next();
//                    doc.append(fieldName, value);
//                    break;
//                case 3:
//                    System.out.println("Ingrese nombre del campo: ");
//                    fieldName = sc.next();
//                    System.out.println("Ingrese valor del campo: ");
//                    value = sc.nextInt();
//                    if (value == 0) {
//                        doc.append(fieldName, false); 
//                    } else {
//                        doc.append(fieldName, true);
//                    }
//                    break;
//            }
//            System.out.println(message);
//        }
//
//        if (!doc.isEmpty()) {
//            DAOData.getDaoData().insert(doc);
//        }
    }

}
