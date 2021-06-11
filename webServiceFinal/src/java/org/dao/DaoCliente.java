package org.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.crud.CrudCliente;
import org.modelo.Cliente;
import org.modelo.Cuenta;

public class DaoCliente implements CrudCliente {

    Conexion conexion = new Conexion();
    String strSql = "";
    Connection con;
    ResultSet rs = null;

    @Override
    public List listar() {
        List<Cliente> lstCliente = new ArrayList<>();
        strSql = "SELECT * FROM CLIENTE";

        try {
            conexion.open();
            rs = conexion.executeQuery(strSql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
                cliente.setCui(rs.getString("CUI"));
                cliente.setNombre(rs.getString("NOMBRE"));
                cliente.setApellido(rs.getString("APELLIDO"));
                cliente.setTelefono(rs.getString("TELEFONO"));
                cliente.setDireccion(rs.getString("DIRECCION"));
                lstCliente.add(cliente);
            }
            rs.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCuenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstCliente;
    }

    @Override
    public Cliente list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List busqueda(String parametro, String opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
