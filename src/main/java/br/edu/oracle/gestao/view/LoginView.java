package br.edu.oracle.gestao.view;

import br.edu.oracle.gestao.controller.LoginController;
import br.edu.oracle.gestao.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JButton btnLogin;
    private JButton btnSair;
    private LoginController controller;

    public LoginView() {
        this.controller = new LoginController();
        initComponents();
        setupLayout();
        setupEvents();
    }

    private void initComponents() {
        setTitle("Login - Sistema de Gestão de Projetos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        txtLogin = new JTextField(20);
        txtSenha = new JPasswordField(20);
        btnLogin = new JButton("Entrar");
        btnSair = new JButton("Sair");
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Título
        JLabel lblTitulo = new JLabel("SISTEMA DE GESTÃO DE PROJETOS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(new Color(25, 118, 210));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        // Login
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Login:"), gbc);
        gbc.gridx = 1;
        add(txtLogin, gbc);

        // Senha
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Senha:"), gbc);
        gbc.gridx = 1;
        add(txtSenha, gbc);

        // Botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnLogin);
        painelBotoes.add(btnSair);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        add(painelBotoes, gbc);

        // Dica
        JLabel lblDica = new JLabel("Teste: admin/123, joao/123, maria/123");
        lblDica.setFont(new Font("Arial", Font.ITALIC, 11));
        gbc.gridy = 4;
        add(lblDica, gbc);

        pack();
        setLocationRelativeTo(null);
    }

    private void setupEvents() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });

        btnSair.addActionListener(e -> System.exit(0));

        txtSenha.addActionListener(e -> realizarLogin());
    }

    private void realizarLogin() {
        String login = txtLogin.getText();
        String senha = new String(txtSenha.getPassword());

        Usuario usuario = controller.autenticar(login, senha);

        if (usuario != null) {
            JOptionPane.showMessageDialog(this,
                    "Bem-vindo, " + usuario.getNomeCompleto() + "!",
                    "Login Realizado",
                    JOptionPane.INFORMATION_MESSAGE);

            dispose();
            new MenuPrincipalView(usuario).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Login ou senha incorretos!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            txtSenha.setText("");
        }
    }
}