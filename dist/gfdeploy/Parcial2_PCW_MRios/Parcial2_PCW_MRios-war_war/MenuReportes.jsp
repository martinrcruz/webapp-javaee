<%-- 
    Document   : Resultados
    Created on : Jun 17, 2021, 6:20:14 PM
    Author     : martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu de reportes</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    </head>
    <body style="background-image:url('Images/xK.gif'); background-repeat: repeat; background-size: 100%">


        <!-- Menu de navegacion -->
        <ul class="nav justify-content-center pt-3 pb-2" style="background-color: #4F5165;">
            <li class="nav-item">
                <a class="nav-link active"  style="color: #9096ae"  href="index.html">Menu principal</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"   style="color: #9096ae" href="CapturaDatos.jsp">Agregar Venta</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"  style="color: #FFFFFF"  href="MenuReportes.jsp">Menu Reportes</a>
            </li>
        </ul>
        <div class="container-fluid p-0 m-0">

            <div class="row">

                <div class="col-2">

                </div>

                <div class="col-8">
                    <div class="container-fluid p-5 mt-5" style="background-color: rgba(219, 219, 219, 0.82); border-radius: 10px;">
                        <h2 class="text-center">Menu de reportes</h2>
                        <hr>
                        <div class="container-fluid">
                            <div class="row">
                                <div class="row mt-1 mb-1 btn-block">
                                    <div class="card">

                                        <div class="card-body">
                                            <h5 class="card-title">REPORTE 1 - Listado de todas las ventas</h5>
                                            <p class="card-text">En esta seccion de reportes, se registra una tabla con todas las ventas de nuestro Almacen.</p>
                                            <div class="text-center">
                                                <form action="Administrador" method="get">
                                                    <input type="submit" name="btnReporte1" value="Ir a Reporte 1" class="btn btn-primary btn-block">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row mt-1 mb-1 btn-block">
                                    <div class="card">

                                        <div class="card-body">
                                            <h5 class="card-title">REPORTE 2 - Listado de ventas filtrado Combustible/Vehiculo</h5>
                                            <p class="card-text">En esta seccion de reportes, se accede al almacen mediante un filtro segun tipo de Combustible y tipo de Vehiculo.</p>
                                            <div class="text-center">
                                                <form action="Administrador" method="get">
                                                    <!-- Ingreso de alternativas SELECT para TIPO DE VEHICULO -->
                                                    <div class="form-group row justify-content-center">
                                                        <label class="col-sm-4 col-form-label  btn-block btn-light">Tipo Vehiculo</label>
                                                        <div class="col-sm-6">
                                                            <select name="tipoVehiculo" required>
                                                                <option value="">Seleccione un tipo de vehiculo</option>
                                                                <option value="auto" >Automovil</option>
                                                                <option value="camioneta" >Camioneta</option>
                                                                <option value="moto" >Motocicleta</option>
                                                            </select>
                                                        </div>
                                                        </label>

                                                    </div>


                                                    <!-- Ingreso de alternativas SELECT para TIPO DE COMBUSTIBLE -->
                                                    <div class="form-group row justify-content-center">
                                                        <label class="col-sm-4 col-form-label btn-block btn-light">Tipo Combustible</label>
                                                        <div class="col-sm-6">
                                                            <select name="tipoCombustible" required>
                                                                <option value="">Seleccione el tipo de combustible</option>
                                                                <option value="93" >93 </option>
                                                                <option value="95" >95</option>
                                                                <option value="97" >97</option>
                                                                <option value="Petroleo" >Petroleo</option>
                                                                <option value="Parafina" >Parafina</option>
                                                            </select>
                                                            </label>
                                                        </div>
                                                        </label>
                                                    </div>
                                                    <input type="submit" name="btnReporte2" value="Ir a Reporte 2" class="btn btn-primary btn-block">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row mt-1 mb-1 btn-block">
                                    <div class="card">

                                        <div class="card-body">
                                            <h5 class="card-title">REPORTE 3 - Estadisticas Generales</h5>
                                            <p class="card-text"> - Dinero total recaudado de todas las ventas, cuando es filtrado por un vendedor en particular. <br>
                                                - Cantidad total de litros vendidos, cuando es filtrado por un tipo de combustible <br>
                                                - Cantidad de mujeres que compraron combustible del tipo 93
                                                .</p>
                                            <div class="text-center">
                                                <form action="Administrador" method="get">
                                                    <input type="submit" name="btnReporte3" value="Ir a Reporte 3" class="btn btn-primary btn-block">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>



                </div>

                <div class="col-2">

                </div>
            </div>


    </body>
</html>
