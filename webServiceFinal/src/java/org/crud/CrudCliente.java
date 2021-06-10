package org.crud;

import java.util.List;
import org.modelo.Cliente;

public interface CrudCliente {
    public List listar();
    public Cliente list(int id);   
    public List busqueda(String parametro, String opcion);
}
