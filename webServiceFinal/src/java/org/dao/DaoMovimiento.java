package org.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.crud.CrudMovimiento;
import org.modelo.Cuenta;
import org.modelo.Movimiento;

public class DaoMovimiento implements CrudMovimiento {

    String strSql = "";
    String strSql2 = "";
    Movimiento mov = new Movimiento();
    Conexion conexion = new Conexion();
    Connection con;
    ResultSet rs = null;
    boolean respuesta = false;

    @Override
    public List listar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Movimiento> lstMovimiento = new ArrayList<>();
        strSql = "SELECT dbo.MOVIMIENTOS.ID_MOVIMIENTO, dbo.MOVIMIENTOS.FEC_MOVIMIENTO, dbo.CUENTA.NUMERO_CUENTA, dbo.CLIENTE.NOMBRE, dbo.CLIENTE.APELLIDO, dbo.TIPO_CUENTA.DESCRIPCION, dbo.TIPO_MOVIMIENTO.MOVIMIENTO, dbo.MOVIMIENTOS.TIPO_CAMBIO, dbo.MOVIMIENTOS.SALDO_Q, dbo.MOVIMIENTOS.SALDO_D FROM dbo.MOVIMIENTOS INNER JOIN dbo.TIPO_MOVIMIENTO ON dbo.MOVIMIENTOS.TIPO_MOVIMIENTO = dbo.TIPO_MOVIMIENTO.TIPO_MOVIMIENTO INNER JOIN dbo.CUENTA ON dbo.MOVIMIENTOS.ID_CLIENTE = dbo.CUENTA.ID_CLIENTE AND dbo.MOVIMIENTOS.ID_CUENTA = dbo.CUENTA.ID_CUENTA INNER JOIN dbo.TIPO_CUENTA ON dbo.CUENTA.TIPO_CUENTA = dbo.TIPO_CUENTA.TIPO_CUENTA INNER JOIN dbo.CLIENTE ON dbo.CUENTA.ID_CLIENTE = dbo.CLIENTE.ID_CLIENTE";
        try {
            conexion.open();
            rs = conexion.executeQuery(strSql);
            while (rs.next()) {
                Movimiento movimiento = new Movimiento();
                movimiento.setIdMovimiento(rs.getInt("ID_MOVIMIENTO"));
                movimiento.setFechaMovimiento((rs.getTimestamp("FEC_MOVIMIENTO")).toString());
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMovimiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMovimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstMovimiento;
    }

    @Override
    public Movimiento list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(Movimiento movimiento) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Cuenta cuenta = new Cuenta();
        try {
            conexion.open().setAutoCommit(false);
            Statement stmt = conexion.open().createStatement();
            strSql = "INSERT INTO MOVIMIENTOS (FEC_MOVIMIENTO,ID_CLIENTE,ID_CUENTA,TIPO_MOVIMIENTO,USUARIO,TIPO_CAMBIO,SALDO_Q,SALDO_D) VALUES (CURRENT_TIMESTAMP," + movimiento.getIdCliente() + ", " + movimiento.getIdCuenta() + ", " + movimiento.getTipoMovimiento() + ",'" + movimiento.getUsuario() + "', " + movimiento.getTipoCambio() + ", " + movimiento.getSaldoQ() + ", " + movimiento.getSaldoD() + ")";
            stmt.executeUpdate(strSql);
            cuenta = selectCuenta(movimiento.getIdCuenta());
            if (movimiento.getTipoMovimiento() == 1) {
                strSql2 = "UPDATE CUENTA SET ID_CLIENTE = " + cuenta.getIdCuenta() + ", NUMERO_CUENTA = '" + cuenta.getNumeroCuenta() + "', TIPO_CUENTA = " + cuenta.getTipoCuenta() + ", SALDO_Q = " + (cuenta.getSaldoQ() - movimiento.getSaldoQ()) + ", SALDO_D = " + (cuenta.getSaldoQ() - movimiento.getSaldoD()) + " WHERE ID_CUENTA = " + cuenta.getIdCuenta();
            } else {
                strSql2 = "UPDATE CUENTA SET ID_CLIENTE = " + cuenta.getIdCuenta() + ", NUMERO_CUENTA = '" + cuenta.getNumeroCuenta() + "', TIPO_CUENTA = " + cuenta.getTipoCuenta() + ", SALDO_Q = " + (cuenta.getSaldoQ() + movimiento.getSaldoQ()) + ", SALDO_D = " + (cuenta.getSaldoQ() + movimiento.getSaldoD()) + " WHERE ID_CUENTA = " + cuenta.getIdCuenta();
            }
            stmt.executeUpdate(strSql2);
            conexion.open().commit();
            conexion.close();
            respuesta = true;
        } catch (SQLException se) {
            try {
                conexion.open().rollback();
                respuesta = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DaoMovimiento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DaoMovimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMovimiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoMovimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean modificar(Movimiento movimiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List busqueda(String parametro, String opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cuenta selectCuenta(int id) {
        Cuenta cuenta = new Cuenta();
        try {
            strSql = "SELECT * FROM CUENTA WHERE ID_CUENTA=" + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);
            while (rs.next()) {
                cuenta.setIdCliente(rs.getInt("ID_CLIENTE"));
                cuenta.setIdCuenta(rs.getInt("ID_CUENTA"));
                cuenta.setNumeroCuenta(rs.getString("NUMERO_CUENTA"));
                cuenta.setTipoCuenta(rs.getInt("TIPO_CUENTA"));
                cuenta.setSaldoQ(rs.getDouble("SALDO_Q"));
                cuenta.setSaldoD(rs.getDouble("SALDO_D"));
            }
            rs.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCuenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cuenta;
    }
}
