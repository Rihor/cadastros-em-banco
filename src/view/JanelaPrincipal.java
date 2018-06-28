package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JanelaPrincipal extends JFrame {

    public JMenuBar barraMenu;
    public JMenu menuCadastrar, menuTabela, menuThread;
    public JMenuItem itemCnh, itemVeiculos, itemTabelaCNH, itemTabelaVeiculo, itemThread;

    public JanelaPrincipal() {
        iniciar();
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setTitle("Tela Principal");
    }

    public void iniciar() {
        itemCnh = new JMenuItem("CNH");
        itemVeiculos = new JMenuItem("Veiculos");
        barraMenu = new JMenuBar();
        menuCadastrar = new JMenu("Cadastrar");
        menuTabela = new JMenu("Tabelas");
        menuThread = new JMenu("Threads");
        itemTabelaCNH = new JMenuItem("Tabela do CNH");
        itemTabelaVeiculo = new JMenuItem("Tabela de Veiculos");
        itemThread = new JMenuItem("Threads");
        
        
        menuCadastrar.add(itemCnh);
        menuCadastrar.add(itemVeiculos);
        menuTabela.add(itemTabelaCNH);
        menuTabela.add(itemTabelaVeiculo);
        menuThread.add(itemThread);
        
        barraMenu.add(menuCadastrar);
        barraMenu.add(menuTabela);
        barraMenu.add(menuThread);
        
        this.setJMenuBar(barraMenu);

    }
}
