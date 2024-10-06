package entidades;

import java.time.LocalDate;

public class Emprestimo {

	private Long id;
	private String livro;
	private String usuario;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private String estado;
	private Double multa;

	public Emprestimo(Long id, String livro, String usuario, LocalDate dataEmprestimo,
			LocalDate dataDevolucao, String estado, Double multa) {
		this.id = id;
		this.livro = livro;
		this.usuario = usuario;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.estado = estado;
		this.multa = multa;
	}

	public Emprestimo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(String string) {
		this.livro = string;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(String string) {
		this.usuario = string;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getMulta() {
		return multa;
	}

	public void setMulta(Double multa) {
		this.multa = multa;
	}

	public String getTitulo() {
		return null;
	}

	public void setLivro1(String string) {
		
	}

	public void setAutor(String string) {
		
	}

}
