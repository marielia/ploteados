/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cob.fabrica.dao;

import com.cob.fabrica.bean.Clientes;
import java.util.List;

/**
 *
 * @author Mariela
 */
public interface ClienteDao {
  public void saveCliente(Clientes cli);
public void updateCliente(Clientes cli);
    public List<Clientes> getAllClientes();
}
