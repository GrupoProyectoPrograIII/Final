/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crud;

import java.util.List;
import org.modelo.TipoMovimiento;

/**
 *
 * @author family.user
 */
public interface CrudTipoMovimiento {
    public List listar();
    public TipoMovimiento list(int id);
    
    public List busqueda(String parametro, String opcion);
}
