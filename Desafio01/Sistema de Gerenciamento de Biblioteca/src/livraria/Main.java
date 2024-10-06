
package livraria;

import java.time.LocalDate;
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
	static UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();

	public static void main(String[] args) {

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
					System.out.println("1-Cadastrar Usuario");
					System.out.println("2-Buscar Usuario");
					System.out.println("3-Alterar Usuario");
					System.out.println("4-Excluir Usuario");
					int escolhaUsuario = sc.nextInt();
					menuUsuario(escolhaUsuario);
					break;
				case 2:
					System.out.println("Menu Livro");
					System.out.println("------------------");
					System.out.println("Digite o nome do livro para consultar as informações do livro: ");
					break;
				case 3:
					System.out.println("Menu Autor");
					System.out.println("------------------");
					System.out.println("Digite o nome do Autor para consultar as informações: ");

					break;
				case 4:
					System.out.println("Menu Emprestimo");
					System.out.println("------------------");
					System.out.println("Digite seu ID de usuário para consultar os emprestimos: ");
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

	private static void menuUsuario(int escolhaUsuario) {
		Scanner sc = new Scanner(System.in);
		Usuario usuario;
		switch (escolhaUsuario) {
		case 1:
			System.out.println("Cadastro de Usuario");
			System.out.println("Nome:");
			String nome = sc.nextLine();
			System.out.println("Endereco:");
			String endereco = sc.nextLine();
			System.out.println("Email:");
			String email = sc.nextLine();
			System.out.println("Telefone:");
			String telefone = sc.nextLine();
			usuario = new Usuario(null, endereco, email, telefone, null, nome, LocalDate.now());
			boolean retorno = usuarioRepositorio.salvarUsuario(usuario);
			if (retorno) {
				System.out.println("Usuario Salvo com Sucesso!");
			} else {
				System.out.println("Erro ao salvar usuario, verfique o log do console!");
			}
			break;
		case 2:
			System.out.println("Buscar Usuario");
			System.out.println("Digite o nome do usuario:");
			nome = sc.nextLine();
			usuario = new Usuario();
			usuario.setNome(nome);
			Usuario usuarioDB = usuarioRepositorio.buscarUsuario(usuario);
			System.out.println("Nome: " + usuarioDB.getNome());
			System.out.println("Endereco: " + usuarioDB.getEndereco());
			System.out.println("Email: " + usuario.getEmail());
			System.out.println("Telefone: " + usuario.getTelefone());
			System.out.println("Data de Associacao: " + usuario.getDataAssociacao());
			System.out.println("Emprestimo: " + usuario.getEmprestimo());
			break;
		}
		sc.close();
	}
}
