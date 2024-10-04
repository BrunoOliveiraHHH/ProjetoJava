package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import conexao.conexaoBancoDeDados;

public class Livro {
    private String isbn, titulo, autor, genero;
    private Date dataPublicacao;
    private int quantidade;

    // Construtor principal
    public Livro(String isbn, String titulo, String autor, Date dataPublicacao, String genero, int quantidade) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.genero = genero;
        this.quantidade = quantidade;
    }
}



