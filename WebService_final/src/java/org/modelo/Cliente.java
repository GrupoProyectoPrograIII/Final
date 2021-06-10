/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelo;

/**
 *
 * @author family.user
 */
public class Cliente {
    private int idCliente;
    private String Cui;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Direccion;

    public Cliente() {
    }

    public Cliente(int idCliente, String Cui, String Nombre, String Apellido, String Telefono, String Direccion) {
        this.idCliente = idCliente;
        this.Cui = Cui;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCui() {
        return Cui;
    }

    public void setCui(String Cui) {
        this.Cui = Cui;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
}
