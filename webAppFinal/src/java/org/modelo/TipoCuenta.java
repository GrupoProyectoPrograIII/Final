package org.modelo;

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
