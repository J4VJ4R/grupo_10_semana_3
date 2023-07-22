/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.supermarket;

import com.grupo10.mvc.StateUnit;
import com.grupo10.supermarket.models.Customer;
import com.grupo10.supermarket.models.SuperMarket;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author jeiss
 */
public class AppState {
    private final StateUnit<SuperMarket> currentSuperMarket = new StateUnit<>(null);
    private final StateUnit<Collection<SuperMarket>> currentSuperMarkets = new StateUnit<>(new ArrayList<>());
    private final StateUnit<SuperMarket> currentSuperMarketFilter = new StateUnit<>(null);
    
    private final StateUnit<Collection<Customer>> currentCustomers = new StateUnit<>(new ArrayList<>());

    public StateUnit<SuperMarket> getCurrentSuperMarket() {
        return currentSuperMarket;
    }

    public StateUnit<Collection<SuperMarket>> getCurrentSuperMarkets() {
        return currentSuperMarkets;
    }

    public StateUnit<SuperMarket> getCurrentSuperMarketFilter() {
        return currentSuperMarketFilter;
    }

    public StateUnit<Collection<Customer>> getCurrentCustomers() {
        return currentCustomers;
    }
}
