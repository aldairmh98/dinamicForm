/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.anaproject.views;

import com.mycompany.anaproject.DAOForm;
import com.mycompany.anaproject.Field;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author aldai
 */
public class JIFormCreator extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFormCreator
     */

    private JPanel panel;
    private DefaultComboBoxModel dcbm;
    private String[] ITEMS = {"Entero", "Boleano", "String"};

    private boolean started = false;

    private ArrayList<Field> list = new ArrayList<>();

    public JIFormCreator() {
        initComponents();
        panel = jPanel1;

        setLayout(new BorderLayout());
        //Configuración de panel con un Grid
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(0, 3));
        add(panel, BorderLayout.NORTH);
        JButton saveButton = new JButton("Guardar");
        add(saveButton, BorderLayout.SOUTH);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveForm();
            }
        });
        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addTextField();
            }
        });
        this.panel.add(addButton);
        this.panel.add(new JLabel());
        this.panel.add(new JLabel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    private DefaultComboBoxModel getModel() {
        DefaultComboBoxModel dfc = new DefaultComboBoxModel();
        for (String item : ITEMS) {
            dfc.addElement(item);
        }
        return dfc;
    }

    private void saveForm() {
        DAOForm.getDaoForm().agregar(list);
    }

    private int cmp = 0;
    private int prro = 0;
    
    private void addTextField(){
        JTextField textField = new JTextField();
        textField.setSize(100, 20);
        this.panel.add(textField);
        JComboBox cb = new JComboBox();
        cb.setModel(this.getModel());
        JButton button = new JButton("Quitar");
        this.panel.add(cb);
        this.panel.add(button);
        this.panel.revalidate();
        validate();
        Field f = new Field(cb, textField, button);
        f.setList(this);
        list.add(f);
    }
   
    public void quitit(Field field){
        this.panel.remove(field.getCombo());
        this.panel.remove(field.gettField());
        this.panel.remove(field.getBotton());
        list.remove(field);
        refresh();
    }
    
    public void refresh(){
        this.panel.revalidate();
        validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setClosable(true);
        setResizable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}