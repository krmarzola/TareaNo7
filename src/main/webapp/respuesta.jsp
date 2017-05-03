<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/bulma.css">
        <script src="js/jquery-3.2.0.js"></script>
        <script src="js/jquery.validate.js"></script>
        <script src="js/resultado.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Taller 7</title>
    </head>
    <body>
        <div class="container">

            <div class="marzo has-text-centered titulo">
                <h1 class="title is-1">Resultado - Tarea 7</h1>
                <table class="table is-striped">
                    <thead>
                        <tr>
                            <th>Rxy</th>
                            <th>R2</th>
                            <th>Significancia</th>
                            <th>B0</th>
                            <th>B1</th>
                            <th>Yk</th>
                            <th>Rango</th>
                            <th>UPI(70%)-</th>
                            <th>LPI(70%)</th>  
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${resultados.getR()}</td>
                            <td>${resultados.getR2()}</td>
                            <td>${resultados.getSignificancia()}</td>
                            <td>${resultados.getB0()}</td>
                            <td>${resultados.getB1()}</td>
                            <td>${resultados.getYk()}</td>
                            <td>${resultados.getRango()}</td>
                            <td>${resultados.getUPI()}</td>
                            <td>${resultados.getLPI()}</td>
                        </tr>
                    </tbody>  
                </table>

            </div>

            <c:if test="${mensajeError != null}">

                <div class="notification is-danger">
                    <div class="title">Error en la transacción</div>
                    <p>
                        ${mensajeError}
                    </p>
                </div>
            </c:if>


            <c:if test="${mensajeError == null}">

            </c:if>

            <div class="field has-addons has-addons-centered">
                <p class="control">
                    <button class="button is-primary is-large"  id="regresar">Regresar</button>
                </p>
            </div>  
        </div>

    <footer class="footer">
        <div class="container">
            <div class="content has-text-centered">
                <img src="images/copy.png">

                <p class="subtitle is-3">Todos los derechos reservados - Kevin Marzola 2017</p>
            </div>
        </div>
    </footer>        

</body>
</html>
