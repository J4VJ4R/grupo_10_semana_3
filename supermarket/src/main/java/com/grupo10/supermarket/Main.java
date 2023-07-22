/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.grupo10.supermarket;

import com.grupo10.supermarket.controllers.CustomersController;
import com.grupo10.supermarket.controllers.SuperMarketsController;
import com.grupo10.supermarket.controllers.SuperMarketsEditorController;
import com.grupo10.supermarket.models.ICustomerRepository;
import com.grupo10.supermarket.models.ISuperMarketRepository;
import com.grupo10.supermarket.mysql.DbConnection;
import com.grupo10.supermarket.mysql.MemorySuperMarketRepository;
import com.grupo10.supermarket.mysql.MySQLCustomerRepository;
import com.grupo10.supermarket.mysql.MySQLSuperMarketRepository;
import com.grupo10.supermarket.views.MainWindow;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
        var appState = new AppState();
        DbConnection connection;
        
        try {
            connection = DbConnection
                    .fromSettings("settings.properties")
                    .connect();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Counld not stablish connection with the database.");
            return;
        }
        
        ISuperMarketRepository superMarketsRepository = new MySQLSuperMarketRepository(connection);
        ICustomerRepository customersRepository = new MySQLCustomerRepository(connection);

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
                customersRepository,
                appState
        ).setup();

        mainWindow.setVisible(true);
        System.out.println("Hello World!");
    }
}
