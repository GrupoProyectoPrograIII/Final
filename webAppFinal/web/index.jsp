
<%@page import="org.servicios.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.servicios.Cuentas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Banco</title>

    </head>
    <body>
        <h1 style="margin: 0 20% 0 15%; padding-top: 2%;">Transacciones</h1>
        <div style="margin: 0 13% 0 13%; padding:1% 3% 3% 3%;  background-color: red;">
            <form>
                <h3>Fecha: hoy</h3>
                <h3>Cuentas:</h3>
                <select onchange="">
                    <option disabled="true" selected="true">Seleccione una cuenta</option>
                    <option> Opcion 1</option>
                    <option> Opcion 2</option>
                    <option> Opcion 3</option>
                </select>
                <h3>Cuentas de </h3>
                <h3>Cliente Nombre</h3>
                <select onchange="">
                    <option disabled="true" selected="true">Seleccione</option>
                    <option> Abono</option>
                    <option> Retiro</option>
                </select>
                <br><br>
                <input placeholder="cantidad (en $)">
                <br><br>
                <button>Generar Transaccion</button>
            </form>
        </div>
        <h1 style="margin: 0 10% 0 15%; padding-top: 2%;">Estado de Cuentas</h1>
        <div style="margin: 0 13% 0 13%; padding:1% 3% 3% 3%;  background-color: red;">
            <h2>
                <%-- start web service invocation --%><hr/>
                <%
                    Cuentas cuenta = new Cuentas();
                    List<Cuenta> lstCuenta = new ArrayList<>();
                    lstCuenta = cuenta.getCuentas();
                %>
                <%-- end web service invocation --%><hr/>
            </h2>
            <h3>Cliente</h3>
            <select>
                <option disabled="true" selected="true">Seleccione un Cliente</option>
                <option>cliente 1</option>
                <option>cliente 2</option>
                <option>cliente 3</option>
                <option>cliente 4</option> 
            </select>
            <br><br>

            <table border="1" style="width: 100%">
                <thead>
                <th>idCliente</th>
                <th>idCuentas</th>
                <th>numero cuenta</th>
                <th>tipo cuenta</th>
                <th>tipo</th>
                <th>saldo Q</th>
                <th>saldo D</th>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                        <td>5</td>
                        <td>6</td>
                        <td>7</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
