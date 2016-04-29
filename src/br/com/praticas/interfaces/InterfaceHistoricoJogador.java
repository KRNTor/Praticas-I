/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfaces;

import br.com.praticas.model.HistoricoJogador;
import br.com.praticas.model.Pergunta;
import br.com.praticas.model.Usuario;

/**
 *
 * @author Sidney
 */
public interface InterfaceHistoricoJogador {

    public void salvarHistoricoJogador(HistoricoJogador h, Pergunta p, Usuario u) throws Exception;

    public HistoricoJogador buscarHistorico(long id) throws Exception;

    public void editarHistorico(Usuario u, Pergunta p, HistoricoJogador h) throws Exception;

    public void editarHistorico2(Usuario u, Pergunta p, HistoricoJogador h) throws Exception;

    public long salvarPergunta(Pergunta p) throws Exception;

}
