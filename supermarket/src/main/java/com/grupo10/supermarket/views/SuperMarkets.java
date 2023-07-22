/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.grupo10.supermarket.views;

import com.grupo10.mvc.DataTableModel;
import com.grupo10.mvc.IRenderData;
import com.grupo10.supermarket.models.SuperMarket;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author jeiss
 */
public class SuperMarkets extends javax.swing.JPanel implements IRenderData<Collection<SuperMarket>> {

    /**
     * Creates new form SuperMarkets
     */
    public SuperMarkets() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        setupTableModel();
        superMarketsTable = new javax.swing.JTable();
        superMarketEditor = new com.grupo10.supermarket.views.SuperMarketEditor();

        setLayout(new java.awt.BorderLayout());

        superMarketsTable.setModel(tableModel);
        jScrollPane1.setViewportView(superMarketsTable);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
        add(superMarketEditor, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public com.grupo10.supermarket.views.SuperMarketEditor superMarketEditor;
    private javax.swing.JTable superMarketsTable;
    // End of variables declaration//GEN-END:variables

    private final DataTableModel<SuperMarket> tableModel = new DataTableModel<>();

    private void setupTableModel() {
        tableModel.addColumn("Name", (e, index, name) -> e.getName());
        tableModel.addColumn("City", (e, index, name) -> e.getCity());
    }

    @Override
    public void renderData(Collection<SuperMarket> data) {
        tableModel.setData(new ArrayList<>(data));
    }
}
