package br.uff.ic.agenda.controller;

import br.uff.ic.agenda.model.Contato;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ControleCarregar implements ListSelectionListener {

    private final JList<Contato> listaContatos;
    private final JTextField campoNome;
    private final JTextField campoTelefone;
    private final JTextField campoTelefone1;
    private final JTextField campoEndereco;
    private final JTextField campoEndereco1;
    private final JTextArea campoDetalhes;
    
    public ControleCarregar (JList<Contato> listaContatos, JTextField campoNome, JTextField campoEndereco, JTextField campoEndereco1,JTextField campoTelefone, JTextField campoTelefone1,JTextArea campoDetalhes) {
        this.listaContatos = listaContatos;
        this.campoNome = campoNome;
        this.campoEndereco = campoEndereco;
        this.campoEndereco1 = campoEndereco1;
        this.campoTelefone = campoTelefone;
        this.campoTelefone1 = campoTelefone1;
        this.campoDetalhes = campoDetalhes;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Contato contatoSelecionado = listaContatos.getSelectedValue();
        
        if (contatoSelecionado != null) {
            campoNome.setText(contatoSelecionado.getNome());
            campoEndereco.setText(contatoSelecionado.getendereco());
            campoEndereco1.setText(contatoSelecionado.getendereco1());
            campoTelefone.setText(contatoSelecionado.getTelefone());
            campoTelefone1.setText(contatoSelecionado.getTelefone1());
            campoDetalhes.setText(contatoSelecionado.getDetalhes());
        } else {
            campoNome.setText("");
            campoEndereco.setText("");
            campoEndereco1.setText("");
            campoTelefone.setText("");
            campoTelefone1.setText("");
            campoDetalhes.setText("");
        }

        campoNome.setEnabled(contatoSelecionado != null);
        campoEndereco.setEnabled(contatoSelecionado != null);
        campoEndereco1.setEnabled(contatoSelecionado != null);
        campoTelefone.setEnabled(contatoSelecionado != null);
        campoTelefone1.setEnabled(contatoSelecionado != null);
        campoDetalhes.setEnabled(contatoSelecionado != null);

        listaContatos.repaint();        
    }
}