package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Veiculo;

public class VeiculoDAO {

    Conexao conexao;
    PreparedStatement ps = null;
    List<Veiculo> listaVeiculo;

    public static VeiculoDAO veiculoDAO;

    public VeiculoDAO() {
        conexao = new Conexao();
    }

    public void salvarBD(Veiculo veiculo) {
        try {
            ps = conexao.conectar().prepareStatement(
                    "insert into veiculos (nome, modelo, placa, cor) values (?,?,?,?)");

            ps.setString(1, veiculo.getNome());
            ps.setString(2, veiculo.getModelo());
            ps.setString(3, veiculo.getPlaca());
            ps.setString(4, veiculo.getCor());
            ps.execute();
            JOptionPane.showMessageDialog(null, veiculo.getNome() + " foi salvo(a) com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Veiculo> lerBD() {
        listaVeiculo = new ArrayList<>();
        ResultSet rs = null;

        try {
            ps = conexao.conectar().prepareStatement("select * from veiculos");
            rs = ps.executeQuery();

            while (rs.next()) {
                Veiculo novoVeiculo = new Veiculo();

                novoVeiculo.setNome(rs.getString("nome"));
                novoVeiculo.setModelo(rs.getString("modelo"));
                novoVeiculo.setPlaca(rs.getString("placa"));
                novoVeiculo.setCor(rs.getString("cor"));

                listaVeiculo.add(novoVeiculo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaVeiculo;

    }

}
