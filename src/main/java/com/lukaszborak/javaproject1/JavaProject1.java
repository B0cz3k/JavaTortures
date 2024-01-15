/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lukaszborak.javaproject1;

public class JavaProject1 {
    public static void main(String args[]) {
        Simulation simulation = new Simulation();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            MainPage mainPage = new MainPage(simulation);
            mainPage.setVisible(true);
        });
    }
}
