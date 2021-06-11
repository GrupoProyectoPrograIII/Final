package org.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.crud.CrudTipoCuenta;
import org.modelo.Cliente;
import org.modelo.TipoCuenta;

public class DaoTipoCuenta implements CrudTipoCuenta {

    Conexion conexion = new Conexion();
    String strSql = "";
    Connection con;
    ResultSet rs = null;

    @Override
    public List listar() {
        List<TipoCuenta> lstTipoCuenta = new ArrayList<>();
        strSql = "SELECT * FROM TIPO_CUENTA";

        try {
            conexion.open();
            rs = conexion.executeQuery(strSql);
            while (rs.next()) {
                TipoCuenta tipoCuenta = new TipoCuenta();
                tipoCuenta.setTipoCuenta(rs.getInt("TIPO_CUENTA"));
                tipoCuenta.setDescripcion(rs.getString("DESCRIPCION"));
                lstTipoCuenta.add(tipoCuenta);
            }
            rs.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCuenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstTipoCuenta;
    }

    @Override
    public TipoCuenta list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List busqueda(String parametro, String opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
