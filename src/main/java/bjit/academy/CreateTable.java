package bjit.academy;

import java.sql.*;

public class CreateTable {
    public void createTable() {
        // This method will create a table named "trainee" containing two field 'id' , 'name'
        // table name : trainee, Field: 'id', 'name'
        String connectionString = "jdbc:mysql://localhost:3306/bjit_db";
        String user = "root";
        String password = "";

        String createTableSQL = "CREATE TABLE trainee"+
                "(id VARCHAR(255),"+
                "name VARCHAR(255))";
        try {
            Connection connection = DriverManager.getConnection(connectionString,user,password);
            Statement statement = connection.createStatement();
            boolean tableExists = false;
            ResultSet resultSet = statement.executeQuery("SHOW TABLES LIKE 'trainee'");
            if(resultSet.next()){
                tableExists = true;
            }
            resultSet.close();  // next resultset na thakle tableExists false hobe

            if(!tableExists){
                statement.execute(createTableSQL);
                System.out.println("Table created successfully.");
            } else {
                System.out.println("Table already exists.");
            }
            statement.close();
            connection.close();

        } catch (SQLException e){
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
}
