<%-- 
    Document   : Reporte
    Created on : Jun 19, 2021, 9:03:05 PM
    Author     : martin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body  style="background-image:url('../Images/xK.gif'); background-repeat: repeat; background-size: 100%">




        <!-- Menu de navegacion -->

        <ul class="nav justify-content-center pt-3 pb-2" style="background-color: #4F5165;">
            <li class="nav-item">
                <a class="nav-link active"  style="color: #9096ae"  href="index.html">Menu principal</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"   style="color: #9096ae" href="CapturaDatos.jsp">Agregar Venta</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"  style="color: #9096ae"  href="MenuReportes.jsp">Menu Reportes</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"  style="color: #9096ae" href="Reporte1.jsp">Listado de Datos</a>
            </li>
        </ul>
        <div class="container-fluid p-0 m-0">

            <div class="row">

                <div class="col-1">

                </div>


                <div class="col-10">
                    <div class="container-fluid p-5 mt-5" style="background-color: rgba(219, 219, 219, 0.82); border-radius: 10px;">
                        <div class="jumbotron">
                            <h1 class="display-4">Ups, Error 102 =(</h1>
                            <p class="lead">Tipo de dato ingresado no valido: El tipo de dato que ingresaste no correponde al tipo de dato requerido.</p>
                            <hr class="my-4">
                            <p>La cantidad de litros de combustible, debe ser un valor numerico (Int/entero).</p>
                            <a class="btn btn-primary btn-lg" href="CapturaDatos.jsp" role="button">Volver a intentarlo</a>
                        </div>

                    </div>
                </div>
                <div class="col-1">

                </div>
            </div>
    </body>
</html>
