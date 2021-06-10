package org.crud;

import java.util.List;
import org.modelo.TipoCuenta;

public interface CrudTipoCuenta {
    public List listar();
    public TipoCuenta list(int id);
    
    public List busqueda(String parametro, String opcion);
}
