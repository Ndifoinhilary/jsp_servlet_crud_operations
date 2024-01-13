<%--
  Created by IntelliJ IDEA.
  User: hilaryd
  Date: 13/01/2024
  Time: 6:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>

<body>
<div id="wrapped">
    <div id="header">

        <h2>Full Founder University</h2>

    </div>

</div>

<div id="container">
    <div id="content">

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>


           <c:forEach var="student" items="${student_lits}">
               <tr>
                   <td>${student.firstName}</td>
                   <td>${student.lastName}</td>
                   <td>${student.email}</td>
               </tr>
           </c:forEach>


        </table>
    </div>

</div>


</body>
</html>
