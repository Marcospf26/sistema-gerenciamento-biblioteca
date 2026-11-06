package br.com.marcos.biblioteca;
import br.com.marcos.biblioteca.model.Livro;
import br.com.marcos.biblioteca.dao.LivroDAO;
import br.com.marcos.biblioteca.service.LivroService;
import br.com.marcos.biblioteca.enums.ResultadoOperacao;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.marcos.biblioteca.enums.ResultadoOperacao;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws SQLException {
        Scanner ler = new Scanner(System.in);
        LivroService livroService = new LivroService(new LivroDAO());

        int x = 0;


        do{
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Atualizar livro");
            System.out.println("4 - Excluir livro");
            System.out.println("5 - Sair");


            try {
                x = ler.nextInt();
                ler.nextLine();

                switch (x) {
                    case 1:
                        System.out.println("Cadastrar livro");

                        System.out.println("Titulo");
                        String cadastroTitulo = ler.nextLine();

                        System.out.println("Autor");
                        String cadastroAutor = ler.nextLine();

                        System.out.println("ISBN");
                        String cadastroISBN = ler.nextLine();

                        System.out.println("Quantidade de exemplares");
                        int cadastroQuantidade = ler.nextInt();
                        ler.nextLine();

                        Livro livro = new Livro(cadastroTitulo, cadastroAutor, cadastroISBN, cadastroQuantidade);
                        if (livroService.cadastrar(livro)) {
                            System.out.println("Livro cadastrado com sucesso");
                        } else {
                            System.out.println("Nao foi possivel cadastrar o livro.");
                        }

                        break;
                    case 2:

                        List<Livro> livros = livroService.listarTodos();
                        for(Livro livs : livros) {
                            System.out.println(livs);
                        }

                        break;
                    case 3:
                        System.out.println("Atualizar livro");

                        System.out.println("Id do livro");
                        int idAtualizarLivro = ler.nextInt();
                        ler.nextLine();


                        System.out.println("Titulo");
                        String atualizarTitulo = ler.nextLine();

                        System.out.println("Autor");
                        String atualizarAutor = ler.nextLine();

                        System.out.println("ISBN");
                        String atualizarISBN = ler.nextLine();

                        System.out.println("Quantidade de exemplares");
                        int atualizarQuantidade = ler.nextInt();
                        ler.nextLine();

                        Livro livroATT = new Livro(idAtualizarLivro, atualizarTitulo, atualizarAutor, atualizarISBN, atualizarQuantidade);

                        ResultadoOperacao resultado = livroService.atualizar(livroATT);
                        switch (resultado) {
                            case SUCESSO -> {
                                System.out.println("Livro atualizado com sucesso");
                            }
                            case NAO_ENCONTRADO -> {
                                System.out.println("Livro Nao encontrado");
                            }

                            case ISBN_DUPLICADO -> {
                                System.out.println("Esse ISBN esta duplicado");
                            }

                        }


                        break;
                    case 4:
                        System.out.println("Excluir livro");

                        System.out.println("Id do livro");
                        int idExcluirLivro = ler.nextInt();
                        ler.nextLine();

                        if (livroService.deletar(idExcluirLivro)) {
                            System.out.println("Livro Excluido com sucesso");
                        } else {
                            System.out.println("Nao foi possivel remover o livro");
                        }

                        break;
                    default:
                        System.out.println("Insira uma opcao valida");

                        break;
                }
            } catch (SQLException e) {
                System.out.println("Erro no banco de dados: " + e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Digite um numero.");
                ler.nextLine();
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }while(x!=5);
    }

}