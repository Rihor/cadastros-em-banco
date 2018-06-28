package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Pessoa;

public class PessoaDAO {

    Conexao conexao;
    PreparedStatement ps = null;
    List<Pessoa> listaPessoa;
    
    public static PessoaDAO pessoaDAO;

    public PessoaDAO() {
        conexao = new Conexao();
    }

    public void salvarBD(Pessoa pessoa) {
        
        try {
            ps = conexao.conectar().prepareStatement(
                    "insert into PESSOAS (NOME, SOBRENOME, CPF, RG) VALUES (?,?,?,?)");
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getSobrenome());
            ps.setString(3, pessoa.getCpf());
            ps.setString(4, pessoa.getRg());
            ps.execute();
            JOptionPane.showMessageDialog(null, pessoa.getNome() + " foi salvo(a) com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Pessoa> lerBD() {
        ResultSet rs = null;
        listaPessoa = new ArrayList<>();
        try {
            ps = conexao.conectar().prepareStatement("SELECT * FROM pessoas");
            rs = ps.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();

                pessoa.setNome(rs.getString("nome"));
                pessoa.setSobrenome(rs.getString("sobrenome"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setRg(rs.getString("rg"));

                listaPessoa.add(pessoa);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaPessoa;
    }
}
