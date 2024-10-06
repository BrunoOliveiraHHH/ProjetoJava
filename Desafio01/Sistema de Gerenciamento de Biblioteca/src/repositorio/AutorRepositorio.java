package repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import conexao.conexaoBancoDeDados;
import entidades.Autor;

public class AutorRepositorio {

	private conexaoBancoDeDados con;
	
	public Long gerarIdAleatorio() {
		return (long) (Math.random() * 1_000_000L);
	}

	public boolean salvarAutor(Autor autor) {
		boolean retorno = false;

		String sql = "INSERT INTO autor (id, nome, biografia, nacionalidade, dataNascimento) VALUES (?,?,?,?,?)";

		try {
			Connection connection = con.getConnection();
			Autor autorDB = buscar(autor);
			PreparedStatement statement = connection.prepareStatement(sql);

			Date dtNascimento = Date.valueOf(autor.getDataNascimento().toString());

			statement.setFloat(1, autor.getId());
			statement.setString(2, autor.getNome());
			statement.setString(3, autor.getBiografia());
			statement.setString(4, autor.getNacionalidade());
			statement.setDate(5, dtNascimento);

			if (autorDB == null) {
				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					retorno = true;
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao inserir autor: " + e.getMessage());
		}

		return retorno;
	}

	private Autor buscar(Autor autor) {
		return null;
	}

	public Autor buscarAutor(Autor autor) {
		Autor autorDB = null;
		String sql = "SELECT id, nome, biografia, nacionalidade, dataNascimento FROM autor WHERE nome = ?";
		try {
			Connection connection = con.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, autor.getNome());

			ResultSet rs = st.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					autorDB = new Autor();
					autorDB.setId(rs.getLong("id"));
					autorDB.setNome(rs.getString("nome"));
					autorDB.setBiografia(rs.getString("biografia"));
					autorDB.setNacionalidade(rs.getString("nacionalidade"));
					autorDB.setDataNascimento(LocalDate.now());
				}
			}

		} catch (SQLException e) {
			System.err.println("Erro ao buscar autor: " + e.getMessage());
		}

		return autorDB;
	}
}