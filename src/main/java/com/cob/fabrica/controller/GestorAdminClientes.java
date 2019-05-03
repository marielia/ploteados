/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cob.fabrica.controller;

import com.cob.fabrica.bean.Clientes;
import com.cob.fabrica.dao.ClienteDao;
import com.cob.fabrica.dao.ClienteDaoImpl;
import com.cob.fabrica.vistas.PantallaGestorCliente;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import org.hibernate.SessionFactory;

/**
 *
 * @author Mariela
 */
public class GestorAdminClientes {

    private final SessionFactory sessionFactory;
    private ClienteDao clienteDao;
public TableModel dataModelTable() {
    
        String[] title = {"", "Nombre","Apellido","Domicilio","CUIT","Celular","email  ","",""};
        final Class[] tiposColumnas = new Class[]{
            java.lang.Boolean.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            Long.class,
           java.lang.String.class,
            JButton.class, // <- noten que aquí se especifica que la última columna es un botón
                java.lang.String.class
        };

        List<Clientes> listado = this.clienteDao.getAllClientes();
        int size = listado.size();
        
        Object[][] data = new Object[size][9];
        
        for (int i = 0; i < size; i++) {
            data[i][0] = false;
            data[i][1] = listado.get(i).getNombre();
             data[i][2] = listado.get(i).getApellido();
             data[i][3] = listado.get(i).getDireccion()!=null?listado.get(i).getDireccion():"-";
             data[i][4] = listado.get(i).getCelular()!=null?listado.get(i).getCelular().toString():0;
             data[i][5] = listado.get(i).getEmail()!=null?listado.get(i).getEmail():"-";
             data[i][6]=new JButton("Modificar");
             data[i][7]=listado.get(i).getIdCliente(); 
        }

        DefaultTableModel model = new DefaultTableModel(data, title) {
            
             Class[] tipos = tiposColumnas;
           /* @Override
            public Class<?> getColumnClass(int column) {
                if (column == 0) {
                    return Boolean.class;
                } else {
                    return String.class;
                }
            }*/
            @Override
            public Class getColumnClass(int columnIndex) {
                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                // observen que estamos retornando la clase que definimos de antemano.
                return tipos[columnIndex];
            }
             @Override
            public boolean isCellEditable(int row, int column) {
                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                return !(this.getColumnClass(column).equals(JButton.class));
            }
        };

        return model;
    }
public JTable JTableModelTable() {
    JTable jtable=new JTable();
    
        String[] title = {"", "Nombre","Apellido","Domicilio","Celular","E-MAIL","  "};
        final Class[] tiposColumnas = new Class[]{
            
            java.lang.Boolean.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            
            Long.class,
           java.lang.String.class,
            JButton.class // <- noten que aquí se especifica que la última columna es un botón
        };

        List<Clientes> listado = this.clienteDao.getAllClientes();
        int size = listado.size();
        
        Object[][] data = new Object[size][8];
        
        for (int i = 0; i < size; i++) {
            data[i][0] = false;
            data[i][1] = listado.get(i).getNombre();
             data[i][2] = listado.get(i).getApellido();
             
             data[i][3] = listado.get(i).getDireccion()!=null?listado.get(i).getDireccion():"-";
             
             data[i][4] = listado.get(i).getCelular()!=null?listado.get(i).getCelular().toString():"0";
               data[i][5] = listado.get(i).getEmail()!=null?listado.get(i).getEmail():"-";
             data[i][6]=new JButton("Modificar");
        }
jtable.setModel(
        new DefaultTableModel(data, title) {
            
             Class[] tipos = tiposColumnas;
           /* @Override
            public Class<?> getColumnClass(int column) {
                if (column == 0) {
                    return Boolean.class;
                } else {
                    return String.class;
                }
            }*/
            @Override
            public Class getColumnClass(int columnIndex) {
                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                // observen que estamos retornando la clase que definimos de antemano.
                return tipos[columnIndex];
            }
             @Override
            public boolean isCellEditable(int row, int column) {
                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                return !(this.getColumnClass(column).equals(JButton.class));
            }
        });
// El objetivo de la siguiente línea es indicar el CellRenderer que será utilizado para dibujar el botón
        jtable.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                /**
                 * Observen que todo lo que hacemos en éste método es retornar el objeto que se va a dibujar en la 
                 * celda. Esto significa que se dibujará en la celda el objeto que devuelva el TableModel. También 
                 * significa que este renderer nos permitiría dibujar cualquier objeto gráfico en la grilla, pues 
                 * retorna el objeto tal y como lo recibe.
                 */
                return (Component) objeto;
            }
        });
          /**
         * Por último, agregamos un listener que nos permita saber cuando fue pulsada la celda que contiene el botón.
         * Noten que estamos capturando el clic sobre JTable, no el clic sobre el JButton. Esto también implica que en 
         * lugar de poner un botón en la celda, simplemente pudimos definir un CellRenderer que hiciera parecer que la 
         * celda contiene un botón. Es posible capturar el clic del botón, pero a mi parecer el efecto es el mismo y 
         * hacerlo de esta forma es más "simple"
         */
        jtable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = jtable.rowAtPoint(e.getPoint());
                int columna = jtable.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (jtable.getModel().getColumnClass(columna).equals(JButton.class)) {
                    /**
                     * Aquí pueden poner lo que quieran, para efectos de este ejemplo, voy a mostrar
                     * en un cuadro de dialogo todos los campos de la fila que no sean un botón.
                     */
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < jtable.getModel().getColumnCount(); i++) {
                        if (!jtable.getModel().getColumnClass(i).equals(JButton.class)) {
                            sb.append("\n").append(jtable.getModel().getColumnName(i)).append(": ").append(jtable.getModel().getValueAt(fila, i));
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Seleccionada la fila " + fila + sb.toString());
                }
            }
        });
        return jtable;
    }

    public ClienteDao getClienteDao() {
        return clienteDao;
    }

    public void setClienteDao(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }
    GestorAdminClientes(SessionFactory sessionFactory) {
        
        this.sessionFactory=sessionFactory;
        this.clienteDao=new ClienteDaoImpl(sessionFactory);
    }
     void run() {
        new PantallaGestorCliente(this).setVisible(true);
    }
}
