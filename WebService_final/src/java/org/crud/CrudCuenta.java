/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crud;

import java.util.List;
import org.modelo.Cuenta;

/**
 *
 * @author family.user
 */
public interface CrudCuenta {
    public List listar();
    public Cuenta list(int id);
    
    public List busqueda(String parametro, String opcion);
}
