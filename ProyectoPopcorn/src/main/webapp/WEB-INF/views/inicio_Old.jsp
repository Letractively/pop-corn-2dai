<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <title>Project PopCorn</title>
    </head>
    <body>
        <div style="text-align:center; background-color: silver;">

            <img src="Image/Project_Popcorn.png" width="500" height="500">
            </img>
            <br/>
            <center>
                <jsp:include page="/ir_ver_login"/>
                <table>
                    <tr>
                        <td>
                            <form action="/ir_crear_pelicula">
                                <input type="submit" value="CREAR PELICULA"></input>                    
                            </form>
                        </td>
                        <td>
                            <form action="/ir_seleccionar_peliculas">
                                <input type="submit" value="PELICULAS"></input>                    
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <c:if test="${empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal}">
                                <form action="/ir_registrar_usuario">
                                    <input type="submit" value="REGISTRO USUARIO"></input>                    
                                </form> 
                            </c:if>     
                        </td>
                    </tr>
                </table>
                <br/>
            </center>
            <br/>
        </div>
    </body>
</html>