package bjit.academy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowData {
    public void showData(String tableName){
        String connectionString = "jdbc:mysql://localhost:3306/bjit_db";
        String user = "root";
        String password = "";
//        String selectDataSQL = "SELECT * FROM trainee;";
        String selectDataSQL = "SELECT * FROM "+tableName+";";
        try {
            Connection connection = DriverManager.getConnection(connectionString,user,password);
            Statement statement = connection.createStatement();
            boolean tableExists = statement.execute("SHOW TABLES LIKE 'trainee'");
            // Check if the table exists
            if(!tableExists){
                System.out.println("The table does not exist.");
                statement.close();
                connection.close();
                return;
            }

            // Retrieve data from the table
            ResultSet resultSet = statement.executeQuery(selectDataSQL);
            // Print the data to the console
//            while (resultSet.next()) {
//                String id = resultSet.getString("id");
//                String name = resultSet.getString("name");
//                System.out.println(id + " | " + name);
//            }
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                System.out.println(id + " | " + name);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error retrieving data: " + e.getMessage());
        }
    }
}
