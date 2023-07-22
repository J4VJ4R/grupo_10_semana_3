/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.supermarket.mysql;

import com.grupo10.supermarket.models.ISuperMarketRepository;
import com.grupo10.supermarket.models.SuperMarket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeiss
 */
public class MySQLSuperMarketRepository implements ISuperMarketRepository {

    private final DbConnection connection;

    public MySQLSuperMarketRepository(DbConnection connection) {
        this.connection = connection;
    }

    @Override
    public void add(SuperMarket entry) {
        try {
            var statement = connection.prepareStatement("INSERT INTO supermarkets (name, city) VALUES (?, ?)");
            statement.setString(1, entry.getName());
            statement.setString(2, entry.getCity());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLSuperMarketRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Collection<SuperMarket> list() {
        
        var result = new ArrayList<SuperMarket>();
        
        try {
            var statement = connection.prepareStatement("SELECT * FROM supermarkets");
            var queryResult = statement.executeQuery();
            while(queryResult.next()){
                result.add(new SuperMarket(
                        queryResult.getInt("id"),
                        queryResult.getString("name"),
                        queryResult.getString("city")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLSuperMarketRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }

}
