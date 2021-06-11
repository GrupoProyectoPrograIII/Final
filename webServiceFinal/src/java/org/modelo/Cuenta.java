package org.modelo;

public class Cuenta {
    private int idCliente;
    private int idCuenta;
    private String numeroCuenta;
    private int tipoCuenta;
    private String descripcion;
    private String nombreCliente;
    private String apellidoCliente;
    private double saldoQ;
    private double saldoD;

    public Cuenta() {
    }

    public Cuenta(int idCliente, int idCuenta, String numeroCuenta, int tipoCuenta, String descripcion, String nombreCliente, String apellidoCliente, double saldoQ, double saldoD) {
        this.idCliente = idCliente;
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.descripcion = descripcion;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.saldoQ = saldoQ;
        this.saldoD = saldoD;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public double getSaldoQ() {
        return saldoQ;
    }

    public void setSaldoQ(double saldoQ) {
        this.saldoQ = saldoQ;
    }

    public double getSaldoD() {
        return saldoD;
    }

    public void setSaldoD(double saldoD) {
        this.saldoD = saldoD;
    }
    
    
    
    
}
