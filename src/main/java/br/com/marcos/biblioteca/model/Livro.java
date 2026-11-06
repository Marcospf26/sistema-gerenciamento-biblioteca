package br.com.marcos.biblioteca.model;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private int quantidadeExemplares;

    public Livro(int id, String titulo, String autor, String isbn, int quantidadeExemplares){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.quantidadeExemplares = quantidadeExemplares;
        this.isbn = isbn;
    }

    public Livro(String titulo, String autor, String isbn, int quantidadeExemplares){
        this.titulo = titulo;
        this.autor = autor;
        this.quantidadeExemplares = quantidadeExemplares;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantidadeExemplares() {
        return quantidadeExemplares;
    }

    public void setQuantidadeExemplares(int quantidadeExemplares) {
        this.quantidadeExemplares = quantidadeExemplares;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Id %d Titulo %s Autor %s ISBN %s Quantidade %d", this.id, this.titulo, this.autor, this.isbn, this.quantidadeExemplares);
    }

}
