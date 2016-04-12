/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model;

/**
 *
 * @author RicksonEllen
 */
public class UsuarioAdm extends Usuario {

    private String chave_acesso;

    public String getChave_acesso() {
        return chave_acesso;
    }

    public void setChave_acesso(String chave_acesso) {
        this.chave_acesso = chave_acesso;
    }

    @Override
    public String toString() {
        return "UsuarioAdm{" + "chave_acesso=" + chave_acesso + '}';
    }

}
