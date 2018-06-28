package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Pessoa;
import view.CNH;
import persistencia.PessoaDAO;

public class CNHControl {

    private CNH cnh;

    public CNHControl() {
        cnh = new CNH();
        PessoaDAO.pessoaDAO = new PessoaDAO();
        actions();
    }

    public void actions() {
        cnh.btnSalvar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(cnh.txtNome.getText());
                pessoa.setSobrenome(cnh.txtSobrenome.getText());
                pessoa.setCpf(cnh.txtCPF.getText());
                pessoa.setRg(cnh.txtRG.getText());
                PessoaDAO.pessoaDAO.salvarBD(pessoa);

                //limpar texto depois de inserir
                limpar();
            }

        });

    }

    private void limpar() {
        cnh.txtNome.setText("");
        cnh.txtSobrenome.setText("");
        cnh.txtCPF.setText("");
        cnh.txtRG.setText("");
    }

    public CNH getCnh() {
        return cnh;
    }

    public void setCnh(CNH cnh) {
        this.cnh = cnh;
    }
}
