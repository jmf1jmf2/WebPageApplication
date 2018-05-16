<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/debug" prefix="myLib"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Debug Data</title>
        <style>
            table{
                border: 2px black solid;
            }
            td{
                border: 1px black solid;
            }
        </style>
    </head>
    <body>
        <h2>Session</h2>
        <table>
            <tr>
                <td><b>Name</b></td>
                <td><b>Value</b></td>
            </tr>
            <c:forEach var="p" items="${sessionScope}">
                <tr>
                    <td> <c:out value="${p.key}"/> </td>
                    <td> <c:out value="${p.value}"/> </td>
                </tr>
            </c:forEach>
        </table>

        <h2>ServletContext</h2>
        <table>
            <tr>
                <td><b>Name</b></td>
                <td><b>Value</b></td>
            </tr>
            <c:forEach var="p" items="${sessionScope.servletContext}">
                <tr>
                    <td> <c:out value="${p.key}"/> </td>
                    <td> <c:out value="${p.value}"/> </td>
                </tr>
            </c:forEach>
        </table>


        <h2>Request objects</h2>
        <table>
            <tr>
                <td><b>Name</b></td>
                <td><b>Value</b></td>
            </tr>
            <c:forEach var="p" items="${requestScope}">
                <tr>
                    <td> <c:out value="${p.key}"/> </td>
                    <td> <c:out value="${p.value}"/> </td>
                </tr>
            </c:forEach>
        </table>

        <h2>Form Data Set</h2>
        <table>
            <tr>
                <td><b>Name</b></td>
                <td><b>Value</b></td>
            </tr>
            <c:forEach var="p" items="${param}">
                <tr>
                    <td> <c:out value="${p.key}"/> </td>
                    <td> <c:out value="${p.value}"/> </td>
                </tr>
            </c:forEach>
        </table>
        
        <h2>Headers</h2>
        <table>
            <tr>
                <td><b>Name</b></td>
                <td><b>Value</b></td>
            </tr>
            <c:forEach var="p" items="${header}">
                <tr>
                    <td> <c:out value="${p.key}"/> </td>
                    <td> <c:out value="${p.value}"/> </td>
                </tr>
            </c:forEach>
        </table>

        <h2>Bean Data</h2>

        <%@ page import="java.lang.reflect.*" %>
        <jsp:useBean id="fb" class="registration.FormBean" scope="session" />
        <table>
            <myLib:BeanImporter bean="${fb}">
                <tr>
                    <td>${name}</td>
                    <td>${value}</td>
                </tr>
            </myLib:BeanImporter>
       <!-- %
            Class b = Class.forName("registration.FormBean");
            Field[] fields = b.getDeclaredFields();
            for (Field f : fields) {
                String name = f.getName();
                out.println("<tr>");
                String camelName = "get"
                        + (name.substring(0, 1).toUpperCase() + name.substring(1));
                Method m = b.getMethod(camelName);
                out.println("<td>" + name + "</td>");
                out.println("<td>" + m.invoke(fb) + "</td>");
                out.println("</tr>");
            }
        % -->
        </table>
    </body>
</html>
