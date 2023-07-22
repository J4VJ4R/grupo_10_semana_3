/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.grupo10.supermarket;

import com.grupo10.supermarket.controllers.CustomersController;
import com.grupo10.supermarket.controllers.SuperMarketsController;
import com.grupo10.supermarket.controllers.SuperMarketsEditorController;
import com.grupo10.supermarket.mysql.MemorySuperMarketRepository;
import com.grupo10.supermarket.views.MainWindow;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jeiss
 */
public class Main {

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        setLookAndFeel();

        var mainWindow = new MainWindow();
        var superMarketsRepository = new MemorySuperMarketRepository();
        var appState = new AppState();

        new SuperMarketsController(
                superMarketsRepository,
                mainWindow.superMarketsView,
                appState
        ).setup();

        new SuperMarketsEditorController(
                superMarketsRepository,
                mainWindow.superMarketsView.superMarketEditor,
                appState
        ).setup();

        new CustomersController(
                mainWindow.customersView,
                appState
        ).setup();

        mainWindow.setVisible(true);
        System.out.println("Hello World!");
    }
}
