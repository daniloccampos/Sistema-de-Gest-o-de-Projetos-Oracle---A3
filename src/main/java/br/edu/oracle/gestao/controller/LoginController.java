package br.edu.oracle.gestao.controller;

import br.edu.oracle.gestao.dao.UsuarioDAO;
import br.edu.oracle.gestao.model.Usuario;

public class LoginController {
    private UsuarioDAO usuarioDAO;

    public LoginController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario autenticar(String login, String senha) {
        if (login == null || login.trim().isEmpty() ||
                senha == null || senha.trim().isEmpty()) {
            return null;
        }

        return usuarioDAO.buscarPorLoginSenha(login.trim(), senha);
    }
}