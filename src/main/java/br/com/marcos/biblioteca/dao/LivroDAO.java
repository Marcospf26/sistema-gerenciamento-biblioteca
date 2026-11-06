package br.com.marcos.biblioteca.dao;

import br.com.marcos.biblioteca.model.Livro;
import br.com.marcos.biblioteca.database.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public List<Livro> listarTodos() throws SQLException {

        String sql = "SELECT id, titulo, autor, isbn, quantidade_exemplares FROM livros";

        try (Connection c1 = Conexao.conectar();
             PreparedStatement ps = c1.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
        ) {
            List<Livro> livros = new ArrayList<>();
            while (rs.next()) {
                int idLivro = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String isbn = rs.getString("isbn");
                int qtdExemplares = rs.getInt("quantidade_exemplares");
                Livro livro = new Livro(idLivro, titulo, autor, isbn, qtdExemplares);
                livros.add(livro);

            }
            return livros;

        }
    }



    public boolean cadastraLivro(Livro livro) throws SQLException{
        String sql = "INSERT INTO livros (titulo, autor, isbn, quantidade_exemplares) VALUES (? , ? , ?, ?)";

        try ( Connection c = Conexao.conectar();
              PreparedStatement ps = c.prepareStatement(sql);
              )
            {

                ps.setString(1, livro.getTitulo());
                ps.setString(2, livro.getAutor());
                ps.setString(3, livro.getIsbn());
                ps.setInt(4, livro.getQuantidadeExemplares());


                int rs = ps.executeUpdate();
                if(rs > 0) {
                    return true;
                }


        }
        return false;
    }




    public boolean atualizarLivro(Livro livro) throws  SQLException{
        String sql = "UPDATE livros SET titulo = ?, autor = ?, isbn = ?, quantidade_exemplares = ?  WHERE id = ? ;";

        try(Connection c = Conexao.conectar();
            PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setString(3, livro.getIsbn());
            ps.setInt(4, livro.getQuantidadeExemplares());
            ps.setInt(5, livro.getId());


            int x = ps.executeUpdate();
            if(x > 0) {
                return true;
            }


        }

    return false;
    }

    public boolean deletarLivro(int id) throws  SQLException{
        String sql = "DELETE FROM livros WHERE id = ? ;";

        try(Connection c = Conexao.conectar();
            PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1, id);

            int x = ps.executeUpdate();
            if(x > 0) {
                return true;
            }

        }
        return false;
    }

    public boolean existeISBN(String isbn) throws SQLException {
        String sql = "SELECT 1 FROM livros WHERE isbn = ? LIMIT 1;";

        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql);

        ){

            ps.setString(1, isbn);

            try(ResultSet rs = ps.executeQuery();) {
                return rs.next();
            }

        }

    }

    public boolean existeIsbnAtualizar(String isbn, int id) throws SQLException {
           String sql = "SELECT 1 FROM livros WHERE isbn = ? AND id <> ?;";

            try (Connection c = Conexao.conectar();
                PreparedStatement ps = c.prepareStatement(sql);
            ){

                ps.setString(1, isbn);
                ps.setInt(2, id);

                try(ResultSet rs = ps.executeQuery();) {
                    return rs.next();
                }
            }
    }




}
