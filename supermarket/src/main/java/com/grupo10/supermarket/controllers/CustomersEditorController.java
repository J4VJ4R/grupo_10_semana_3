/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.supermarket.controllers;

import com.grupo10.supermarket.AppState;
import com.grupo10.supermarket.models.Customer;
import com.grupo10.supermarket.models.ICustomerRepository;
import com.grupo10.supermarket.views.CustomerEditor;

/**
 *
 * @author jeiss
 */
public class CustomersEditorController {
    private final CustomerEditor view;
    private final ICustomerRepository customersRepository;
    private final AppState appState;

    public CustomersEditorController(CustomerEditor view, ICustomerRepository customersRepository, AppState appState) {
        this.view = view;
        this.customersRepository = customersRepository;
        this.appState = appState;
    }
    
    public void setup() {
        view.saveCustomerButton.addActionListener((e) -> {
            var data = view.collectData();
            var marketId = appState.getCurrentSuperMarketFilter().getValue().getId();
            
            customersRepository.add(marketId, data);
            
            appState.getCurrentCustomers().setValue(customersRepository.listByMarket(marketId));
            
            view.renderData(new Customer());
        });
    }
}
