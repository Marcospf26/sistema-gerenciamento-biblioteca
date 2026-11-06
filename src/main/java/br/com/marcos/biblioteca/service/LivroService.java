package br.com.marcos.biblioteca.service;

import br.com.marcos.biblioteca.dao.LivroDAO;
import br.com.marcos.biblioteca.model.Livro;
import br.com.marcos.biblioteca.enums.ResultadoOperacao;

import java.sql.SQLException;
import java.util.List;

import static br.com.marcos.biblioteca.enums.ResultadoOperacao.*;

public class LivroService {

    private final LivroDAO livroDAO;

    public LivroService(LivroDAO livroDAO){
        this.livroDAO = livroDAO;
    }

    public List<Livro> listarTodos() throws SQLException{
       return livroDAO.listarTodos();
    }

    public boolean cadastrar(Livro livro) throws SQLException {
        if (livroDAO.existeISBN(livro.getIsbn())) {
            throw new IllegalArgumentException("ISBN ja cadastrado.");
        }
        return livroDAO.cadastraLivro(livro);
    }

    public  ResultadoOperacao atualizar(Livro livro) throws SQLException{
        if(livroDAO.existeIsbnAtualizar(livro.getIsbn(), livro.getId())){
            return ISBN_DUPLICADO;
        }
        if (livroDAO.atualizarLivro(livro)) {
            return SUCESSO;
        } else {
            return NAO_ENCONTRADO;
        }

    }

    public boolean deletar(int id) throws SQLException{
        return livroDAO.deletarLivro(id);
    }
}
