
package livraria;

import java.util.Scanner;

import entidades.Autor;
import entidades.Emprestimo;
import entidades.Livro;
import entidades.Usuario;
import repositorio.AutorRepositorio;
import repositorio.EmprestimoRepositorio;
import repositorio.LivroRepositorio;
import repositorio.UsuarioRepositorio;

public class Main {
	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();
		Emprestimo emprestimo = new Emprestimo();
		EmprestimoRepositorio emprestimoRepositorio = new EmprestimoRepositorio();
		Livro livro = new Livro();
		LivroRepositorio livroRepositorio = new LivroRepositorio();
		Autor autor = new Autor();
		AutorRepositorio autorRepositorio = new AutorRepositorio();

		Scanner sc = new Scanner(System.in);

		System.out.println("Menu Livraria Aurora");
		System.out.println("1-Usuario");
		System.out.println("2-Livro");
		System.out.println("3-Autor");
		System.out.println("4-Emprestimo");
		// to Do: aplicar listagem numerada de menus;

		System.out.println("Escolha sua opção(número): ");
		String escolha = sc.nextLine();

		boolean formatoValido = false;
		while (!formatoValido) {
			try {
				formatoValido = true;
				switch (Integer.parseInt(escolha)) {
				case 1:
					System.out.println("Menu Usuario");
					System.out.println("------------------");
					System.out.println("Digite seu email para consultar suas informações: ");
					usuarioRepositorio.salvarUsuario(null);
					usuarioRepositorio.buscarUsuario(null);
					String email = sc.nextLine();
					break;
				case 2:
					System.out.println("Menu Livro");
					System.out.println("------------------");
					System.out.println("Digite o nome do livro para consultar as informações do livro: ");
					livroRepositorio.salvarLivro(null);
					livroRepositorio.buscarLivro(null);
					String nomeLivro = sc.nextLine();
					break;
				case 3:
					System.out.println("Menu Autor");
					System.out.println("------------------");
					System.out.println("Digite o nome do Autor para consultar as informações: ");
					autorRepositorio.salvarAutor(null);
					autorRepositorio.buscarAutor(null);
					String nomeAutor = sc.nextLine();

					break;
				case 4:
					System.out.println("Menu Emprestimo");
					System.out.println("------------------");
					System.out.println("Digite seu ID de usuário para consultar os emprestimos: ");
					emprestimoRepositorio.Emprestimos(null);
					emprestimoRepositorio.buscarEmprestimo(null);
					String usuarioId = sc.nextLine();
					break;
				}
			} catch (NumberFormatException e) {
				formatoValido = false;
				System.out.println("Formato digitado incorreto, favor digitar o numero da opção");
				escolha = sc.nextLine();
			}
			sc.close();
		}
	}
}
