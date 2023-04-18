package bjit.academy;

import java.sql.*;
public class DBConnect {

    public void doConnectDB(){
        String connectionString = "jdbc:mysql://localhost:3306/bjit_db";
        String user = "root";
        String password = "";

        // Connect to the database
        Connection conn;

        {
            try {
                conn = DriverManager.getConnection(connectionString, user, password);
                System.out.println("DB Connection is seccussful!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}