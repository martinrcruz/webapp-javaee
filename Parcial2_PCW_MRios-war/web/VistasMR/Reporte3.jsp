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
                <a class="nav-link"  style="color: #FFFFFF" href="Reporte1.jsp">Listado de Datos</a>
            </li>
        </ul>
        <div class="container-fluid p-0 m-0">

            <div class="row">

                <div class="col-1">

                </div>


                <div class="col-10">
                    <div class="container-fluid p-5 mt-5" style="background-color: rgba(219, 219, 219, 0.82); border-radius: 10px;">
                        <h2 class="text-center">Estadisticas generales</h2>
                        <hr>
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-12">
                                    <form action="Administrador" method="get" class="text-center">
                                        <div class="container-fluid">
                                            <div class="row justify-content-center">
                                                <div class="col-9">
                                                    <div class="form-group">
                                                        <label for="text">Nombre vendedor: </label>
                                                        <input type="text" class="form-control" name="nombreVendedor" value="">
                                                        <small id="emailHelp" class="form-text text-muted">Ingrese el nombre de un vendedor registrado.</small>
                                                    </div>

                                                </div>
                                                <div class="col-3">
                                                    <input type="submit" class="btn btn-info btn-block pl-5 pr-5 mt-4" name="reporte3a" value="Total por vendedor">
                                                </div>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="container-fluid">
                                            <div class="row justify-content-center">
                                                <div class="col-9">
                                                    <div class="form-group">
                                                        <label for="text">Tipo Combustible</label>
                                                        <select name="tipoCombustible"  class="form-control">
                                                            <option value="">Seleccione el tipo de combustible</option>
                                                            <option value="93" >93 </option>
                                                            <option value="95" >95</option>
                                                            <option value="97" >97</option>
                                                            <option value="Petroleo" >Petroleo</option>
                                                            <option value="Parafina" >Parafina</option>
                                                        </select>
                                                        <small id="emailHelp" class="form-text text-muted">Ingrese el tipo de combustible.</small>
                                                    </div>



                                                </div>
                                                <div class="col-3">
                                                    <input type="submit" class="btn btn-info pl-5 pr-5 mt-4" name="reporte3b" value="Lt. por tipo combustible">
                                                </div>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="container-fluid">
                                            <div class="row justify-content-center">

                                                <div class="col-12">
                                                    <div class="form-group">
                                                        <label for="text">Filtro para cantidad de ventas combustible 93 a mujeres</label>
                                                        <input type="submit" class="btn btn-info pl-5 pr-5 btn-block" name="reporte3c" value= "Cantidad combustible 93 mujeres">
                                                        <small id="emailHelp" class="form-text text-muted">Redirecciona a una lista con el total de ventas y los integrantes de esta.</small>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <hr>
                                        </div>

                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
