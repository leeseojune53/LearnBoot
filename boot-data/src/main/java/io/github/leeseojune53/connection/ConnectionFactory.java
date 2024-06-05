package io.github.leeseojune53.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // TODO config 사용해서 가져오기
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "application";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {
        return new SimpleConnection(getRealConnection());
    }

    private static java.sql.Connection getRealConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?" + "user="
                    + USER + "&password=" + PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
