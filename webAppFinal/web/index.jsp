
<%@page import="org.servicios.GetMovimiento"%>
<%@page import="org.servicios.Movimiento"%>
<%@page import="org.servicios.Cliente"%>
<%@page import="org.servicios.GetCliente"%>
<%@page import="org.servicios.TipoCuenta"%>
<%@page import="org.servicios.GetTipoCuenta"%>
<%@page import="org.servicios.GetCuentas"%>
<%@page import="org.servicios.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <title>Banco</title>

    </head>
    <body>
        <h1 style="margin: 0 20% 0 15%; padding-top: 2%;">Transacciones</h1>
        <div style="margin: 0 13% 0 13%; padding:1% 3% 3% 3%;  background-color: red;">
            <form>
                <h3>Fecha: hoy</h3>
                <h3>Cuentas:</h3>
                <select id="cuenta">

                    <option disabled="true" selected="true">Seleccione una cuenta</option>
                    <%
                        GetCuentas gCuentas = new GetCuentas();
                        List<Cuenta> lstCuenta = gCuentas.getCuentas();
                        for (Cuenta cuenta : lstCuenta) {
                    %>
                    <option value="<%=cuenta.getNombreCliente()%>,<%=cuenta.getApellidoCliente()%>,<%=cuenta.getDescripcion()%>"><%=cuenta.getNumeroCuenta()%></option>
                    <%}%>
                </select>

                <h3 id="tipoCuenta">Cuenta de: </h3>

                <%
                    GetCliente gCliente = new GetCliente();
                    List<Cliente> lstCliente = gCliente.getCliente();
                %>
                <h3 id="Cliente">Cliente:</h3>
                <select onchange="">
                    <option disabled="true" selected="true">Seleccione</option>
                    <option> Abono</option>
                    <option> Retiro</option>
                </select>
                <br><br>
                <input id="cantidadD" placeholder="cantidad (en $)"><h3 id="cantidadQ">Q</h3>
                
                <button>Generar Transaccion</button>
            </form>
        </div>
        <h1 style="margin: 0 10% 0 15%; padding-top: 2%;">Estado de Cuentas</h1>
        <div style="margin: 0 13% 0 13%; padding:1% 3% 3% 3%;  background-color: red;">

            <h3>Cliente</h3>
            <select>
                <option disabled="true" selected="true">Seleccione un Cliente</option>

                <%
                    gCliente = new GetCliente();
                    lstCliente = gCliente.getCliente();
                    for (Cliente cliente : lstCliente) {
                %>
                <option><%=cliente.getApellido()%>, <%=cliente.getNombre()%></option>
                <%}%>
            </select>
            <br><br>

            <table border="1" style="width: 100%">
                <thead>
                <th>Id Movimiento</th>
                <th>Fecha Movimiento</th>
                <th>Cliente</th>
                <th>Cuenta</th>
                <th>Tipo Movimiento</th>
                <th>Tipo Cambio</th>
                <th>Saldo Q</th>
                <th>Saldo $</th>
                </thead>
                <tbody>
                    <%
                        GetMovimiento gMovimiento = new GetMovimiento();
                        List<Movimiento> lstMovimiento = gMovimiento.getMovimiento();
                        for (Movimiento movimiento : lstMovimiento) {
                    %>
                    <tr>
                        <td><%=movimiento.getIdMovimiento()%></td>
                        <td><%=movimiento.getFechaMovimiento()%></td>
                        <td><%=movimiento.getApellido()%>,<%=movimiento.getNombre()%></td>
                        <td><%=movimiento.getCuenta()%></td>
                        <td><%=movimiento.getMovimiento()%></td>
                        <td><%=movimiento.getTipoCambio()%></td>
                        <td><%=movimiento.getSaldoQ()%></td>
                        <td><%=movimiento.getSaldoD()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
    <script>
        $(document).ready(function () {
            $('#cuenta').on('change', function () {
                datos(this.value);
            });
        });
        $(document).ready(function () {
            $('#cantidadD').on('change', function () {
                cambioQ(this.value);
            });
        });
        function datos(a) {
            console.log(a);
            cuenta = a.split(',');
            document.getElementById("Cliente").value = ('Cliente: ' + cuenta[1] + ',' + cuenta[0]);
            $("#Cliente").text('Cliente: ' + cuenta[1] + ',' + cuenta[0]);


            document.getElementById("tipoCuenta").value = 'Cuenta de: ' + cuenta[2];
            $("#tipoCuenta").text('Cuenta de: ' + cuenta[2]);
        }
        function cambioQ(b){
            console.log("$"+b);
            q= b*7.74;
            console.log("Q"+q);
            
            document.getElementById("cantidadQ").value = 'Q' + q;
            $("#cantidadQ").text('Q' + q);
        }
    </script>
</html>
