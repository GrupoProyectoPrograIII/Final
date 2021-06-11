package org.modelo;

import java.sql.Timestamp;

public class Movimiento {
    private int idMovimiento;
    private Timestamp fechaMovimiento;
    private int idCliente;
    private String nombre;
    private String apellido;
    private int idCuenta;
    private String cuenta;
    private int tipoMovimiento;
    private String movimiento;
    private String usuario;
    private double tipoCambio;
    private double saldoQ;
    private double saldoD;

    public Movimiento() {
    }

    public Movimiento(int idMovimiento, Timestamp fechaMovimiento, int idCliente, String nombre, String apellido, int idCuenta, String cuenta, int tipoMovimiento, String movimiento, String usuario, double tipoCambio, double saldoQ, double saldoD) {
        this.idMovimiento = idMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idCuenta = idCuenta;
        this.cuenta = cuenta;
        this.tipoMovimiento = tipoMovimiento;
        this.movimiento = movimiento;
        this.usuario = usuario;
        this.tipoCambio = tipoCambio;
        this.saldoQ = saldoQ;
        this.saldoD = saldoD;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Timestamp getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Timestamp fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
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
