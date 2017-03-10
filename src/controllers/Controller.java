/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.entity.Resistance;
import views.MainWindow;

/**
 *
 * @author Gabriel Huertas
 */
public class Controller {

    private Resistance resistance;
    private MainWindow mainWindow;

    public Controller() {
        resistance = new Resistance();
        mainWindow = new MainWindow(this);
    }
}
