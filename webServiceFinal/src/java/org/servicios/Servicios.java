package org.servicios;

import gt.gob.banguat.variables.ws.InfoVariable;
import gt.gob.banguat.variables.ws.TipoCambio;
import java.util.Iterator;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.ws.WebServiceRef;
import org.dao.DaoCuenta;
import org.modelo.Cuenta;

@WebService(serviceName = "Servicios")
public class Servicios {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/www.banguat.gob.gt/variables/ws/TipoCambio.asmx.wsdl")
    private TipoCambio service;

    DaoCuenta daoCuenta = new DaoCuenta();
    Cuenta cuenta = new Cuenta();
    List<Cuenta> lstCuentas;

    @WebMethod(operationName = "getCuentas")
    public List<Cuenta> getLstCuentas() {
        lstCuentas = daoCuenta.listar();
        return lstCuentas;
    }

    @WebMethod(operationName = "setCuentas")
    public void setLstCuentas(List<Cuenta> lstCuentas) {
        this.lstCuentas = lstCuentas;
    }

}
