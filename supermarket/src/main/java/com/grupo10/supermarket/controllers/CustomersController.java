/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.supermarket.controllers;

import com.grupo10.supermarket.AppState;
import com.grupo10.supermarket.models.SuperMarket;
import com.grupo10.supermarket.views.Customers;

/**
 *
 * @author jeiss
 */
public class CustomersController {
    private final Customers view;
    private final AppState appState;

    public CustomersController(Customers view, AppState appState) {
        this.view = view;
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
    }
}
