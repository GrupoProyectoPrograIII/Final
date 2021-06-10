package org.dao;

import java.util.List;
import org.config.Conexion;
import org.crud.CrudCuenta;
import org.modelo.Cuenta;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoCuenta implements CrudCuenta{
    //Cuenta cuenta = new Cuenta();
    Conexion conexion = new Conexion();
    String strSql = "";
    Connection con;
    ResultSet rs = null;
    
    @Override
    public List listar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Cuenta> lstCuenta = new ArrayList<>();
        strSql = "SELECT dbo.CUENTA.ID_CLIENTE, dbo.CUENTA.ID_CUENTA, dbo.CUENTA.NUMERO_CUENTA AS CUENTA, dbo.TIPO_CUENTA.DESCRIPCION AS TIPO, dbo.CLIENTE.NOMBRE, dbo.CLIENTE.APELLIDO, dbo.CUENTA.SALDO_Q, dbo.CUENTA.SALDO_D FROM dbo.CLIENTE INNER JOIN dbo.CUENTA ON dbo.CLIENTE.ID_CLIENTE = dbo.CUENTA.ID_CLIENTE INNER JOIN dbo.TIPO_CUENTA ON dbo.CUENTA.TIPO_CUENTA = dbo.TIPO_CUENTA.TIPO_CUENTA";
        
        try {
            conexion.open();
            rs = conexion.executeQuery(strSql);
            while(rs.next()){
                Cuenta cuenta = new Cuenta();
                cuenta.setIdClient(rs.getInt("ID_CLIENTE"));
                cuenta.setIdCuenta(rs.getInt("ID_CUENTA"));
                cuenta.setNumeroCuenta(rs.getString("CUENTA"));
                cuenta.setTipo(rs.getString("TIPO"));
                cuenta.setSaldoQ(rs.getDouble("SALDO_Q"));
                cuenta.setSaldoD(rs.getDouble("SALDO_D"));
                lstCuenta.add(cuenta);
            }
            rs.close();
            conexion.close();            
        } catch(ClassNotFoundException ex){
            Logger.getLogger(DaoCuenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception ex){
            Logger.getLogger(DaoCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
        return lstCuenta;
    }

    @Override
    public Cuenta list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public List busqueda(String parametro, String opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
