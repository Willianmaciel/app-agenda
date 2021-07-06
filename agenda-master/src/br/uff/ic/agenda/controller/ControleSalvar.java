package br.uff.ic.agenda.controller;

import br.uff.ic.agenda.model.Contato;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ControleSalvar extends KeyAdapter {

    private final JList<Contato> listaContatos;
    private final JTextField campoNome;
    private final JTextField campoEndereco;
    private final JTextField campoEndereco1;
    private final JTextField campoTelefone;
    private final JTextField campoTelefone1;
    private final JTextArea campoDetalhes;
    private final JTextField campoDeBusca;
    
    public ControleSalvar (JList<Contato> listaContatos, JTextField campoDeBusca,JTextField campoNome, JTextField campoEndereco, JTextField campoEndereco1,JTextField campoTelefone, JTextField campoTelefone1,JTextArea campoDetalhes) {
        this.listaContatos = listaContatos;
        this.campoNome = campoNome;
        this.campoEndereco = campoEndereco;
        this.campoEndereco1 = campoEndereco1;
        this.campoTelefone = campoTelefone;
        this.campoTelefone1 = campoTelefone1;
        this.campoDetalhes = campoDetalhes;
        this.campoDeBusca = campoDeBusca;
    }
    private final DefaultListModel<Contato> contatosFiltrados = new DefaultListModel<>();

    @Override
    public void keyReleased(KeyEvent e) {
        Contato contatoSelecionado = listaContatos.getSelectedValue();
        if (contatoSelecionado != null) {
            contatoSelecionado.setNome(campoNome.getText());
            contatoSelecionado.setendereco(campoEndereco.getText());
            contatoSelecionado.setendereco1(campoEndereco1.getText());
            contatoSelecionado.setTelefone(campoTelefone.getText());
            contatoSelecionado.setTelefone1(campoTelefone1.getText());
            contatoSelecionado.setDetalhes(campoDetalhes.getText());
            
        }
        listaContatos.repaint();        
    }    
}