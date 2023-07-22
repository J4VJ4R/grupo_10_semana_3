/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.supermarket.mysql;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author jeiss
 */
public class DbConnection {

    private Connection connection;
    private final String user;
    private final String password;
    private final String url;
    private final String database;

    public static DbConnection fromSettings(String settingsFile) throws IOException {
        File configFile = new File(System.getProperty("user.dir") + "/src/main/java/com/grupo10/supermarket/" + settingsFile);

        try (var reader = new FileReader(configFile)) {
            var p = new Properties();
            p.load(reader);

            var user = (String) p.get("user");
            var password = (String) p.get("password");
            var url = (String) p.get("url");
            var database = (String) p.get("database");

            return new DbConnection(url, database, user, password);
        }

    }

    public DbConnection(String url, String database, String user, String password) {
        this.user = user;
        this.password = password;
        this.url = url;
        this.database = database;
    }

    public DbConnection connect() throws SQLException {
        connection = DriverManager.getConnection(url + "/" + database, user, password);
        return this;
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
}
