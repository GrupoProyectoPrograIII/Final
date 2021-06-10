/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.servicios;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.dao.DaoCuenta;
import org.modelo.Cuenta;

/**
 *
 * @author family.user
 */
@WebService(serviceName = "Servicios")
public class Servicios {
    DaoCuenta daoCuenta = new DaoCuenta();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "Cuentas")
    public List<Cuenta> Cuentas() {
        //TODO write your implementation code here:
        List datos = daoCuenta.listar();
        return datos;
    }
}
