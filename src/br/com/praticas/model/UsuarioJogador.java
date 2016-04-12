/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model;

import java.util.List;

/**
 *
 * @author Felipe
 */
public class UsuarioJogador extends Usuario {

    private HistoricoJogagador hisJogador;

    public HistoricoJogagador getHisJogador() {
        return this.hisJogador;
    }

    public void setHisJogador(HistoricoJogagador hisJogador) {
        this.hisJogador = hisJogador;
    }

    @Override
    public String toString() {
        return "UsuarioJogador{" + "hisJogador=" + hisJogador + '}';
    }

}
