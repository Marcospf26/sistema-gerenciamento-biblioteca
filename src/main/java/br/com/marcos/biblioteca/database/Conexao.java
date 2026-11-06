package br.com.marcos.biblioteca.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

//    public static final String url = "jdbc:postgresql://localhost:5432/Desafio_3_BD";
//    public static final String usuario = "postgres";
    public static final String url = System.getenv("DB_URL");
    public static final String usuario = System.getenv("DB_USER");
    public static final String senha = System.getenv("DB_PASSWORD");

    public static Connection conectar() throws  SQLException{
        return DriverManager.getConnection(url, usuario, senha);
    }
}
