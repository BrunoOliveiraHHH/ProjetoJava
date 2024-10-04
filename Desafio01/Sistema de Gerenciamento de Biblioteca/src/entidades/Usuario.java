package entidades;

import java.util.Date;
import java.util.List;

public class Usuario {
	private Long id;
	private String endereco;
	private String email;
	private String telefone;
	private List<Emprestimo> emprestimo;// INNER JOIN
	private String nome;
	private Date dataAssociacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Emprestimo> getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(List<Emprestimo> emprestimo) {
		this.emprestimo = emprestimo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataAssociacao() {
		return dataAssociacao;
	}

	public void setDataAssociacao(Date dataAssociacao) {
		this.dataAssociacao = dataAssociacao;
	}

	public Usuario(Long id, String endereco, String email, String telefone, List<Emprestimo> emprestimo, String nome,
			Date dataAssociacao) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.emprestimo = emprestimo;
		this.nome = nome;
		this.dataAssociacao = dataAssociacao;
	}

	public Usuario() {
	}
}
