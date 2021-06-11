package org.crud;

import java.util.List;
import org.modelo.Movimiento;

public interface CrudMovimiento {
    public List listar();
    public Movimiento list(int id);
    public boolean insertar(Movimiento movimiento);
    public boolean modificar(Movimiento movimiento);    
    public List busqueda(String parametro, String opcion);
}
