<%-- 
    Document   : CapturaDatos
    Created on : Jun 16, 2021, 4:10:19 PM
    Author     : martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    </head>

    <body style="background-image:url('Images/xK.gif'); background-repeat: repeat; background-size: 100%">


        <!-- Menu de navegacion -->
        <ul class="nav justify-content-center pt-3 pb-2" style="background-color: #4F5165;">
            <li class="nav-item">
                <a class="nav-link active"  style="color: #9096ae"  href="index.html">Menu principal</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"   style="color: #FFFFFF" href="CapturaDatos.jsp">Agregar Venta</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"  style="color: #9096ae" href="MenuReportes.jsp">Menu Reportes</a>
            </li>
        </ul>
        <div class="container-fluid p-0 m-0">

            <div class="row">

                <div class="col-3">

                </div>

                <div class="col-6">
                    <div class="container-fluid p-5 mt-5" style="background-color: rgba(219, 219, 219, 0.82); border-radius: 10px;">
                        <h1 class="text-center">Formulario para registro de ventas</h1>
                        <hr>

                        <form action="Administrador" method="get">  


                            <!-- Ingreso nombre de vendedor --> 
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Nombre Vendedor</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="nombreVendedor" value="" placeholder="Ingrese el nombre del vendedor..." required>
                                </div>
                            </div>
                            <hr>

                            <!-- Ingreso de alternativas RADIO con respecto a SEXO-->  
                            <fieldset class="form-group row">
                                <legend class="col-form-label col-sm-2 float-sm-left pt-0">Sexo Conductor</legend>
                                <div class="col-sm-4">

                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="sexo" value="M" checked>
                                        <label class="form-check-label" for="sexo">
                                            Masculino
                                        </label>
                                    </div>
                                </div>
                                <div class="col-sm-4">

                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="sexo" value="F">
                                        <label class="form-check-label" for="sexo">
                                            Femenino
                                        </label>
                                    </div>
                                </div>
                            </fieldset>
                            <hr>

                            <!-- Ingreso de alternativas RADIO con respecto a TIPO DE CONDUCTOR-->  
                            <fieldset class="form-group row">
                                <legend class="col-form-label col-sm-2 float-sm-left pt-0">Tipo de conductor</legend>
                                <div class="col-sm-4">

                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="tipoConductor" value="normal" checked>
                                        <label class="form-check-label" for="tipoConductor">
                                            Normal (0% dcto.)
                                        </label>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="tipoConductor" value="vip">
                                        <label class="form-check-label" for="tipoConductor">
                                            Vip (10% dcto.)
                                        </label>
                                    </div>
                                </div>
                            </fieldset>
                            <hr>




                            <!-- Ingreso de alternativas SELECT para TIPO DE VEHICULO -->
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Tipo Vehiculo</label>
                                <div class="col-sm-4">
                                    <select name="tipoVehiculo" required>
                                        <option value="">Seleccione un tipo de vehiculo</option>
                                        <option value="auto" >Automovil</option>
                                        <option value="camioneta" >Camioneta</option>
                                        <option value="moto" >Motocicleta</option>
                                    </select>
                                </div>
                                </label>

                            </div>
                            <hr>

                            <!-- Ingreso de alternativas SELECT para TIPO DE COMBUSTIBLE -->
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Tipo Combustible</label>
                                <div class="col-sm-4">
                                    <select name="tipoCombustible" required >
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
                            <hr>

                            <!-- Ingreso de CANTIDAD DE LITROS--> 
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Cantidad de litros:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="cantidadCombustible" value="" placeholder="Ingrese la cantidad de combustible a cargar..." required>
                                </div>
                            </div>
                            <hr>

                            <!-- Ingreso de alternativas RADIO con respecto a PROMOCION ALCOHOL GEL-->  
                            <fieldset class="form-group row">
                                <legend class="col-form-label col-sm-2 float-sm-left pt-0">Promocion Alcohol Gel</legend>
                                <div class="col-sm-2">
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="promocion" value="no" checked>
                                        <label class="form-check-label" for="promocion">
                                            No
                                        </label>
                                    </div>
                                </div>

                                <div class="col-sm-3">
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="promocion" value="20ml">
                                        <label class="form-check-label" for="promocion">
                                            20 ml ($1.000)
                                        </label>
                                    </div>
                                </div>


                                <div class="col-sm-5">
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="promocion" value="210ml">
                                        <label class="form-check-label" for="promocion">
                                            210 ml ($3.000)
                                        </label>
                                    </div>
                                </div>


                            </fieldset>
                            <hr>
                            <br>

                            <div class="container-fluid">
                                <div class="row justify-content-center">
                                    <div class="col-3">
                                        <a class="btn btn-info pl-5 pr-5" href="index.html">Menu</a>
                                    </div>
                                    <div class="col-3"> 
                                        <input class="btn btn-success" type="submit" value="Registrar Venta" name="btn1Form1">
                                    </div>
                                    <div class="col-3">
                                        <input class="btn btn-warning" type="reset" value="Limpiar Formulario" name="btn2Form1">
                                    </div>


                                </div>
                            </div>



                        </form>

                    </div>
                </div>
            </div>
            <div class="col-3">

            </div>
        </div>


    </body>
</html>
