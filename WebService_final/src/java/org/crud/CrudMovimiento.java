/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crud;

import java.util.List;
import org.modelo.Movimiento;

/**
 *
 * @author family.user
 */
public interface CrudMovimiento {
    public List listar();
    public Movimiento list(int id);
    public boolean insertar(Movimiento movimiento);
    public boolean modificar(Movimiento movimiento);    
    public List busqueda(String parametro, String opcion);
}
