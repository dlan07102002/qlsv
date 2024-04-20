package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection con = null;

        try {
            //Register the Oracle JDBC driver with DriverManager
            DriverManager.registerDriver(new Driver() );

            String url = "jdbc:mySQL://localhost:3306/qlsv";
            String username = "root";
            String password = "382526";

            //Create connection
            con = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return con;
    }

    public static void closeConnection(Connection con){
        try {
            if(con!=null){
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
