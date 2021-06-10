/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author family.user
 */
@WebService(serviceName = "Servicios")
public class Servicios {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/www.banguat.gob.gt/variables/ws/TipoCambio.asmx.wsdl")
    private TipoCambio service;

    DaoCuenta daoCuenta = new DaoCuenta();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Cuentas")
    public String Cuentas() {
        String res="";
        Cuenta cuenta = new Cuenta();
        List<Cuenta> list = daoCuenta.listar();
        Iterator<Cuenta> iter = list.iterator();
        while (iter.hasNext()) {
            cuenta = iter.next();
            res= res +" || "+cuenta.getIdClient() + cuenta.getIdCuenta() + cuenta.getNumeroCuenta() + cuenta.getTipoCuenta() +cuenta.getTipo()+ cuenta.getSaldoQ() + cuenta.getSaldoD();
        }
        return res;
    }

}
