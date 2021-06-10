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
public class TipoCuenta {
    private int tipoCuenta;
    private String Descripcion;

    public TipoCuenta() {
    }

    public TipoCuenta(int tipoCuenta, String Descripcion) {
        this.tipoCuenta = tipoCuenta;
        this.Descripcion = Descripcion;
    }

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
