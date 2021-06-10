package org.crud;

import java.util.List;
import org.modelo.Cuenta;

public interface CrudCuenta {
    public List listar();
    public Cuenta list(int id);
    
    public List busqueda(String parametro, String opcion);
}
