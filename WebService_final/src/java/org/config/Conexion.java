/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.config;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author family.user
 */
public class Conexion {
    private PreparedStatement preparar = null;    
    private  Connection coneccion=null;    
    private ResultSet resultado = null;
    //Cadena de Conexion    
    String stringConnectionUrl = "jdbc:sqlserver://localhost:1433; databaseName=TEMARIOIIIA;";
    //Driver o controlador JDBC
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private boolean respuesta = false;
    
    public Connection open() throws ClassNotFoundException{        
        try {  
                Class.forName(driver);                
                coneccion = DriverManager.getConnection(stringConnectionUrl,"sa","1234");
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);            
            System.out.println("Excepción: " + e.getMessage());
        }
        return coneccion;
    }
    
    public void close() throws Exception{
        //Connection coneccion = null;
        try {
            if (coneccion != null){
                coneccion.clearWarnings();
                coneccion.close();                
            }
        } catch (SQLException e) {
            coneccion = null;
            throw new Exception(e.getMessage());
        }

    }
    
    public boolean executeSql (String cmd) throws Exception{
            if (cmd != null)
            try {
                    this.preparar = this.coneccion.prepareStatement(cmd);
                    this.preparar.executeUpdate();
                    respuesta = true;
            } catch (SQLException e) {
                    throw new Exception(e.getMessage());
            }
            else
                    throw new Exception("El comando a ejecutar es nulo!");
            return respuesta;
    }
	
    public ResultSet executeQuery (String strSQL){
        
            if (strSQL != null)
            try {  
                    preparar = coneccion.prepareStatement(strSQL);                    
                    resultado = preparar.executeQuery();	
            } catch (SQLException e) {                    
                System.out.println("Error al ejecutar el query en Clase: Conexion: " + e.toString());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }
            //close();
            return resultado;
    }
}
