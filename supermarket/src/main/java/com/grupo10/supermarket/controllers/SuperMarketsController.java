/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.supermarket.controllers;

import com.grupo10.supermarket.AppState;
import com.grupo10.supermarket.models.ISuperMarketRepository;
import com.grupo10.supermarket.views.SuperMarkets;

/**
 *
 * @author jeiss
 */
public class SuperMarketsController {
    private final ISuperMarketRepository superMarkets;
    private final SuperMarkets superMarketsView;
    private final AppState appState;

    public SuperMarketsController(ISuperMarketRepository superMarketsRepository, SuperMarkets superMarketsView, AppState appState) {
        this.superMarkets = superMarketsRepository;
        this.superMarketsView = superMarketsView;
        this.appState = appState;
    }
    
    public void setup() {
        var currentMarkets = appState.getCurrentSuperMarkets();
        currentMarkets.onChange((newData, oldData) -> superMarketsView.renderData(newData));
        
        var data = superMarkets.list();
        currentMarkets.setValue(data);
    }
}
