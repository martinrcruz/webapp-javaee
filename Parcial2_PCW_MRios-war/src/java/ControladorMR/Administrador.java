/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorMR;

import beansMR.CalculadorMRLocal;
import beansMR.ControladorVentasMR;
import beansMR.ControladorVentasMRLocal;
import clasesMR.RegistroVentasMR;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author martin
 */
public class Administrador extends HttpServlet {

    @javax.ejb.EJB
    private CalculadorMRLocal calculadorMR;

    ControladorVentasMRLocal registroVentas = lookupControladorVentasMRLocal();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*   MANEJO DE ERRORES Y EXCEPCIONES
    A CONTINUACION, USAREMOS LAS SIGUIENTES REDIRECCIONES ASIGNADAS SEGUN EL TIPO DE ERROR
    Error 101 ---> Campos vacios: Se ha enviado un formulario o solicitud sin llenar los campos requeridos.
    Error 102 ---> Tipo de dato invalido: Se ha enviado un formulario o solicitud con datos no validos
    Error 103 ---> 
    Error 104 ---> 
    Error 105 ---> 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            //PROCESO DE DATOS DE CaputraDatos.jsp
            if (request.getParameter("btn1Form1") != null) {
                //DECLARAMOS LOS DATOS
                String nombreVendedor, sexoConductor, tipoConductor, tipoVehiculo, tipoCombustible, promocion, cantidadCombustible;

                //RECIBIMOS LOS DATOS
                nombreVendedor = (String) request.getParameter("nombreVendedor");
                sexoConductor = (String) request.getParameter("sexo");
                tipoConductor = (String) request.getParameter("tipoConductor");
                tipoVehiculo = (String) request.getParameter("tipoVehiculo");
                tipoCombustible = (String) request.getParameter("tipoCombustible");
                cantidadCombustible = (String) request.getParameter("cantidadCombustible");
                promocion = (String) request.getParameter("promocion");

                //VALIDAMOS DEL LADO DEL SERVIDOR QUE LOS DATOS HAYAN LLEGADO DE MANERA CORRECTA,
                //EN CASO DE NO ESTAR CORRECTO,, SEGUN LA CONDICIONAL IF, SE DESPACHA A UNA PAGINA DE ERRORES
                if (nombreVendedor != null || !(nombreVendedor.equals(""))
                        || sexoConductor != null || !(sexoConductor.equals(""))
                        || tipoConductor != null || !(tipoConductor.equals(""))
                        || tipoVehiculo != null || !(tipoVehiculo.equals(""))
                        || tipoCombustible != null || !(tipoCombustible.equals(""))
                        || cantidadCombustible != null || !(cantidadCombustible.equals(""))
                        || promocion != null || !(promocion.equals(""))) {
                    try {
                        int cantCombustible;
                        cantCombustible = Integer.parseInt(cantidadCombustible);
                        int totalVenta = calculadorMR.dineroTotalSinDescuento(tipoCombustible, cantCombustible); //GENERA TOTAL DE VENTA

                        int dineroDescuentoTipoConductor = calculadorMR.dineroDescuentoTipoConductor(tipoConductor, totalVenta); //GENERA DESCUENTO TIPO CONDUCTOR
                        int dineroPromoSalud = calculadorMR.dineroPromoSalud(promocion); // GENERA DESCUENTO PROMOCION

                        int totalFinal = calculadorMR.valorFinal(totalVenta, dineroDescuentoTipoConductor, dineroPromoSalud); // GENERA VALOR FINAL

                        this.registroVentas.agregarVentaMR(nombreVendedor, sexoConductor, tipoConductor, tipoVehiculo, tipoCombustible, cantCombustible, promocion, dineroPromoSalud, dineroDescuentoTipoConductor, totalFinal);
                        RegistroVentasMR temp = this.registroVentas.ultimoRegistroVentaMR();
                        request.setAttribute("ultimoRegistro", temp);

                        RequestDispatcher despachador = request.getRequestDispatcher("RegistroExitoso.jsp");
                        despachador.forward(request, response);
                    } catch (Exception e) {
                        RequestDispatcher despachador = request.getRequestDispatcher("ErroresMR/Error102.jsp");
                        despachador.forward(request, response);
                    }

                } else {
                    RequestDispatcher despachador = request.getRequestDispatcher("ErroresMR/Error101.jsp");
                    despachador.forward(request, response);
                }

            }

            //ACTIVA REPORTE 1
            if (request.getParameter("btnReporte1") != null) {
                List<RegistroVentasMR> temp = new ArrayList<>();

                temp = this.registroVentas.retornaTodasLasVentasMR();
                request.setAttribute("Registros", (List<RegistroVentasMR>) temp);

                RequestDispatcher despachador = request.getRequestDispatcher("VistasMR/Reporte1.jsp");
                despachador.forward(request, response);

            }

            //ACTIVA REPORTE 2
            if (request.getParameter("btnReporte2") != null) {

                String tipoVehiculo = request.getParameter("tipoVehiculo");
                String tipoCombustible = request.getParameter("tipoCombustible");

                if (tipoVehiculo != null || !(tipoVehiculo.equals(""))
                        || tipoCombustible != null || !(tipoCombustible.equals(""))) {

                    List<RegistroVentasMR> temp = this.registroVentas.retornaFiltroCombustibleVehiculo(tipoVehiculo, tipoCombustible);
                    request.setAttribute("listaFiltradaCV", temp);
                    request.setAttribute("vehiculo", (String) tipoVehiculo);
                    request.setAttribute("combustible", (String) tipoCombustible);

                    RequestDispatcher despachador = request.getRequestDispatcher("VistasMR/Reporte2.jsp");
                    despachador.forward(request, response);

                } else {
                    RequestDispatcher despachador = request.getRequestDispatcher("ErroresMR/Error101.jsp");
                    despachador.forward(request, response);
                }
            }

            //ACTIVA REPORTE 3 ---> ESTADISTICAS GENERALES -> ACCESO A REPORTES
            if (request.getParameter("btnReporte3") != null) {

                RequestDispatcher despachador = request.getRequestDispatcher("VistasMR/Reporte3.jsp");
                despachador.forward(request, response);
            }

            //ACTIVA REPORTE 3.1 ---> TOTAL RECAUDADO POR VENDEDOR
            if (request.getParameter("reporte3a") != null) {
                String nombreVendedor = request.getParameter("nombreVendedor");
                if (nombreVendedor != null || !(nombreVendedor.equals(""))) {
                    int dineroVendedor = this.registroVentas.retornaDineroVendedor(nombreVendedor);
                    List<RegistroVentasMR> filtroVendedor = this.registroVentas.retornaFiltroVendedor(nombreVendedor);
                    request.setAttribute("dineroVendedor", (Integer) dineroVendedor);
                    request.setAttribute("nombreVendedor", (String) nombreVendedor);
                    request.setAttribute("filtroVendedor", (List<RegistroVentasMR>) filtroVendedor);

                    RequestDispatcher despachador = request.getRequestDispatcher("VistasMR/Reporte3A.jsp");
                    despachador.forward(request, response);
                } else {
                    RequestDispatcher despachador = request.getRequestDispatcher("ErroresMR/Error101.jsp");
                    despachador.forward(request, response);
                }
            }

            //ACTIVA REPORTE 3.2 ---> TOTAL LITROS FILTRADO POR TIPO COMBUSTIBLE
            if (request.getParameter("reporte3b") != null) {
                String tipoCombustible = request.getParameter("tipoCombustible");
                if (tipoCombustible != null || !(tipoCombustible.equals(""))) {
                    int cantidadCombustible = this.registroVentas.retornaCantLitrosFiltradoComb(tipoCombustible);
                    List<RegistroVentasMR> filtroCombustible = this.registroVentas.retornaFiltroCombustible(tipoCombustible);
                    request.setAttribute("tipoCombustible", tipoCombustible);
                    request.setAttribute("cantidadCombustible", (Integer) cantidadCombustible);
                    request.setAttribute("filtradoCombustible", (List<RegistroVentasMR>) filtroCombustible);

                    RequestDispatcher despachador = request.getRequestDispatcher("VistasMR/Reporte3B.jsp");
                    despachador.forward(request, response);
                } else {
                    RequestDispatcher despachador = request.getRequestDispatcher("ErroresMR/Error101.jsp");
                    despachador.forward(request, response);
                }
            }
            //ACTIVA REPORTE 3.3 ---> CANTIDAD DE MUJERES QUE COMPRARON 93
            if (request.getParameter("reporte3c") != null) {
                int cantMujeres = this.registroVentas.retornaCantMujeres93();
                List<RegistroVentasMR> listaMujeres = this.registroVentas.retornaListaMujeres93();

                request.setAttribute("cantMujeres", (Integer) cantMujeres);
                request.setAttribute("listaMujeres", (List<RegistroVentasMR>) listaMujeres);

                RequestDispatcher despachador = request.getRequestDispatcher("VistasMR/Reporte3C.jsp");
                despachador.forward(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private ControladorVentasMRLocal lookupControladorVentasMRLocal() {
        try {
            Context c = new InitialContext();
            return (ControladorVentasMRLocal) c.lookup("java:global/Parcial2_PCW_MRios/Parcial2_PCW_MRios-ejb/ControladorVentasMR!beansMR.ControladorVentasMRLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
