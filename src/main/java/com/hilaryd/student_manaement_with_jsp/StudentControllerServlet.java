package com.hilaryd.student_manaement_with_jsp;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentControllerServlet", value = "/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1l;
    private StudentDBUtil studentDBUtil;
    @Resource(name = "jdbc/web_student_tracker")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        try {
            studentDBUtil = new StudentDBUtil(dataSource);
        }catch (Exception exception){
            throw  new ServletException(exception);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            listStudent(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void  listStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<Students> students = studentDBUtil.getStudent();

        request.setAttribute("student_lits", students);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list-students.jsp");
        requestDispatcher.forward(request, response);
    }


}
