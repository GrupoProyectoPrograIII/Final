package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.servicios.InsertarMovimiento;
import org.servicios.Movimiento;

@WebServlet(name = "controladorMovimiento", urlPatterns = {"/controladorMovimiento"})
public class controladorMovimiento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorMovimiento</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorMovimiento at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        InsertarMovimiento im = new InsertarMovimiento();
        String usuario;
        int idCliente, idCuenta=0, tipoMovimiento;
        double tipoCambio, saldoQ, saldoD;
        switch (action) {
            case "insertarMovimiento":
                idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
                idCliente =Integer.parseInt(request.getParameter("idCliente"));
                tipoMovimiento = Integer.parseInt(request.getParameter("tipoM"));
                usuario =request.getParameter("usuario");
                tipoCambio =Double.parseDouble(request.getParameter("tipoCambios"));
                saldoQ =Double.parseDouble(request.getParameter("saldoQ"));
                saldoD =Double.parseDouble(request.getParameter("saldoD"));
                im.insertarMovimiento(idCliente, idCuenta, tipoMovimiento, usuario, tipoCambio, saldoQ, saldoD);
                System.out.println("Variables"+idCliente+ idCuenta+ tipoMovimiento+ usuario+ tipoCambio+ saldoQ+ saldoD);
                acceso = "index.jsp";
                break;

        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso); //invoca de modo directo un recurso web
        vista.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
