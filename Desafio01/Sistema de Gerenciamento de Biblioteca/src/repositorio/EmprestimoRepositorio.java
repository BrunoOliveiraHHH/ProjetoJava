package repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import conexao.conexaoBancoDeDados;
import entidades.Emprestimo;
import entidades.Livro;

public class EmprestimoRepositorio {

	private conexaoBancoDeDados con;

	public boolean Emprestimos(Emprestimo emprestimo) {
		boolean retorno = false;

		String sql = "INSERT INTO emprestimo (id, livro, usuario, dataEmprestimo, dataDevolucao, estado, multa) VALUES (?,?,?,?,?,?,?)";

		try {
			Connection connection = con.getConnection();
			Emprestimo emprestimoDB = buscar(emprestimo);
			PreparedStatement statement = connection.prepareStatement(sql);

			Date dtEmprestimo = Date.valueOf(emprestimo.getDataEmprestimo().toString());
			Date dtDevolucao = Date.valueOf(emprestimo.getDataDevolucao().toString());
			Float multa = emprestimo.getMulta().floatValue();

			statement.setLong(1, emprestimo.getId());
			statement.setLong(2, emprestimo.getLivro().getId());
			statement.setLong(3, emprestimo.getUsuario().getId());
			statement.setDate(4, dtEmprestimo);
			statement.setDate(5, dtDevolucao);
			statement.setString(6, emprestimo.getEstado());
			statement.setFloat(7, multa);

			if (emprestimoDB == null) {
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

	public Emprestimo buscarEmprestimo(Emprestimo emprestimo) {
		Emprestimo emprestimoDB = null;
		String sql = "SELECT id, livro, usuario, dataEmprestimo, dataDevolucao, estado, multa FROM livro WHERE nome = ?";
		try {
			Connection connection = con.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, emprestimo.getTitulo());

			ResultSet rs = st.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					emprestimoDB = new Emprestimo();
					emprestimoDB.setId(rs.getLong("id"));
					emprestimoDB.setLivro(rs.getString("livro"));
					emprestimoDB.setUsuario(rs.getString("usuario"));
					emprestimoDB.setAutor(rs.getString("autor"));
					emprestimoDB.setDataEmprestimo(LocalDate.now());
					emprestimoDB.setDataDevolucao(LocalDate.now());
					emprestimoDB.setEstado(rs.getString("estado"));
					emprestimoDB.setMulta((double) rs.getInt("multa"));
				}
			}

		} catch (SQLException e) {
			System.err.println("Erro ao buscar emprestimo: " + e.getMessage());
		}
		return emprestimoDB;
	}

	public Emprestimo buscar(Emprestimo emprestimo) {

		return new Emprestimo();
	}

	public List<Emprestimo> buscarPorUsuario(Long id) {
		return null;
	}

}
