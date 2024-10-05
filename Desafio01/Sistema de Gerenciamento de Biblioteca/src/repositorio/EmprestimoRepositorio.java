package repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidades.Emprestimo;
import entidades.Livro;

public class EmprestimoRepositorio {

	public boolean Emprestimos(Emprestimo emprestimo) {
		boolean retorno = false;

		String sql = "INSERT INTO emprestimo (id, livro, usuario, dataEmprestimo, dataDevolucao, estado, multa) VALUES (?,?,?,?,?,?,?)";

		try {
			Connection connection = con.getConnection();
			Emprestimo emprestimoDB = buscar(emprestimo);
			PreparedStatement statement = connection.prepareStatement(sql);

			Date dtEmprestimo = Date.valueOf(emprestimo.getDataEmprestimo().toString());
			Date dtDevolucao = Date.valueOf(emprestimo.getDataDevolucao().toString());

			statement.setString(1, emprestimo.getId());
			statement.setString(2, emprestimo.getLivro());
			statement.setString(3, emprestimo.getUsuario());
			statement.setDate(4, dtEmprestimo);
			statement.setDate(5, dtDevolucao);
			statement.setString(5, emprestimo.getEstado());
			statement.setDouble(6, emprestimo.getMulta());

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

	public Livro buscar(Livro livro) {

		return new Livro();
	}

}
