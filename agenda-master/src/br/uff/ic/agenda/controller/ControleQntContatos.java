/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.agenda.controller;

import br.uff.ic.agenda.model.Contato;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author aluno
 */
public class ControleQntContatos implements ListDataListener {
    private final JLabel quantidadeContatos;
    
    public ControleQntContatos(JLabel quantidadeContatos) {
        this.quantidadeContatos = quantidadeContatos;
    }

    @Override
    public void intervalAdded(ListDataEvent e) {
        int quantidade = ((DefaultListModel<Contato>) e.getSource()).getSize();
        quantidadeContatos.setText("Contatos: " + quantidade);
    }

    @Override
    public void intervalRemoved(ListDataEvent e) {
        int quantidade = ((DefaultListModel<Contato>) e.getSource()).getSize();
        quantidadeContatos.setText("Contatos: " + quantidade); 
    }

    @Override
    public void contentsChanged(ListDataEvent e) {
        int quantidade = ((DefaultListModel<Contato>) e.getSource()).getSize();
        quantidadeContatos.setText("Contatos: " + quantidade);    
    }
    
}
