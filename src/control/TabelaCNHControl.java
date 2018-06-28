package control;

import view.*;
import javax.swing.table.DefaultTableModel;
import persistencia.PessoaDAO;

public class TabelaCNHControl {

    private TabelaCNH tabelaCNH;

    public static TabelaCNHControl tabelaCNHControl;

    public TabelaCNHControl() {
        tabelaCNH = new TabelaCNH();

        actions();
    }

    public TabelaCNH getTabelaCNH() {
        return tabelaCNH;
    }
    
    public void actions() {
        reset();
        //pegar o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaCNH.tabela.getModel();

        // tamanho da lista 
        int tamanhoLista = PessoaDAO.pessoaDAO.lerBD().size();

        for (int i = 0; i < tamanhoLista; i++) {

            String[] dados = {
                PessoaDAO.pessoaDAO.lerBD().get(i).getNome(),
                PessoaDAO.pessoaDAO.lerBD().get(i).getSobrenome(),
                PessoaDAO.pessoaDAO.lerBD().get(i).getCpf(),
                PessoaDAO.pessoaDAO.lerBD().get(i).getRg()
            };

            modeloTabela.addRow(dados);
        }

    }

    public void reset() {

        // reseta o conteudo todo
        tabelaCNH.tabela.setModel(new DefaultTableModel(null, new String[]{
            "Nome", "Sobrenome", "CPF", "RG"
        }));

    }
}
