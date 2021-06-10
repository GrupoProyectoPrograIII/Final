package org.crud;

import java.util.List;
import org.modelo.TipoMovimiento;

public interface CrudTipoMovimiento {
    public List listar();
    public TipoMovimiento list(int id);
    
    public List busqueda(String parametro, String opcion);
}
