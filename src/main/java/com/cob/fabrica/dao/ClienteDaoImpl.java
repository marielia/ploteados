/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cob.fabrica.dao;

import com.cob.fabrica.bean.Clientes;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Mariela
 */
public class ClienteDaoImpl implements ClienteDao {
  private final SessionFactory sessionFactory;
  private static String QUERY_GET_CLIENTES = "from Clientes";
    public ClienteDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory=sessionFactory;
    }

    
    @Override
    public void saveCliente(Clientes cli) {
       Session session = sessionFactory.openSession();
       session.beginTransaction();
       session.save(cli);
       session.getTransaction().commit();    }

    @Override
    public List<Clientes> getAllClientes() {
       Session session = sessionFactory.openSession();
        
        Query query = session.createQuery(QUERY_GET_CLIENTES);
        
        List<Clientes> listado = query.list();
        return listado;   }

    @Override
    public void updateCliente(Clientes cli) {
         Session session = sessionFactory.openSession();
       session.beginTransaction();
       session.update(cli);
       session.getTransaction().commit();  
    }
    
}
