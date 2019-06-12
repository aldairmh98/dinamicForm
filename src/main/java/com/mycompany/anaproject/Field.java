/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.anaproject;

import com.mycompany.anaproject.views.JIFormCreator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author aldai
 */
public class Field implements ActionListener {

    private JComboBox combo;
    private JTextField tField;
    private JLabel fieldName;
    private JButton bton;
    private JIFormCreator parent;
    
    
    public JLabel getFieldName() {
        return fieldName;
    }

    public void setFieldName(JLabel fieldName) {
        this.fieldName = fieldName;
    }

    public Field(JComboBox combo, JTextField tField, JButton boton) {
        this.combo = combo;
        this.tField = tField;
        this.bton = boton;
        bton.addActionListener(this);
        
    }
    
    public Field(JLabel fieldName, JTextField tField) {
        this.fieldName = fieldName;
        this.tField = tField;
    }

    
    public JComboBox getCombo() {
        return combo;
    }

    public void setCombo(JComboBox combo) {
        this.combo = combo;
    }

    public JTextField gettField() {
        return tField;
    }

    public void settField(JTextField tField) {
        this.tField = tField;
    }
    
    public void setList(JIFormCreator panel){
        parent = panel;
    }
    
    public JButton getBotton(){
        return bton;
    }
    public void remove(){
        parent.remove(combo);
        parent.remove(tField);
        parent.remove(bton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        parent.quitit(this);
    }

}
