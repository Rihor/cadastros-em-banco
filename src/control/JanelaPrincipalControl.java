package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.*;

public class JanelaPrincipalControl {

    public JanelaPrincipal janelaPrincipal;
    public CNHControl cnhControl;
    public FormularioVeiculoControl formularioVeiculoControl;
    public JanelaThreadControl janelaThreadControl;

    public JanelaPrincipalControl() {
        janelaPrincipal = new JanelaPrincipal();
        cnhControl = new CNHControl();
        formularioVeiculoControl = new FormularioVeiculoControl();
        TabelaCNHControl.tabelaCNHControl = new TabelaCNHControl();
        TabelaVeiculoControl.tabelaVeiculoControl = new TabelaVeiculoControl();
        janelaThreadControl = new JanelaThreadControl();
        actions();
    }

    public void actions() {
        janelaPrincipal.itemCnh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaPrincipal.add(cnhControl.getCnh());
                reset();
                cnhControl.getCnh().setVisible(true);
            }
        });

        janelaPrincipal.itemVeiculos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaPrincipal.add(formularioVeiculoControl.getFormularioVeiculo());
                reset();
                formularioVeiculoControl.getFormularioVeiculo().setVisible(true);
            }
        });

        janelaPrincipal.itemTabelaCNH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                janelaPrincipal.add(TabelaCNHControl.tabelaCNHControl.getTabelaCNH());
                TabelaCNHControl.tabelaCNHControl.getTabelaCNH().setVisible(true);
                TabelaCNHControl.tabelaCNHControl.reset();
                TabelaCNHControl.tabelaCNHControl.actions();
            }
        });

        janelaPrincipal.itemTabelaVeiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                janelaPrincipal.add(TabelaVeiculoControl.tabelaVeiculoControl.getTabelaVeiculo());
                TabelaVeiculoControl.tabelaVeiculoControl.getTabelaVeiculo().setVisible(true);
                TabelaVeiculoControl.tabelaVeiculoControl.reset();
                TabelaVeiculoControl.tabelaVeiculoControl.actions();
            }
        });
        
        janelaPrincipal.itemThread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                janelaPrincipal.add(janelaThreadControl.getJanelaThread());
                janelaThreadControl.getJanelaThread().setVisible(true);
            }
        });
        
    }

    public void reset() {
        cnhControl.getCnh().setVisible(false);
        formularioVeiculoControl.getFormularioVeiculo().setVisible(false);
        TabelaCNHControl.tabelaCNHControl.getTabelaCNH().setVisible(false);
        TabelaVeiculoControl.tabelaVeiculoControl.getTabelaVeiculo().setVisible(false);
        janelaThreadControl.getJanelaThread().setVisible(false);
    }
}
