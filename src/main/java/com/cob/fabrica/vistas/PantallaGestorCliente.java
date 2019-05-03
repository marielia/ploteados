/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cob.fabrica.vistas;

import com.cob.fabrica.bean.Clientes;
import com.cob.fabrica.controller.GestorAdminClientes;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Mariela
 */
public class PantallaGestorCliente extends javax.swing.JFrame {
private GestorAdminClientes gestor;
    /**
     * Creates new form PantallaGestorCliente
     */
    public PantallaGestorCliente() {
        initComponents();
    }

    public PantallaGestorCliente(GestorAdminClientes aThis) {
       this.gestor=aThis;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonNuevoCli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestor Clientes");

        //jTable1=gestor.JTableModelTable();
        jTable1.setModel(gestor.dataModelTable());
        this.pintateTable(jTable1);
        jTable1.setAutoscrolls(true);
        jScrollPane1.setViewportView(jTable1);

        jButtonNuevoCli.setText("Nuevo Cliente");
        jButtonNuevoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonNuevoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonNuevoCli)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNuevoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoCliActionPerformed
        // TODO add your handling code here:
         PantallaAltasClientes pantallaAltasClientes=new PantallaAltasClientes();
            int result = JOptionPane.showConfirmDialog(null, pantallaAltasClientes,"Alta de Aspirantes",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            System.out.println(result);
            boolean validar=false;
            if(result==0){
                
            Clientes cliente=new Clientes();
            if(pantallaAltasClientes.getjTextFieldNombre().getText()!=null){
                cliente.setNombre(pantallaAltasClientes.getjTextFieldNombre().getText());
                
            }else{validar=true;}
            if(pantallaAltasClientes.getjTextFieldApellido().getText()!=null){
                cliente.setApellido(pantallaAltasClientes.getjTextFieldApellido().getText());
                }else{validar=true;}
             if(pantallaAltasClientes.getjTextFieldDireccion().getText()!=null){
                cliente.setDireccion(pantallaAltasClientes.getjTextFieldDireccion().getText());
                }else{validar=true;}
             if(pantallaAltasClientes.getjTextemail().getText()!=null){
                cliente.setEmail(pantallaAltasClientes.getjTextemail().getText());
               }else{validar=true;}
              if(pantallaAltasClientes.getjTexCelu().getText()!=null){
                cliente.setCelular(Long.valueOf(pantallaAltasClientes.getjTexCelu().getText()));
                }else{validar=true;}
                if(pantallaAltasClientes.getjTexWSapp().getText()!=null){
                cliente.setWhatapp(Long.valueOf(pantallaAltasClientes.getjTexWSapp().getText()));
                }else{validar=true;}
                if(!validar){
                    gestor.getClienteDao().saveCliente(cliente);
                    jTable1.setModel(gestor.dataModelTable());
                    
jScrollPane1.setViewportView(jTable1);
                }
            }
    }//GEN-LAST:event_jButtonNuevoCliActionPerformed

    public JTable  pintateTable(JTable jTable1) {
          
        jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
jTable1.getColumnModel().getColumn(7).setMinWidth(0);
jTable1.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
jTable1.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
          jTable1.setDefaultRenderer(JButton.class, (JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) -> (Component) objeto 
          /**
           * Observen que todo lo que hacemos en éste método es retornar el objeto que se va a dibujar en la
           * celda. Esto significa que se dibujará en la celda el objeto que devuelva el TableModel. También
           * significa que este renderer nos permitiría dibujar cualquier objeto gráfico en la grilla, pues
           * retorna el objeto tal y como lo recibe.
           */ );
          /**
         * Por último, agregamos un listener que nos permita saber cuando fue pulsada la celda que contiene el botón.
         * Noten que estamos capturando el clic sobre JTable, no el clic sobre el JButton. Esto también implica que en 
         * lugar de poner un botón en la celda, simplemente pudimos definir un CellRenderer que hiciera parecer que la 
         * celda contiene un botón. Es posible capturar el clic del botón, pero a mi parecer el efecto es el mismo y 
         * hacerlo de esta forma es más "simple"
         */
        this.jTable1.addMouseListener(new MouseAdapter() {
            boolean validar; 
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = jTable1.rowAtPoint(e.getPoint());
                int columna = jTable1.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (jTable1.getModel().getColumnClass(columna).equals(JButton.class)) {
                    /**
                     * Aquí pueden poner lo que quieran, para efectos de este ejemplo, voy a mostrar
                     * en un cuadro de dialogo todos los campos de la fila que no sean un botón.
                     */
                   /* StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < jTable1.getModel().getColumnCount(); i++) {
                        if (!jTable1.getModel().getColumnClass(i).equals(JButton.class)) {
                            sb.append("\n").append(jTable1.getModel().getColumnName(i)).append(": ").append(jTable1.getModel().getValueAt(fila, i));
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Seleccionada la fila " + fila + sb.toString());
                    */
                   
                    PantallaAltasClientes pantallaAltasClientes=new PantallaAltasClientes();
                   for (int i = 0; i < jTable1.getModel().getColumnCount(); i++) {
                        if (!jTable1.getModel().getColumnClass(i).equals(JButton.class)) {
                            pantallaAltasClientes.getjTextFieldNombre().setText(jTable1.getModel().getValueAt(fila, 1).toString());
                            pantallaAltasClientes.getjTextFieldApellido().setText(jTable1.getModel().getValueAt(fila, 2).toString());
                            pantallaAltasClientes.getjTextFieldDireccion().setText(jTable1.getModel().getValueAt(fila, 3).toString());
                            
                             pantallaAltasClientes.getjTexCelu().setText(jTable1.getModel().getValueAt(fila, 4).toString());
                             pantallaAltasClientes.getjTextemail().setText(jTable1.getModel().getValueAt(fila, 5).toString());
                             pantallaAltasClientes.setIdCliente(jTable1.getModel().getValueAt(fila, 7).toString());
                           // sb.append("\n").append(jTable1.getModel().getColumnName(i)).append(": ").append(jTable1.getModel().getValueAt(fila, i));
                        }
                    } 
                
            int result = JOptionPane.showConfirmDialog(null, pantallaAltasClientes,"Alta de Aspirantes",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if(result==0){
                
            Clientes cliente=new Clientes();
            cliente.setIdCliente(new Integer(pantallaAltasClientes.getIdCliente()));
            if(pantallaAltasClientes.getjTextFieldNombre().getText()!=null){
                cliente.setNombre(pantallaAltasClientes.getjTextFieldNombre().getText());
                
            }else{validar=true;}
            if(pantallaAltasClientes.getjTextFieldApellido().getText()!=null){
                cliente.setApellido(pantallaAltasClientes.getjTextFieldApellido().getText());
                }else{validar=true;}
             if(pantallaAltasClientes.getjTextFieldDireccion().getText()!=null){
                cliente.setDireccion(pantallaAltasClientes.getjTextFieldDireccion().getText());
                }else{validar=true;}
             if(pantallaAltasClientes.getjTextemail().getText()!=null){
                cliente.setEmail(pantallaAltasClientes.getjTextemail().getText());
               }else{validar=true;}
              if(pantallaAltasClientes.getjTexCelu().getText()!=null){
                cliente.setCelular(Long.valueOf(pantallaAltasClientes.getjTexCelu().getText()));
                }else{validar=true;}
                if(pantallaAltasClientes.getjTexWSapp().getText()!=null ){
                 Long wsapp=new Long(pantallaAltasClientes.getjTexWSapp().getText());   
                cliente.setWhatapp(wsapp);
                }else{validar=true;}
                if(!validar){
                    gestor.getClienteDao().updateCliente(cliente);
                    jTable1.setModel(gestor.dataModelTable());
                    
jScrollPane1.setViewportView(jTable1);
                }
            }
                 
                }
            }
        });
        
        return jTable1;
        
    }

    
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
            java.util.logging.Logger.getLogger(PantallaGestorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaGestorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaGestorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaGestorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaGestorCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNuevoCli;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
