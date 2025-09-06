package br.edu.oracle.gestao.main;

import br.edu.oracle.gestao.dao.ConexaoDatabase;
import br.edu.oracle.gestao.view.LoginView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("    SISTEMA DE GESTÃO DE PROJETOS ORACLE");
        System.out.println("===========================================");

        // Testa conexão
        if (ConexaoDatabase.testarConexao()) {
            System.out.println("✓ Sistema pronto!");

            // Abre tela de login diretamente
            SwingUtilities.invokeLater(() -> {
                new LoginView().setVisible(true);
            });

        } else {
            System.err.println("✗ Erro ao conectar com banco!");
            JOptionPane.showMessageDialog(null,
                    "Erro de conexão com banco!\nVerifique MySQL e senha.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}