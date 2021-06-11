package org.servicios;

import gt.gob.banguat.variables.ws.TipoCambio;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;
import org.dao.DaoCliente;
import org.dao.DaoCuenta;
import org.dao.DaoMovimiento;
import org.dao.DaoTipoCuenta;
import org.dao.DaoTipoMovimiento;
import org.modelo.Cliente;
import org.modelo.Cuenta;
import org.modelo.Movimiento;
import org.modelo.TipoCuenta;
import org.modelo.TipoMovimiento;

@WebService(serviceName = "Servicios")
public class Servicios {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/www.banguat.gob.gt/variables/ws/TipoCambio.asmx.wsdl")
    private TipoCambio service;

    DaoCuenta daoCuenta = new DaoCuenta();
    DaoCliente daoCliente = new DaoCliente();
    DaoMovimiento daoMovimiento = new DaoMovimiento();
    DaoTipoCuenta daoTipoCuenta = new DaoTipoCuenta();
    DaoTipoMovimiento daoTipoMovimiento = new DaoTipoMovimiento();

    Cuenta cuenta = new Cuenta();
    Cliente cliente = new Cliente();
    Movimiento movimiento = new Movimiento();
    TipoCuenta tipoCuenta = new TipoCuenta();
    TipoMovimiento tipoMovimiento = new TipoMovimiento();

    List<Cuenta> lstCuenta;
    List<Cliente> lstCliente;
    List<Movimiento> lstMovimiento;
    List<TipoCuenta> lstTipoCuenta;
    List<TipoMovimiento> lstTipoMovimiento;

    @WebMethod(operationName = "getCuentas")
    public List<Cuenta> getLstCuentas() {
        lstCuenta = daoCuenta.listar();
        return lstCuenta;
    }

    @WebMethod(operationName = "setCuentas")
    public void setLstCuentas(List<Cuenta> lstCuentas) {
        this.lstCuenta = lstCuentas;
    }

    @WebMethod(operationName = "getCliente")
    public List<Cliente> getLstCliente() {
        lstCliente = daoCliente.listar();
        return lstCliente;
    }

    @WebMethod(operationName = "setCliente")
    public void setLstCliente(List<Cliente> lstCliente) {
        this.lstCliente = lstCliente;
    }

    @WebMethod(operationName = "getMovimiento")
    public List<Movimiento> getLstMovimiento() {
        lstMovimiento = daoMovimiento.listar();
        return lstMovimiento;
    }

    @WebMethod(operationName = "setMovimiento")
    public void setLstMovimiento(List<Movimiento> lstMovimiento) {
        this.lstMovimiento = lstMovimiento;
    }

    @WebMethod(operationName = "getTipoCuenta")
    public List<TipoCuenta> getLstTipoCuenta() {
        lstTipoCuenta = daoTipoCuenta.listar();
        return lstTipoCuenta;
    }
    
    @WebMethod(operationName = "setTipoCuenta")
    public void setLstTipoCuenta(List<TipoCuenta> lstTipoCuenta) {
        this.lstTipoCuenta = lstTipoCuenta;
    }

    @WebMethod(operationName = "getTipoMovimiento")
    public List<TipoMovimiento> getLstTipoMovimiento() {
        lstTipoMovimiento = daoTipoMovimiento.listar();
        return lstTipoMovimiento;
    }

    @WebMethod(operationName = "setTipoMovimiento")
    public void setLstTipoMovimiento(List<TipoMovimiento> lstTipoMovimiento) {
        this.lstTipoMovimiento = lstTipoMovimiento;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarClienteID")
    public Cliente listarClienteID(@WebParam(name = "idCliente") int idCliente) {
        Cliente id = daoCliente.list(idCliente);
        return id;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarCuentaID")
    public Cuenta listarCuentaID(@WebParam(name = "idCuenta") int idCuenta) {
        Cuenta id = daoCuenta.list(idCuenta);
        return id;
    }
}
