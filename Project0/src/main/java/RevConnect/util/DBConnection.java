package RevConnect.util;

import java.sql.*;

public class DBConnection {

    private  static final String URL ="jdbc:mysql://localhost:3306/RevConnect";
    private  static final String USERNAME="root";
    private  static final String PASSWORD="root123";

    private DBConnection(){}

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}