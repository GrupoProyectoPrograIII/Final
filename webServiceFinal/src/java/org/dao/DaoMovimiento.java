package org.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.crud.CrudMovimiento;
import org.modelo.Movimiento;

public class DaoMovimiento implements CrudMovimiento{
    
    String strSql = "";
    Movimiento mov = new Movimiento();
    Conexion conexion = new Conexion();
    Connection con;
    ResultSet rs = null;
    
    @Override
    public List listar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Movimiento> lstMovimiento = new ArrayList<>();
        strSql = "SELECT dbo.MOVIMIENTOS.FEC_MOVIMIENTO, dbo.CUENTA.NUMERO_CUENTA, dbo.CLIENTE.NOMBRE, dbo.CLIENTE.APELLIDO, dbo.TIPO_CUENTA.DESCRIPCION, dbo.TIPO_MOVIMIENTO.MOVIMIENTO, dbo.MOVIMIENTOS.TIPO_CAMBIO, dbo.MOVIMIENTOS.SALDO_Q, dbo.MOVIMIENTOS.SALDO_D FROM dbo.MOVIMIENTOS INNER JOIN dbo.TIPO_MOVIMIENTO ON dbo.MOVIMIENTOS.TIPO_MOVIMIENTO = dbo.TIPO_MOVIMIENTO.TIPO_MOVIMIENTO INNER JOIN dbo.CUENTA ON dbo.MOVIMIENTOS.ID_CLIENTE = dbo.CUENTA.ID_CLIENTE AND dbo.MOVIMIENTOS.ID_CUENTA = dbo.CUENTA.ID_CUENTA INNER JOIN dbo.TIPO_CUENTA ON dbo.CUENTA.TIPO_CUENTA = dbo.TIPO_CUENTA.TIPO_CUENTA INNER JOIN dbo.CLIENTE ON dbo.CUENTA.ID_CLIENTE = dbo.CLIENTE.ID_CLIENTE";
        try {
            conexion.open();
            rs = conexion.executeQuery(strSql);
            while(rs.next()){
                Movimiento movimiento = new Movimiento();
                movimiento.setFechaMovimiento(rs.getTimestamp("FEC_MOVIMIENTO"));
                movimiento.setCuenta(rs.getString("NUMERO_CUENTA"));
                movimiento.setNombre(rs.getString("NOMBRE"));
                movimiento.setApellido(rs.getString("APELLIDO"));                
                movimiento.setMovimiento(rs.getString("DESCRIPCION"));
                movimiento.setTipoCambio(rs.getDouble("TIPO_CAMBIO"));
                movimiento.setSaldoQ(rs.getDouble("SALDO_Q"));
                movimiento.setSaldoD(rs.getDouble("SALDO_D"));
                lstMovimiento.add(movimiento);
            }
            rs.close();
            conexion.close();            
        } catch(ClassNotFoundException ex){
            Logger.getLogger(DaoMovimiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception ex){
            Logger.getLogger(DaoMovimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstMovimiento;
    }

    @Override
    public Movimiento list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movimiento insertar(Movimiento movimiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Movimiento movimiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public List busqueda(String parametro, String opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
