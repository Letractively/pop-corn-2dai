<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
    <head>
        <script type="text/javascript">            
           
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <script type="text/javascript" src="jQuery/js/jquery-1.4.3.min.js"></script>
        <script type="text/javascript">
            $(document).ready(
                function() {
                    $("#botonRegistro").click(
                        function() {                         
                            $.getJSON(
                                "/ir_comprobar_usuario",
                                {
                                    "username":$("#username").val(),
                                    "password":$("#password").val(),
                                    "categorias":$("#Accion","#Animacion","#Belico",
                                    "#Ciencia_Ficcion","#Comedia","#Documental",
                                    "#Fantastica","#Musical","#Romantica","#Suspense",
                                    "#Terror","#Western").val(),
                                    /*"Accion":$("#Accion").val(),
                                    "Animacion":$("#Animacion").val(),
                                    "Belico":$("#Belico").val(),
                                    "Ciencia Ficcion":$("#Ciencia_Ficcion").val(),
                                    "Comedia":$("#Comedia").val(),
                                    "Documental":$("#Documental").val(),
                                    "Fantanstica":$("#Fantastica").val(),
                                    "Musical":$("#Musical").val(),
                                    "Romantica":$("#Romantica").val(),
                                    "Suspense":$("#Suspense").val(),
                                    "Terror":$("#Terror").val(),
                                    "Western":$("#Western").val(),*/
                                    "idRol":$("#idRol").val()
                                },
                                function(str) {
                                    if(str) {
                                        alert(str);
                                    } else {
                                        window.location = "/inicio";
                                    }
                                }
                            );
                        }
                    );
                }
            );
        </script>
    </head>
    <body>
        
        <form action="/inicio">
            <input type="submit" value="INICIO"/>
        </form>
        <c:if test="${valido == false}">
            <script>
                alert("Usuario ya registrado, inserta otro nombre");                
            </script>
        </c:if>        
        <form action="/ir_comprobar_usuario" method="get">
        <!--<form id="formRegistro">-->
            <table>
                <tr>
                    <td>Nombre de Usuario: </td>
                    <td><input name="username" type="text" maxlength="50" /></td>
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td><input name="password" type="password" maxlength="20" /></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input name="nombre" type="text" maxlength="50" /></td>
                </tr>
                <tr>
                    <td>Apellido: </td>
                    <td><input name="apellido" type="text" maxlength="50" /></td>
                </tr>
                <tr>
                    <td>Categorias favoritas:</td>
                </tr>
                <tr>
                    <td><input name="Accion" type="checkbox" value="Accion"/> Acci&oacute;n</td>
                    <td><input name="Animacion" type="checkbox" value="Animacion"/> Animaci&oacute;n</td>
                    <td><input name="Belico" type="checkbox" value="Belico"/> B&eacute;lico</td>
                </tr>
                <tr>
                    <td><input name="Ciencia_Ficcion" type="checkbox" value="Ciencia Ficcion"/> Ciencia Ficci&oacute;n </td>
                    <td><input name="Comedia" type="checkbox" value="Comedia"/> Comedia</td>
                    <td><input name="Documental" type="checkbox" value="Documental"/> Documental</td>
                </tr>
                <tr>
                    <td><input name="Fantanstica" type="checkbox" value="Fantastica"/> Fant&aacute;stica</td>
                    <td><input name="Musical" type="checkbox" value="Musical"/> Musical</td>
                    <td><input name="Romantica" type="checkbox" value="Romantica"/> Rom&aacute;ntica</td>
                </tr>
                <tr>
                    <td><input name="Suspense" type="checkbox" value="Suspense"/> Suspense</td>
                    <td><input name="Terror" type="checkbox" value="Terror"/> Terror</td>
                    <td><input name="Western" type="checkbox" value="Western"/> Western</td>
                </tr>
            </table>
                
                <input type="hidden" value="${roles.idString}" name="idRol"/>
                <input type="submit" value="Registro" />                   
        </form> 
    </body>
</html>