package org.daedusp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnectionManager {

    private static Connection sqliteConnection;

    private SQLiteConnectionManager() {
        // Private constructor to prevent instantiation
    }

    public static Connection getSQLiteConnection(String databasePath) {
        if (sqliteConnection == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                sqliteConnection = DriverManager.getConnection("jdbc:sqlite:" + databasePath);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return sqliteConnection;
    }

    public static void closeSQLiteConnection() {
        if (sqliteConnection != null) {
            try {
                sqliteConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                sqliteConnection = null;
            }
        }
    }
}
