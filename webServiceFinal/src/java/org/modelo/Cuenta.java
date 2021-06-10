package org.modelo;

public class Cuenta {
    private int idClient;
    private String cliente;
    private int idCuenta;
    private String numeroCuenta;
    private int tipoCuenta;
    private double saldoQ;
    private double saldoD;

    public Cuenta() {
    }

    public Cuenta(int idClient, String cliente, int idCuenta, String numeroCuenta, int tipoCuenta, double saldoQ, double saldoD) {
        this.idClient = idClient;
        this.cliente = cliente;
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoQ = saldoQ;
        this.saldoD = saldoD;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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
