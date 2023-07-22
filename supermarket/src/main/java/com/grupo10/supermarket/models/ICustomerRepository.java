/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo10.supermarket.models;

import java.util.Collection;

/**
 *
 * @author jeiss
 */
public interface ICustomerRepository {
    public Collection<Customer> listByMarket(int marketId);
    public void add(int marketId, Customer customer);
}
