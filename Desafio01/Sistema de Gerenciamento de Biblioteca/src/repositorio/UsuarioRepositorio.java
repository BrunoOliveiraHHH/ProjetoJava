package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.conexaoBancoDeDados;
import entidades.Usuario;

public class UsuarioRepositorio {

	private conexaoBancoDeDados con;

	public boolean salvarUsuario(Usuario usuario) {
		boolean retorno = false;

		String sql = "INSERT INTO usuario (idUsuario, nome, endereco, email, telefone, dataAssociacao) VALUES (?,?,?,?,?,?)";

		try {
			Connection connection = con.getConnection();
			Usuario usuarioDB = buscar(usuario);
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setFloat(1, usuario.getId());
			statement.setString(2, usuario.getNome());
			statement.setString(3, usuario.getEndereco());
			// todo colocar o resto dos parametros.

			if (usuarioDB == null) {
				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					retorno = true;
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao inserir livro: " + e.getMessage());
		}

		return retorno;
	}

	public Usuario buscar(Usuario usuario) {
		
		return new Usuario();
	}
}