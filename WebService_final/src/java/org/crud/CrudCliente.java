/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crud;

import java.util.List;
import org.modelo.Cliente;

/**
 *
 * @author family.user
 */
public interface CrudCliente {
    public List listar();
    public Cliente list(int id);   
    public List busqueda(String parametro, String opcion);
}
