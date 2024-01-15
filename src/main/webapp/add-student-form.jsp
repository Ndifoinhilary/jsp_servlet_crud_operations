<%--
  Created by IntelliJ IDEA.
  User: hilaryd
  Date: 15/01/2024
  Time: 4:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student </title>
    <link rel="stylesheet" type="text/css" href="css/add-student-style.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<dvi id="container">
    <div id="wrapped">
        <div id="header">

            <h2>Full Founder University</h2>

        </div>

    </div>
<h3>Add Student</h3>
    <form action="StudentControllerServlet" method="get">
        <input type="hidden" value="ADD" name="command">
        <table>
            <tbody>
            <tr>
                <td> <label>First Name</label> </td>
                <td> <input  type="text"  name="firstname">  </td>
            </tr>
            <tr>
                <td> <label>Last Name</label> </td>
                <td> <input  type="text"  name="lastname">  </td>
            </tr>
            <tr>
                <td> <label>Email</label> </td>
                <td> <input  type="email"  name="email">  </td>
            </tr>
            <tr>
                <td> <label></label> </td>
                <td> <input  type="submit"  value="submit" name="submit" class="save">  </td>
            </tr>
            </tbody>
        </table>
    </form>
</dvi>

<a href="StudentControllerServlet" id="btn">Back</a>
</body>
</html>
