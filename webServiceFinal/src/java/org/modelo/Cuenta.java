package org.modelo;

public class Cuenta {
    private int idClient;
    private int idCuenta;
    private String numeroCuenta;
    private int tipoCuenta;
    private String tipo;
    private double saldoQ;
    private double saldoD;

    public Cuenta() {
    }

    public Cuenta(int idClient, int idCuenta, String numeroCuenta, int tipoCuenta, String tipo, double saldoQ, double saldoD) {
        this.idClient = idClient;
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.tipo = tipo;
        this.saldoQ = saldoQ;
        this.saldoD = saldoD;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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
