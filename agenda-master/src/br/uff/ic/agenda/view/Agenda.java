package br.uff.ic.agenda.view;

import br.uff.ic.agenda.controller.ControleAdicionar;
import br.uff.ic.agenda.controller.ControlePersistencia;
import br.uff.ic.agenda.controller.ControleCarregar;
import br.uff.ic.agenda.controller.ControleRemover;
import br.uff.ic.agenda.controller.ControleSalvar;
import br.uff.ic.agenda.controller.ControleQntContatos;
import br.uff.ic.agenda.model.Contato;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class Agenda extends JFrame {
    
    private static final String ICONE_ADICIONA = "/toolbarButtonGraphics/general/Add16.gif";
    private static final String ICONE_REMOVE = "/toolbarButtonGraphics/general/Delete16.gif";
   
    
    private final DefaultListModel<Contato> contatos = new DefaultListModel<>();
    private final DefaultListModel<Contato> contatosFiltrados = new DefaultListModel<>();
    private final JList<Contato> listaContatos = new JList<>(contatos);
    private final JTextField campoNome = new JTextField();
    private final JTextField campoTelefone = new JTextField();
    private final JTextField campoTelefone1 = new JTextField();
    private final JTextArea campoDetalhes = new JTextArea();
    private final JTextField campoEndereco = new JTextField();
    private final JTextField campoEndereco1 = new JTextField();
    private final JTextField campoPesquisar = new JTextField();
    private final JLabel quantidadeContatos = new JLabel();
    private final JTextField campoDeBusca = new JTextField();
    
    public Agenda() {
        super("Agenda");        
        montaJanela();
    
    
    }
    
    
    private void montaJanela() {        
        // Criando um painel com a lista de contatos
        JPanel painelLista = new JPanel(new BorderLayout());
        painelLista.setBorder(BorderFactory.createTitledBorder("Contatos"));
        listaContatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contatos.addListDataListener(new ControleQntContatos(quantidadeContatos));
        painelLista.add(quantidadeContatos, BorderLayout.NORTH);
        painelLista.add(campoDeBusca, BorderLayout.NORTH);
        
        painelLista.add(new JScrollPane(listaContatos), BorderLayout.CENTER);
       
        
        // Criando um painel com os botões sob a lista
        JButton botaoAdicionar = new JButton(new ImageIcon(getClass().getResource(ICONE_ADICIONA)));
        JButton botaoRemover = new JButton(new ImageIcon(getClass().getResource(ICONE_REMOVE)));
        JButton botaoExibir = new JButton("Lista");
        
        JPanel painelBotoes = new JPanel(new GridLayout(1, 3));
        painelBotoes.add(botaoAdicionar);
        painelBotoes.add(botaoRemover);
        painelBotoes.add(botaoExibir);
        
        painelLista.add(painelBotoes, BorderLayout.SOUTH);
        
       
       
      
        //Criando barra de pesquisa
        
        
        
                        
        // Criando um painel com o nome
        JPanel painelNome = new JPanel(new BorderLayout());
        painelNome.add(new JLabel("Nome:"), BorderLayout.WEST); 
        campoNome.setEnabled(false);
        painelNome.add(campoNome, BorderLayout.CENTER);
        
        //Criando um painel com endereço residencial 
        JPanel painelEndereco = new JPanel(new BorderLayout());
        painelEndereco.add(new JLabel("Endereço residencial:"), BorderLayout.WEST); 
        campoEndereco.setEnabled(false);
        painelEndereco.add(campoEndereco, BorderLayout.CENTER);
        
        //Criando um painel com endereço comercial
        JPanel painelEndereco1 = new JPanel(new BorderLayout());
        painelEndereco1.add(new JLabel("Endereço comercial:"), BorderLayout.WEST); 
        campoEndereco1.setEnabled(false);
        painelEndereco1.add(campoEndereco1, BorderLayout.CENTER);
        
        // Criando um painel com o telefone
        JPanel painelTelefone = new JPanel(new BorderLayout());
        painelTelefone.add(new JLabel("Telefone:"), BorderLayout.WEST);
        campoTelefone.setEnabled(false);
        painelTelefone.add(campoTelefone, BorderLayout.CENTER);
        
        //Criando um painel com o segundo telefone
        JPanel painelTelefone1 = new JPanel(new BorderLayout());
        painelTelefone1.add(new JLabel("Telefone 2:"), BorderLayout.WEST);
        campoTelefone1.setEnabled(false);
        painelTelefone1.add(campoTelefone1, BorderLayout.CENTER);
        
        // Criando um painel que contem tanto o nome quanto o telefone
        JPanel painelCampos = new JPanel(new GridLayout(3, 3));
        painelCampos.add(painelNome);
        painelCampos.add(painelTelefone);
        painelCampos.add(painelTelefone1);
        painelCampos.add(painelEndereco);
        painelCampos.add(painelEndereco1);
        
        // Criando um painel com os detalhes
        JPanel painelDetalhes = new JPanel(new BorderLayout());
        painelDetalhes.setBorder(BorderFactory.createTitledBorder("Detalhes"));
        campoDetalhes.setEnabled(false);
        painelDetalhes.add(new JScrollPane(campoDetalhes), BorderLayout.CENTER);

        // Criando um painel central que combina os campos de texto, a área de texto e os botões
        JPanel painelCentral = new JPanel(new BorderLayout());
        painelCentral.add(painelCampos, BorderLayout.NORTH);
        painelCentral.add(painelDetalhes, BorderLayout.CENTER);
        
        // Criando um painel do tipo split, que combina a lista com os demais componentes
        JSplitPane painelPrincipal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, painelLista, painelCentral);
        painelPrincipal.setDividerLocation(200);
        this.setContentPane(painelPrincipal);

        // Configurando os listeners
        listaContatos.addListSelectionListener(new ControleCarregar(listaContatos, campoNome, campoEndereco, campoEndereco1,campoTelefone, campoTelefone1,campoDetalhes));
        botaoAdicionar.addActionListener(new ControleAdicionar(contatos)); 
        botaoRemover.addActionListener(new ControleRemover(listaContatos, contatos));
        ControleSalvar salvar = new ControleSalvar(listaContatos, campoDeBusca,campoNome, campoEndereco, campoEndereco1,campoTelefone, campoTelefone1,campoDetalhes);
        campoNome.addKeyListener(salvar);
        campoEndereco.addKeyListener(salvar);
        campoEndereco1.addKeyListener(salvar);
        campoTelefone.addKeyListener(salvar);
        campoTelefone1.addKeyListener(salvar);
        campoDetalhes.addKeyListener(salvar);
        campoDeBusca.addKeyListener(salvar);
        this.addWindowListener(new ControlePersistencia(contatos));

        // Configuration a janela
        this.pack();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
            
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.setVisible(true);
      
        
    }
}