package persistencia;

import java.sql.*;
import javax.swing.JOptionPane;

class Conexao {

    private String url = "jdbc:derby://localhost:1527/trabalho";
    private String usuario = "root";
    private String senha = "root";
    private Connection conexao;

    public Conexao() {
        conectar();
    }

    public Connection conectar() {
        try {            
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado!");

            return conexao;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Conexão não foi possivel!");
        }
        return null;
    }

}
