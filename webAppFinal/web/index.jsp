
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
                <h3 id="fecha"></h3>
                <table border="1" style="width:100%;">
                    <td>
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
                    </td>
                    <td>
                        <h3 id="tipoCuenta">Cuenta de: </h3>
                    </td>
                    <%
                        GetCliente gCliente = new GetCliente();
                        List<Cliente> lstCliente = gCliente.getCliente();
                    %>

                    <td>
                        <h3 id="Cliente">Cliente:</h3>
                    </td>
                    <td>
                        <select onchange="">
                            <option disabled="true" selected="true">Seleccione</option>
                            <option> Abono</option>
                            <option> Retiro</option>
                        </select>
                    </td>
                    <td>
                        <h3 id="cantidadQ">Cambio de $ a Q: Q0.00</h3>
                        <input id="cantidadD" placeholder="cantidad (en $)">
                    </td>
                </table>
                    <br>
                    <button type="submit" value="ingresar">Generar Transaccion</button>
            </form>
        </div>
        <h1 style="margin: 0 10% 0 15%; padding-top: 2%;">Estado de Cuentas</h1>
        <div style="margin: 0 13% 5% 13%; padding:1% 3% 3% 3%;  background-color: red;">

            <h3>Cliente</h3>
            <select id="clienteM" >
                <option disabled="true" selected="true">Seleccione un Cliente</option>

                <%
                    gCliente = new GetCliente();
                    lstCliente = gCliente.getCliente();
                    for (Cliente cliente : lstCliente) {
                %>
                <option value="<%=cliente.getIdCliente()%>" ><%=cliente.getApellido()%>, <%=cliente.getNombre()%></option>
                <%}%>
            </select>
            <br><br>

            <table id="movimiento" border="1" style="width: 100%; margin: 0 1% 0 1%;">
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

                </tbody>
            </table>
        </div>
    </body>
    <script>
        var today = new Date();
        var date = today.getDate() + '-' + today.getMonth() + 1 + '-' + today.getFullYear();
        document.getElementById("fecha").innerHTML = 'Fecha: '+date;
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
            cuenta = a.split(',');
            document.getElementById("Cliente").value = ('Cliente: ' + cuenta[1] + ',' + cuenta[0]);
            $("#Cliente").text('Cliente: ' + cuenta[1] + ',' + cuenta[0]);

            document.getElementById("tipoCuenta").value = 'Cuenta de: ' + cuenta[2];
            $("#tipoCuenta").text('Cuenta de: ' + cuenta[2]);
        }
        function cambioQ(b) {
            q = b * 7.74;
            document.getElementById("cantidadQ").value = 'Q' + q;
            $("#cantidadQ").text('Cambio de $ a Q: Q' + q);
        }
        function borrarFilas() {
            var table = document.getElementById("movimiento");
            var rowCount = table.rows.length;
            while (rowCount != 1) {
                if (rowCount == 1) {
                    alert('No hay filas para eliminar');
                } else {
                    table.deleteRow(rowCount - 1);
                    rowCount = table.rows.length;
                }
            }
        }
        $(document).ready(function () {
            $('#clienteM').on('change', function () {
                clienteM(this.value);
            });
        });
        function clienteM(c) {
            borrarFilas();
        <%
            GetMovimiento gMovimiento = new GetMovimiento();
            List<Movimiento> lstMovimiento = gMovimiento.getMovimiento();
            for (Movimiento movimiento : lstMovimiento) {
        %>
            if (c == <%=movimiento.getIdCliente()%>) {
                var tabla = document.getElementById("movimiento").insertRow(-1);
                var col1 = document.createElement("td");
                col1.innerHTML = <%=movimiento.getIdMovimiento()%>;
                var col2 = document.createElement("td");
                col2.innerHTML = '<%=movimiento.getFechaMovimiento()%>';
                var col3 = document.createElement("td");
                col3.innerHTML = '<%=movimiento.getApellido()%>,<%=movimiento.getNombre()%>';
                            var col4 = document.createElement("td");
                            col4.innerHTML = '<%=movimiento.getCuenta()%>';
                            var col5 = document.createElement("td");
                            col5.innerHTML = '<%=movimiento.getMovimiento()%>';
                            var col6 = document.createElement("td");
                            col6.innerHTML = '<%=movimiento.getTipoCambio()%>';
                            var col7 = document.createElement("td");
                            col7.innerHTML = <%=movimiento.getSaldoQ()%>;
                            var col8 = document.createElement("td");
                            col8.innerHTML = <%=movimiento.getSaldoD()%>;


                            tabla.append(col1, col2, col3, col4, col5, col6, col7, col8);
                        }
        <%}%>
                    }
    </script>
</html>
