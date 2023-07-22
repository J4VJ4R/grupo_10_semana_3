/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.supermarket.mysql;

import com.grupo10.supermarket.models.Customer;
import com.grupo10.supermarket.models.ICustomerRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeiss
 */
public class MySQLCustomerRepository implements ICustomerRepository {

    private final DbConnection connection;

    public MySQLCustomerRepository(DbConnection connection) {
        this.connection = connection;
    }

    @Override
    public Collection<Customer> listByMarket(int marketId) {
        var result = new ArrayList<Customer>();

        try {
            var statement = connection.prepareStatement("SELECT * FROM customers WHERE supermarket_id = ?");
            statement.setInt(1, marketId);
            
            var queryResult = statement.executeQuery();
            
            while (queryResult.next()) {
                result.add(new Customer(
                        queryResult.getInt("id"),
                        queryResult.getString("name"),
                        queryResult.getString("lastname"),
                        queryResult.getInt("identification"),
                        queryResult.getString("telephone"),
                        queryResult.getString("position")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCustomerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public void add(int marketId, Customer customer) {
        try {
            var statement = connection.prepareStatement(
                    "INSERT INTO customers (name, lastname, identification, telephone, position, supermarket_id) VALUES (?, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getLastname());
            statement.setInt(3, customer.getIdentification());
            statement.setString(4, customer.getTelephone());
            statement.setString(5, customer.getPosition());
            statement.setInt(6, marketId);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCustomerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
