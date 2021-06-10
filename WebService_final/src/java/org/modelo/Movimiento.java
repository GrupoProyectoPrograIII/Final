/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelo;

import java.sql.Timestamp;

/**
 *
 * @author family.user
 */
public class Movimiento {
    private int idMovimiento;
    private Timestamp fechaMovimiento;
    private int idCliente;
    private int idCuenta;
    private int tipoMovimiento;
    private String usuario;
    private double tipoCambio;
    private double saldoQ;
    private double saldoD;

    public Movimiento() {
    }

    public Movimiento(int idMovimiento, Timestamp fechaMovimiento, int idCliente, int idCuenta, int tipoMovimiento, String usuario, double tipoCambio, double saldoQ, double saldoD) {
        this.idMovimiento = idMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.idCliente = idCliente;
        this.idCuenta = idCuenta;
        this.tipoMovimiento = tipoMovimiento;
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

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
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
