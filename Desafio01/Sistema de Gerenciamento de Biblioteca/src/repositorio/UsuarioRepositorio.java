package repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import conexao.conexaoBancoDeDados;
import entidades.Usuario;

public class UsuarioRepositorio {

	private conexaoBancoDeDados con;
	private EmprestimoRepositorio emprestimoRepositorio = new EmprestimoRepositorio();

	public boolean salvarUsuario(Usuario usuario) {
		boolean retorno = false;

		String sql = "INSERT INTO usuario (id, nome, endereco, email, telefone, dataAssociacao) VALUES (?,?,?,?,?,?)";

		try {
			Connection connection = con.getConnection();
			Usuario usuarioDB = buscar(usuario);
			PreparedStatement statement = connection.prepareStatement(sql);

			Date dtAssociacao = Date.valueOf(usuario.getDataAssociacao().toString());

			statement.setFloat(1, usuario.getId());
			statement.setString(2, usuario.getNome());
			statement.setString(3, usuario.getEndereco());
			statement.setString(4, usuario.getEmail());
			statement.setString(5, usuario.getTelefone());
			statement.setDate(6, dtAssociacao);

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

	private Usuario buscar(Usuario usuario) {
		return null;
	}

	public Usuario buscarUsuario(Usuario usuario) {
		Usuario usuarioDB = null;
		String sql = "SELECT id, nome, endereco, email, telefone, dataAssociacao FROM usuario WHERE nome = ?";
		try {
			Connection connection = con.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, usuario.getNome());

			ResultSet rs = st.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					usuarioDB = new Usuario();
					usuarioDB.setId(rs.getLong("id"));
					usuarioDB.setNome(rs.getString("nome"));
					usuarioDB.setEndereco(rs.getString("endereco"));
					usuarioDB.setTelefone(rs.getString("telefone"));
					usuarioDB.setDataAssociacao(LocalDate.now());
					usuarioDB.setEmprestimo(emprestimoRepositorio.buscarPorUsuario(usuarioDB.getId()));
				}
			}

		} catch (SQLException e) {
			System.err.println("Erro ao buscar usuário: " + e.getMessage());
		}

		return usuarioDB;
	}
}
