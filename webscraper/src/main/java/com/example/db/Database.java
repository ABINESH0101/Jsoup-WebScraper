package com.example.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    private static final String DB_URL = "jdbc:sqlite:scraped.db";

    public static void init() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                String sql = "CREATE TABLE IF NOT EXISTS quotes (\n"
                        + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                        + " quote TEXT NOT NULL,\n"
                        + " author TEXT NOT NULL\n"
                        + ");";
                conn.createStatement().execute(sql);
                logger.info("Database initialized successfully.");
            }
        } catch (SQLException e) {
            logger.error("Failed to initialize database", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
