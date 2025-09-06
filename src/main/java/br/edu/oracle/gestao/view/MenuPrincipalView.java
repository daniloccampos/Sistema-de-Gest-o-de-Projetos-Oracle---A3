package br.edu.oracle.gestao.view;

import br.edu.oracle.gestao.model.Usuario;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalView extends JFrame {
    private Usuario usuarioLogado;

    public MenuPrincipalView(Usuario usuario) {
        this.usuarioLogado = usuario;
        initComponents();
    }

    private void initComponents() {
        setTitle("Menu Principal - Usuário: " + usuarioLogado.getNomeCompleto());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Painel central
        JPanel painel = new JPanel(new BorderLayout());

        JLabel lblBemVindo = new JLabel(
                "<html><center><h1>Bem-vindo ao Sistema!</h1>" +
                        "<h2>" + usuarioLogado.getNomeCompleto() + "</h2>" +
                        "<p>Perfil: " + usuarioLogado.getPerfil().getDescricao() + "</p></center></html>"
        );
        lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);

        painel.add(lblBemVindo, BorderLayout.CENTER);
        add(painel);

        setLocationRelativeTo(null);
    }
}