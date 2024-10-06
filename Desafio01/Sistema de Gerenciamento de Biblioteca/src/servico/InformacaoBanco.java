//package servico;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Connection;
//import java.sql.ResultSet;
//
//import conexao.conexaoBancoDeDados;
//import entidades.Autor;
//import entidades.Emprestimo;
//import entidades.Livro;
//import entidades.Usuario;
//
//public class InformacaoBanco {
//
//	private conexaoBancoDeDados con;
//	
//	public void consultarUsuarioPorEmail(String email) {
//		String sql = "SELECT * FROM usuario WHERE email = ?";
//
//		try {
//			Connection connection = con.getConnection();
//			Usuario usuarioDB = buscar(usuario);
//			PreparedStatement statement = connection.prepareStatement(sql);
//
//			statement.setString(4, email);
//			ResultSet resultSet = statement.executeQuery();
//
//			if (resultSet.next()) {
//				System.out.println("ID: " + resultSet.getString("id"));
//				System.out.println("Nome: " + resultSet.getString("nome"));
//				System.out.println("Email: " + resultSet.getString("email"));
//				System.out.println("Email: " + resultSet.getString("email"));
//				System.out.println("Email: " + resultSet.getString("email"));
//
//			} else {
//				System.out.println("Usuário não encontrado.");
//			}
//
//		} catch (SQLException e) {
//			System.err.println("Erro ao consultar usuário: " + e.getMessage());
//		}
//
//	}
//
//	public void consultarLivroPorNome(String titulo) {
//		String sql = "SELECT * FROM livro WHERE titulo = ?";
//
//		try {
//			Connection connection = con.getConnection();
//			Livro livroDB = buscar(livro);
//			PreparedStatement statement = connection.prepareStatement(sql);
//
//			statement.setString(1, titulo);
//			ResultSet resultSet = statement.executeQuery();
//
//			if (resultSet.next()) {
//				System.out.println("ID: " + resultSet.getString("id"));
//				System.out.println("Nome: " + resultSet.getString("nome"));
//				System.out.println("Email: " + resultSet.getString("email"));
//
//			} else {
//				System.out.println("Livro não encontrado.");
//			}
//
//		} catch (SQLException e) {
//			System.err.println("Erro ao consultar livro: " + e.getMessage());
//		}
//
//	}
//
//	public void consultarAutorPorNome(String nome) {
//		String sql = "SELECT * FROM autor WHERE nome = ?";
//
//		try {
//			Connection connection = con.getConnection();
//			Autor autorDB = buscar(autor);
//			PreparedStatement statement = connection.prepareStatement(sql);
//
//			Statement.setString(1, nome);
//			ResultSet resulSet = statement.executeQuery();
//
//			if (resultSet.next()) {
//				System.out.println("ID: " + resultSet.getString("id"));
//				System.out.println("Nome: " + resultSet.getString("nome"));
//				System.out.println("Email: " + resultSet.getString("email"));
//
//			} else {
//				System.out.println("Autor não encontrado.");
//			}
//
//		} catch (SQLException e) {
//			System.err.println("Erro ao consultar autor: " + e.getMessage());
//		}
//	}
//
//	public void consultarEmprestimoPorId(String nome) {
//		String sql = "SELECT * FROM emprestimo WHERE id = ?";
//
//		try {
//			Connection connection = con.getConnection();
//			Emprestimo emprestimoDB = buscar(emprestimo);
//			PreparedStatement statement = connection.prepareStatement(sql);
//
//			if (resultSet.next()) {
//				System.out.println("ID: " + resultSet.getString("id"));
//				System.out.println("Nome: " + resultSet.getString("nome"));
//				System.out.println("Email: " + resultSet.getString("email"));
//
//			} else {
//				System.out.println("Emprestimo não encontrado.");
//			}
//
//		} catch (SQLException e) {
//			System.err.println("Erro ao consultar emprestimo: " + e.getMessage());
//		}
//	}
//}