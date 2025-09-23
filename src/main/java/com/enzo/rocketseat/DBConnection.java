package com.enzo.rocketseat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    private Connection dbConnection;

    private final String URL = "jdbc:postgresql://localhost:5432/mvn_rocketseat";
    private final String USER = "postgres";
    private final String PSW = "root";

    private DBConnection() throws SQLException {
        try {
            this.dbConnection = DriverManager.getConnection(URL, USER, PSW);
            System.out.println("Conexão foi estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Falha na conexão:" + e.getMessage());
            throw e;
        }
    }

    public static DBConnection getInstance() throws SQLException{
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getDbConnection() {
        return dbConnection;
    }
}
