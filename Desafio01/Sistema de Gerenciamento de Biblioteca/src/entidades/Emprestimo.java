package entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import entidades.enums.SituacaoEmprestimo;

public class Emprestimo {

	private SituacaoEmprestimo id;
	private Livro livro;
	private Usuario usuario;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private String estado;
	private Double multa;

	public Emprestimo(SituacaoEmprestimo id, Livro livro, Usuario usuario, LocalDate dataEmprestimo,
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

	public SituacaoEmprestimo getId() {
		return id;
	}

	public void setId(SituacaoEmprestimo id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public BigDecimal getMulta() {
		return multa != null ? BigDecimal.valueOf(multa) : null;
	}

	public void setMulta(Double multa) {
		this.multa = multa != null ? multa.doubleValue() : null;
	}

}
