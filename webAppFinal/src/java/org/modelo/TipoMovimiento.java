package org.modelo;

public class TipoMovimiento {
    private int tipoMoviento;
    private String Movimiento;
    private double Factor;

    public TipoMovimiento() {
    }

    public TipoMovimiento(int tipoMoviento, String Movimiento, double Factor) {
        this.tipoMoviento = tipoMoviento;
        this.Movimiento = Movimiento;
        this.Factor = Factor;
    }

    public int getTipoMoviento() {
        return tipoMoviento;
    }

    public void setTipoMoviento(int tipoMoviento) {
        this.tipoMoviento = tipoMoviento;
    }

    public String getMovimiento() {
        return Movimiento;
    }

    public void setMovimiento(String Movimiento) {
        this.Movimiento = Movimiento;
    }

    public double getFactor() {
        return Factor;
    }

    public void setFactor(double Factor) {
        this.Factor = Factor;
    }
    
}
