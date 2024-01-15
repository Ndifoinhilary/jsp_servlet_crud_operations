package com.hilaryd.student_manaement_with_jsp;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDBUtil {
    private static DataSource dataSource;

    StudentDBUtil(DataSource dataSource){
        this.dataSource = dataSource;
    }



    public List<Students> getStudent() throws Exception {

        List<Students> students = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {


            connection = dataSource.getConnection();
            String sql = "select * from student order by  first_name";
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lasttName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                Students students1 = new Students(id, firstName, lasttName, email);
                students.add(students1);
            }
            return students;
        } finally {
            close(connection, statement, resultSet);
        }
    }
        private static void close(Connection connection, Statement statement, ResultSet resultSet){
          try {
              if (connection != null){
                  connection.close();
              }
              if (statement != null){
                  statement.close();
              }
              if (resultSet != null){
                  resultSet.close();
              }
          }catch (Exception exception){
              exception.printStackTrace();
          }
        }
    public static void addStudent(Students students) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            String sql = "INSERT INTO student" + "(first_name, last_name, email)" + "VALUES(?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, students.getFirstName());
            preparedStatement.setString(2, students.getLastName());
            preparedStatement.setString(3, students.getEmail());
            preparedStatement.execute();
        }
        finally {
            close(connection, preparedStatement, null);
        }
    }

}
