package repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.conexaoBancoDeDados;
import entidades.Livro;

public class LivroRepositorio {

	private conexaoBancoDeDados con;

	public boolean salvarLivro(Livro livro) {
		boolean retorno = false;

		String sql = "INSERT INTO livro (isbn, titulo, autor, dataPublicacao, genero, quantidade) VALUES (?,?,?,?,?,?)";

		try {
			Connection connection = con.getConnection();
			Livro livroDB = buscar(livro);
			PreparedStatement statement = connection.prepareStatement(sql);

			Date dtPublicacao = Date.valueOf(livro.getDataPublicacao().toString());

			statement.setString(1, livro.getIsbn());
			statement.setString(2, livro.getTitulo());
			statement.setString(3, livro.getAutor());
			statement.setDate(4, dtPublicacao);
			statement.setString(5, livro.getGenero());
			statement.setInt(6, livro.getQuantidade());

			if (livroDB == null) {
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

	public Livro buscar(Livro livro) {

		return new Livro();
	}

}
