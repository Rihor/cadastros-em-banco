package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.FormularioVeiculo;
import persistencia.VeiculoDAO;
import model.Veiculo;

public class FormularioVeiculoControl {

    private FormularioVeiculo formularioVeiculo;
    private VeiculoDAO veiculoDAO;

    public VeiculoDAO getVeiculoDAO() {
        return veiculoDAO;
    }

    public void setVeiculoDAO(VeiculoDAO veiculoDAO) {
        this.veiculoDAO = veiculoDAO;
    }
    
    public FormularioVeiculoControl() {
        formularioVeiculo = new FormularioVeiculo();
        VeiculoDAO.veiculoDAO = new VeiculoDAO();
        actions();
    }

    public FormularioVeiculo getFormularioVeiculo() {
        return formularioVeiculo;
    }

    public void setFormularioVeiculo(FormularioVeiculo formularioVeiculo) {
        this.formularioVeiculo = formularioVeiculo;
    }

    public void actions() {

        formularioVeiculo.btnSalvar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Veiculo novoVeiculo = new Veiculo();
                novoVeiculo.setNome(formularioVeiculo.txtNome.getText());
                novoVeiculo.setModelo(formularioVeiculo.txtModelo.getText());
                novoVeiculo.setPlaca(formularioVeiculo.txtPlaca.getText());
                novoVeiculo.setCor(formularioVeiculo.txtCor.getText());
                VeiculoDAO.veiculoDAO.salvarBD(novoVeiculo);

                //limpar os textos depois de salvar
                limpar();
            }

        });

    }

    private void limpar() {
        formularioVeiculo.txtNome.setText("");
        formularioVeiculo.txtModelo.setText("");
        formularioVeiculo.txtPlaca.setText("");
        formularioVeiculo.txtCor.setText("");
    }
}
