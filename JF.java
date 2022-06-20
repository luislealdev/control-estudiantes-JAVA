/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectop4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luisleal
 */
public class JF extends javax.swing.JFrame {
        
    /**
     * Creates new form JF
     */
   public JF(){
        initComponents();
        

                try {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Estudiantes"))) {
                    DefaultTableModel model = (DefaultTableModel)studentsTable.getModel();
                    int filas=model.getRowCount();
                    for (int i = 0;i<filas; i++) {
                        model.removeRow(0);
                    }
                    
                    
                            //Ciclo para leer los datos dentro de linkedList
                        LinkedList<estudiante> llDatosRecibidos=(LinkedList<estudiante>) ois.readObject();
                        //Imprimir todos los datos de la LinkedList
                        for(estudiante d: llDatosRecibidos){
                            model.addRow(new Object[]{d.name, d.lastName, d.promedio, d.phone});
                        }
                    
                    ois.close();
                } 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(JF.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        actualizar.addActionListener(e->{
            try {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Estudiantes"))) {
                    DefaultTableModel model = (DefaultTableModel)studentsTable.getModel();
                    int filas=model.getRowCount();
                    for (int i = 0;i<filas; i++) {
                        model.removeRow(0);
                    }
                    
                    
                            //Ciclo para leer los datos dentro de linkedList
                        LinkedList<estudiante> llDatosRecibidos=(LinkedList<estudiante>) ois.readObject();
                        //Imprimir todos los datos de la LinkedList
                        for(estudiante d: llDatosRecibidos){
                            model.addRow(new Object[]{d.name, d.lastName, d.promedio, d.phone});
                        }
                    
                } 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(JF.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        searchB.addActionListener(
                e->{
                    for(int i=0; i<studentsTable.getRowCount(); i++){
                        System.out.print(studentsTable.getValueAt(i, 0).toString());
                        System.out.print(nameTF.getText());
                        if(studentsTable.getValueAt(i,0).equals(nameTF.getText())){
                         showLastName.setText(studentsTable.getValueAt(i, 1).toString());
                         showPromedio.setText(studentsTable.getValueAt(i,2).toString());
                         showPhone.setText(studentsTable.getValueAt(i, 3).toString());
                        } 
                    }
                }
        );
        
        changeB.addActionListener(
           r -> {
               
           if(name.isSelected()){
                try {                
                LinkedList<estudiante> llDatosRecibidos;
                try ( 
                    //INPUT ES PARA LEER
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Estudiantes"))) {
                    llDatosRecibidos = (LinkedList<estudiante>) ois.readObject();
                    for(estudiante d: llDatosRecibidos){
                    if(nameTC.getText().equals(d.name)){
                    d.name = valueTF.getText();
                }
                }
                    ois.close();
                }
                
                try ( 
                    //OUTPUT ES PARA ESCRIBIR
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Estudiantes"))) {
                    output.writeObject(llDatosRecibidos);
                    actualizar.doClick();

                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(JF.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                 
               }else if (lastName.isSelected()){
                try {                
                LinkedList<estudiante> llDatosRecibidos;
                try ( 
                    //INPUT ES PARA LEER
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Estudiantes"))) {
                    llDatosRecibidos = (LinkedList<estudiante>) ois.readObject();
                    for(estudiante d: llDatosRecibidos){
                    if(nameTC.getText().equals(d.name)){
                    d.lastName = valueTF.getText();
                }
                }
                    ois.close();
                }
                
                try ( 
                    //OUTPUT ES PARA ESCRIBIR
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Estudiantes"))) {
                    output.writeObject(llDatosRecibidos);
                    actualizar.doClick();

                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(JF.class.getName()).log(Level.SEVERE, null, ex);
            }
                               
               }else if(promedio.isSelected()){
                try {                
                LinkedList<estudiante> llDatosRecibidos;
                try ( 
                    //INPUT ES PARA LEER
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Estudiantes"))) {
                    llDatosRecibidos = (LinkedList<estudiante>) ois.readObject();
                    for(estudiante d: llDatosRecibidos){
                    if(nameTC.getText().equals(d.name)){
                    d.promedio = valueTF.getText();
                }
                }
                    ois.close();
                }
                
                try ( 
                    //OUTPUT ES PARA ESCRIBIR
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Estudiantes"))) {
                    output.writeObject(llDatosRecibidos);
                    actualizar.doClick();

                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(JF.class.getName()).log(Level.SEVERE, null, ex);
            }
               }else if(phone.isSelected()){
                try {                
                LinkedList<estudiante> llDatosRecibidos;
                try ( 
                    //INPUT ES PARA LEER
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Estudiantes"))) {
                    llDatosRecibidos = (LinkedList<estudiante>) ois.readObject();
                    for(estudiante d: llDatosRecibidos){
                    if(nameTC.getText().equals(d.name)){
                    d.phone = valueTF.getText();
                }
                }
                    ois.close();
                }
                
                try ( 
                    //OUTPUT ES PARA ESCRIBIR
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Estudiantes"))) {
                    output.writeObject(llDatosRecibidos);
                    actualizar.doClick();

                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(JF.class.getName()).log(Level.SEVERE, null, ex);
            }
               }
           }
        );
        
        addStudent.addActionListener(e->{
            try {                
                LinkedList<estudiante> llDatosRecibidos;
                try ( 
                    //INPUT ES PARA LEER
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Estudiantes"))) {
                    llDatosRecibidos = (LinkedList<estudiante>) ois.readObject();
                    ois.close();
                }
                
                try ( 
                    //OUTPUT ES PARA ESCRIBIR
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Estudiantes"))) {
                    llDatosRecibidos.add(new estudiante(nameTA.getText(), lastNameTA.getText(), promedioTA.getText(), phoneTA.getText()));
                    output.writeObject(llDatosRecibidos);
                    
                  actualizar.doClick();


                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(JF.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        exitB.addActionListener(e->{
            System.exit(0);
        });
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        searchB = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        showLastName = new javax.swing.JLabel();
        showPromedio = new javax.swing.JLabel();
        showPhone = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lastName = new javax.swing.JRadioButton();
        promedio = new javax.swing.JRadioButton();
        phone = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        nameTC = new javax.swing.JTextField();
        changeB = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        valueTF = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        name = new javax.swing.JRadioButton();
        exitB = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nameTA = new javax.swing.JTextField();
        lastNameTA = new javax.swing.JTextField();
        promedioTA = new javax.swing.JTextField();
        phoneTA = new javax.swing.JTextField();
        addStudent = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Promedio", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(studentsTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setText("BUSCAR ESTUDIANTE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 27, -1, -1));

        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 53, -1, -1));

        nameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTFActionPerformed(evt);
            }
        });
        getContentPane().add(nameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 50, 70, -1));

        searchB.setText("Buscar");
        searchB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBActionPerformed(evt);
            }
        });
        getContentPane().add(searchB, new org.netbeans.lib.awtextra.AbsoluteConstraints(919, 50, -1, -1));

        jLabel3.setText("Apellido:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 91, -1, -1));

        jLabel4.setText("Promedio:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 114, -1, -1));

        jLabel5.setText("Teléfono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 137, -1, -1));

        showLastName.setText("---");
        getContentPane().add(showLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(856, 91, -1, -1));

        showPromedio.setText("---");
        getContentPane().add(showPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(856, 114, -1, -1));

        showPhone.setText("---");
        getContentPane().add(showPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(856, 137, -1, -1));

        jLabel6.setText("CAMBIAR DATOS DE ESTUDIANTE");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 198, -1, -1));

        buttonGroup1.add(lastName);
        lastName.setText("Apellido");
        getContentPane().add(lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 282, -1, -1));

        buttonGroup1.add(promedio);
        promedio.setText("Promedio");
        promedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promedioActionPerformed(evt);
            }
        });
        getContentPane().add(promedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 309, -1, -1));

        buttonGroup1.add(phone);
        phone.setText("Teléfono");
        getContentPane().add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 336, -1, -1));

        jLabel7.setText("Nombre");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 233, -1, -1));

        nameTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTCActionPerformed(evt);
            }
        });
        getContentPane().add(nameTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 230, 100, -1));

        changeB.setText("Cambiar");
        getContentPane().add(changeB, new org.netbeans.lib.awtextra.AbsoluteConstraints(818, 404, -1, -1));

        jLabel8.setText("Valor nuevo");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 372, -1, -1));

        valueTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueTFActionPerformed(evt);
            }
        });
        getContentPane().add(valueTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(859, 369, 78, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 183, 190, 10));

        buttonGroup1.add(name);
        name.setText("Nombre");
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 255, -1, -1));

        exitB.setText("Salir");
        exitB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBActionPerformed(evt);
            }
        });
        getContentPane().add(exitB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1026, 442, -1, -1));

        jLabel9.setText("AÑADIR ESTUDIANTE");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 27, -1, -1));

        jLabel10.setText("Nombre");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 67, -1, -1));

        jLabel11.setText("Apellido");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 96, -1, -1));

        jLabel12.setText("Promedio");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 125, -1, -1));

        jLabel13.setText("Teléfono");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 157, -1, -1));

        nameTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTAActionPerformed(evt);
            }
        });
        getContentPane().add(nameTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 64, 79, -1));

        lastNameTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTAActionPerformed(evt);
            }
        });
        getContentPane().add(lastNameTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 93, 79, -1));

        promedioTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promedioTAActionPerformed(evt);
            }
        });
        getContentPane().add(promedioTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 122, 79, -1));
        getContentPane().add(phoneTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 154, 79, -1));

        addStudent.setText("Añadir");
        addStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentActionPerformed(evt);
            }
        });
        getContentPane().add(addStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 195, -1, -1));

        actualizar.setText("Cargar Base de Datos");
        getContentPane().add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 433, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTFActionPerformed

    private void searchBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBActionPerformed

    private void promedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_promedioActionPerformed

    private void nameTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTCActionPerformed

    private void valueTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valueTFActionPerformed

    private void exitBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitBActionPerformed

    private void nameTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTAActionPerformed

    private void lastNameTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTAActionPerformed

    private void addStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStudentActionPerformed

    private void promedioTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promedioTAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_promedioTAActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF().setVisible(true);
            }
        });
        
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton addStudent;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton changeB;
    private javax.swing.JButton exitB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton lastName;
    private javax.swing.JTextField lastNameTA;
    private javax.swing.JRadioButton name;
    private javax.swing.JTextField nameTA;
    private javax.swing.JTextField nameTC;
    private javax.swing.JTextField nameTF;
    private javax.swing.JRadioButton phone;
    private javax.swing.JTextField phoneTA;
    private javax.swing.JRadioButton promedio;
    private javax.swing.JTextField promedioTA;
    private javax.swing.JButton searchB;
    private javax.swing.JLabel showLastName;
    private javax.swing.JLabel showPhone;
    private javax.swing.JLabel showPromedio;
    private javax.swing.JTable studentsTable;
    private javax.swing.JTextField valueTF;
    // End of variables declaration//GEN-END:variables
}
