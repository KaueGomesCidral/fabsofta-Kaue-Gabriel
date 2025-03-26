package br.univille.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControllerPessoa implements ActionListener {

    @Override
                //Metodo        parametro   qualquer coisa
    public void actionPerformed(ActionEvent e) {
        if(((JButton)e.getSource()).getName().equals("btnSair")){
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Eu não acredito");
    }
    
}
