package developer.crud.dbmanager;

import java.sql.*;

public class DBManager {

    public static  Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/developer_teams";
        String user = "gloctarr";
        String password = "ghjuhfvvbhjdfybt";
        return DriverManager.getConnection(url, user, password);
    }

}
