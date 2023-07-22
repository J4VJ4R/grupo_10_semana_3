/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.supermarket.controllers;

import com.grupo10.supermarket.AppState;
import com.grupo10.supermarket.models.ISuperMarketRepository;
import com.grupo10.supermarket.models.SuperMarket;
import com.grupo10.supermarket.views.SuperMarketEditor;

/**
 *
 * @author jeiss
 */
public class SuperMarketsEditorController {
    private final ISuperMarketRepository superMarketsReporitory;
    private final SuperMarketEditor view;
    private final AppState appState;

    public SuperMarketsEditorController(ISuperMarketRepository superMarketsReporitory, SuperMarketEditor superMarketEditorView, AppState appState) {
        this.superMarketsReporitory = superMarketsReporitory;
        this.view = superMarketEditorView;
        this.appState = appState;
    }
    
    public void setup() {
        view.saveSuperMarketButton.addActionListener((e) -> {
            var newSuperMarket = view.collectData();
            superMarketsReporitory.add(newSuperMarket);
            view.renderData(new SuperMarket());
            
            appState.getCurrentSuperMarkets().setValue(superMarketsReporitory.list());
        });
    }
}
