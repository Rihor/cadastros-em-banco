package control;

import javax.swing.table.DefaultTableModel;
import persistencia.VeiculoDAO;
import view.TabelaVeiculo;

public class TabelaVeiculoControl {

    private TabelaVeiculo tabelaVeiculo;
    public static TabelaVeiculoControl tabelaVeiculoControl;

    public TabelaVeiculoControl() {
        tabelaVeiculo = new TabelaVeiculo();

        actions();
    }

    public void actions() {
        reset();
        //pegar o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaVeiculo.tabela.getModel();

        // tamanho da lista 
        int tamanhoLista = VeiculoDAO.veiculoDAO.lerBD().size();

        for (int i = 0; i < tamanhoLista; i++) {

            String[] dados = {
                VeiculoDAO.veiculoDAO.lerBD().get(i).getNome(),
                VeiculoDAO.veiculoDAO.lerBD().get(i).getModelo(),
                VeiculoDAO.veiculoDAO.lerBD().get(i).getPlaca(),
                VeiculoDAO.veiculoDAO.lerBD().get(i).getCor()
            };

            modeloTabela.addRow(dados);
        }

    }

    public void reset() {

        // reseta o conteudo todo
        tabelaVeiculo.tabela.setModel(new DefaultTableModel(null, new String[]{
            "Nome", "Modelo", "Placa", "Cor"
        }));

    }

    public TabelaVeiculo getTabelaVeiculo() {
        return tabelaVeiculo;
    }

    public void setTabelaVeiculo(TabelaVeiculo tabelaVeiculo) {
        this.tabelaVeiculo = tabelaVeiculo;
    }
}
