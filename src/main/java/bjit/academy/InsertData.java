package bjit.academy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
    public void insertData(String id, String name){
        String connectionString = "jdbc:mysql://localhost:3306/bjit_db";
        String user = "root";
        String password = "";
        String insertDataSQL = "INSERT INTO trainee VALUES ('"+id+"', '"+name+"');"; //SQL is so sensitive , write it in correct format
        try {
            Connection connection = DriverManager.getConnection(connectionString,user,password);
            Statement statement = connection.createStatement();
            boolean tableExists = statement.execute("SHOW TABLES LIKE 'trainee'");
            // Check if the table exists
            if(!tableExists){
                System.out.println("The table does not exists.");
                statement.close();
                connection.close();
                return;
            }

            // Insert data into the table
            int rowsInserted = statement.executeUpdate(insertDataSQL);
            if( rowsInserted > 0 ){
                System.out.println(rowsInserted + " rows inserted successfully.");
            } else {
                System.out.println("No rows inserted.");
            }

            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
}
