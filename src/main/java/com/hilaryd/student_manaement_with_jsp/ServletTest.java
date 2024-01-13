package com.hilaryd.student_manaement_with_jsp;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "ServletTest", value = "/ServletTest")
public class ServletTest extends HttpServlet {


    private static final long serialVersionUID = 1l;
    @Resource(name = "jdbc/web_student_tracker")
    private DataSource dataSource ;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/plain");
//        creating the connection
        Connection connection = null;
//        the statement
        Statement statement = null;
//        getting the resultset from the statement
        ResultSet resultSet = null;

        try {
//            connection
            connection = dataSource.getConnection();
//            query to the database
            String query = "select * from student";
//            the statement
            statement = connection.createStatement();
//            performing the query to the database
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
//                getting the email
                String email = resultSet.getString("email");
//                printing the email
                printWriter.println(email);
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

}
