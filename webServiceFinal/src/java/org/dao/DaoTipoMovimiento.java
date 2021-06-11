package org.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.crud.CrudTipoMovimiento;
import org.modelo.Cliente;
import org.modelo.TipoMovimiento;

public class DaoTipoMovimiento implements CrudTipoMovimiento {

    Conexion conexion = new Conexion();
    String strSql = "";
    Connection con;
    ResultSet rs = null;

    @Override
    public List listar() {
        List<TipoMovimiento> lstTipoMovimiento = new ArrayList<>();
        strSql = "SELECT * FROM TIPO_MOVIMIENTO";

        try {
            conexion.open();
            rs = conexion.executeQuery(strSql);
            while (rs.next()) {
                TipoMovimiento tipoMovimiento = new TipoMovimiento();
                tipoMovimiento.setTipoMoviento(rs.getInt("TIPO_MOVIMIENTO"));
                tipoMovimiento.setMovimiento(rs.getString("MOVIMIENTO"));
                tipoMovimiento.setFactor(rs.getDouble("FACTOR"));
                lstTipoMovimiento.add(tipoMovimiento);
            }
            rs.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCuenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstTipoMovimiento;
    }

    @Override
    public TipoMovimiento list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List busqueda(String parametro, String opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
