/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cob.fabrica.controller;

import com.cob.fabrica.dao.HibernateUtil;







public class Main extends HibernateUtil {
    
     
    public static void main (String[] args) {
       //  SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        
        //new GestorAdminCampos(getSessionFactory()).run();
          new GestorAdminClientes(getSessionFactory()).run();
    }
    
}
