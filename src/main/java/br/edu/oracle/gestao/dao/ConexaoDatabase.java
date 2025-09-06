package br.edu.oracle.gestao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDatabase {
    // IMPORTANTE: COLOQUE SUA SENHA DO MYSQL AQUI!
    private static final String URL = "jdbc:mysql://localhost:3306/gestao_projetos";
    private static final String USUARIO = "root";
    private static final String SENHA = "Dan123!"; // MUDE PARA SUA SENHA!

    private static Connection conexao;

    public static Connection getConexao() {
        try {
            if (conexao == null || conexao.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                System.out.println("✓ Conectado ao banco!");
            }
        } catch (Exception e) {
            System.err.println("✗ Erro ao conectar: " + e.getMessage());
            return null;
        }
        return conexao;
    }

    public static boolean testarConexao() {
        return getConexao() != null;
    }
}