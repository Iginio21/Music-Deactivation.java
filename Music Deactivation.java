import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MusicaDAO {

    public void removerMusica(int id) {
        String url = "jdbc:mysql://localhost:3306/seubanco";
        String usuario = "seuusuario";
        String senha = "suasenha";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "UPDATE musicas SET ativo = 0 WHERE id = ?";
            try (PreparedStatement declaracao = conexao.prepareStatement(sql)) {
                declaracao.setInt(1, id);
                declaracao.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Outros métodos relacionados ao acesso ao banco de dados, se necessário...
}
