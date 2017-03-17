/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.entity.Resistance;
import views.MainWindow;

/**
 *
 * @author Gabriel Huertas
 */
public class Controller implements ActionListener{

    private Resistance resistance;
    private MainWindow mainWindow;

    public Controller() {
        resistance = new Resistance();
        mainWindow = new MainWindow(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(Actions.valueOf(e.getActionCommand())){
            case CALCULATE_RESISTANCE:
                calculateResistance();
                   break;
        }
    }

    private void calculateResistance() {
       resistance.calculateValues(mainWindow.getBandColors());
       mainWindow.showResistanceValues(resistance.getResistanceValues());
    }
}
