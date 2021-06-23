<%-- 
    Document   : Reporte
    Created on : Jun 19, 2021, 9:03:05 PM
    Author     : martin
--%>

<%@page import="clasesMR.RegistroVentasMR"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body  style="background-image:url('Images/xK.gif'); background-repeat: repeat; background-size: 100%">




        <!-- Menu de navegacion -->

        <ul class="nav justify-content-center pt-3 pb-2" style="background-color: #4F5165;">
            <li class="nav-item">
                <a class="nav-link active"  style="color: #9096ae"  href="../index.html">Menu principal</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"   style="color: #9096ae" href="../CapturaDatos.jsp">Agregar Venta</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"  style="color: #9096ae"  href="../MenuReportes.jsp">Menu Reportes</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"  style="color: #9096ae" href="Reporte1.jsp">Listado de Datos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"  style="color: #FFFFFF" href="Reporte3c.jsp">REPORTE 3.3</a>
            </li>
        </ul>







        <div class="container-fluid p-0 m-0">

            <div class="row">

                <div class="col-1">

                </div>


                <div class="col-10">
                    <div class="container-fluid p-5 mt-5" style="background-color: rgba(219, 219, 219, 0.82); border-radius: 10px;">
                        <% int cantidadMujeres = (Integer) request.getAttribute("cantMujeres");%>

                        <h2 class="text-center">Registro de litros vendidos por tipo de combustible </h2>
                        <h4>Cantidad de mujeres        : <%= cantidadMujeres%></h4>
                        <hr>
                        <div class="container-fluid">
                            <div class="row">


                                <div class="container">
                                    <div class="row">




                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th scope="col" class="table-secondary">Id venta</th>
                                                    <th scope="col" class="table-secondary">Nombre vendedor</th>
                                                    <th scope="col" class="table-secondary">Sexo conductor</th>
                                                    <th scope="col" class="table-secondary">Tipo conductor</th>
                                                    <th scope="col" class="table-secondary">Tipo vehiculo</th>
                                                    <th scope="col" class="table-secondary">Tipo combustible</th>
                                                    <th scope="col" class="table-secondary">Cant. Combustible</th>
                                                    <th scope="col" class="table-secondary">Promocion Salud</th>
                                                    <th scope="col" class="table-secondary">Dinero Salud</th>
                                                    <th scope="col" class="table-secondary">Dinero Dscto. Tipo</th>
                                                    <th scope="col" class="table-secondary">Valor final</th>
                                                </tr>
                                            </thead>
                                            <tbody

                                                <%
                                                    List<RegistroVentasMR> listTemp = (List<RegistroVentasMR>) request.getAttribute("listaMujeres");
                                                    for (int i = 0; i < listTemp.size(); i++) {
                                                        RegistroVentasMR temp = listTemp.get(i);
                                                        if (temp.getSexoConductor().equals("F") || temp.getTipoCombustible().equals("93")) {

                                                            int idVenta = temp.getId_Venta();
                                                            String nombreVendedor = temp.getNombreVendedor();
                                                            String sexoConductor = temp.getSexoConductor();
                                                            String tipoConductor = temp.getTipoConductor();
                                                            String tipoVehiculo = temp.getTipoVehiculo();
                                                            String tipoCombustible = temp.getTipoCombustible();
                                                            int cantidadCombustible = temp.getCantidadCombustible();
                                                            String promocionSalud = temp.getPromocionSalud();
                                                            int dineroPromoSalud = temp.getDineroPromoSalud();
                                                            int dineroDescuentoTipoConductor = temp.getDineroDescuentoTipoConductor();
                                                            int valorFinalVenta = temp.getValorFinalVenta();

                                                %>
                                                <tr>
                                                    <th scope="row" class="table-success"><%= idVenta%></th>
                                                    <td class="table-success"><%= nombreVendedor%></td>
                                                    <td class="table-success"><%= sexoConductor%></td>
                                                    <td class="table-success"><%= tipoConductor%></td>
                                                    <td class="table-success"><%= tipoVehiculo%></td>
                                                    <td class="table-success"><%= tipoCombustible%></td>
                                                    <td class="table-success"><%= cantidadCombustible%></td>
                                                    <td class="table-success"><%= promocionSalud%></td>
                                                    <td class="table-success"><%=dineroPromoSalud%></td>
                                                    <td class="table-success"><%= dineroDescuentoTipoConductor%></td>
                                                    <td class="table-success"><%= valorFinalVenta%></td>
                                                </tr>

                                                <%
                                                        }
                                                    }
                                                %>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="container-fluid">
                            <div class="row justify-content-center pt-5">


                                <div class="col-md-2">
                                    <a class="btn btn-info pl-5 pr-5" href="index.html">Regresar a Menu</a>
                                </div>
                                <div class="col-md-2">
                                    <a class="btn btn-success pl-5 pr-5" href="Reporte3.jsp">Estadisticas generales</a>
                                </div>
                                <div class="col-md-2">
                                    <a class="btn btn-secondary pl-5 pr-5" href="MenuReportes.jsp">Listado de datos</a>
                                </div>




                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
