/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfaces;

import br.com.praticas.model.Usuario;
import java.util.List;

/**
 *
 * @author RicksonEllen
 */
public interface UsuarioInterface {

    public void salvarUsuario(Usuario usuario) throws Exception;

    public void removerUsuario(Usuario u) throws Exception;

    public boolean verificarUsuario(String nome) throws Exception;

    public Usuario buscarUsuario(String nome, String senha) throws Exception;

    public List<Usuario> listarUsuario() throws Exception;

    public void editarUsuario (Usuario usuario);
}
