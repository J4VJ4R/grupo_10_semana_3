/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.supermarket.controllers;

import com.grupo10.supermarket.AppState;
import com.grupo10.supermarket.models.ICustomerRepository;
import com.grupo10.supermarket.models.SuperMarket;
import com.grupo10.supermarket.views.Customers;

/**
 *
 * @author jeiss
 */
public class CustomersController {
    private final Customers view;
    private final ICustomerRepository customersRepository;
    private final AppState appState;

    public CustomersController(Customers view, ICustomerRepository customersRepository, AppState appState) {
        this.view = view;
        this.customersRepository = customersRepository;
        this.appState = appState;
    }

    public void setup() {
        appState.getCurrentSuperMarkets().onChange((newData, oldData) -> {
            view.superMarketFilterComboBox.removeAllItems();
            newData.forEach(market -> view.superMarketFilterComboBox.addItem(market));
        });
        
        // Initial setup
        var currentMarkets = appState.getCurrentSuperMarkets().getValue();
        currentMarkets.forEach(market -> view.superMarketFilterComboBox.addItem(market));
        
        view.superMarketFilterComboBox.addActionListener((e) -> {
            Object selectedMarket = view.superMarketFilterComboBox.getSelectedItem();
            if(selectedMarket == null) {
                return;
            }
            appState.getCurrentSuperMarketFilter().setValue((SuperMarket)selectedMarket);
        });
        
        appState.getCurrentSuperMarketFilter().onChange((newValue, oldValue) -> {
            if(newValue == null || newValue.getId().equals(oldValue.getId())){
                return;
            }
            
            var customers = customersRepository.listByMarket(newValue.getId());
            appState.getCurrentCustomers().setValue(customers);
        });
        
        appState.getCurrentCustomers().onChange((newValue, oldValue) -> {
            view.renderData(newValue);
        });
    }
}
