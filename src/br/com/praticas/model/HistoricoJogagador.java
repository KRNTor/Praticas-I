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
public class HistoricoJogagador {

    private List<Pergunta> perguntasRespondidas;
    private int respostasCertas;
    private int respostasErradas;

    public HistoricoJogagador() {

    }

    public HistoricoJogagador(List<Pergunta> perguntasRespondidas, int respostasCertas, int respostasErradas) {
        this.perguntasRespondidas = perguntasRespondidas;
        this.respostasCertas = respostasCertas;
        this.respostasErradas = respostasErradas;
    }

    public List<Pergunta> getPerguntas() {
        return perguntasRespondidas;
    }

    public int getRespostasCertas() {
        return respostasCertas;
    }

    public int getRespostasErradas() {
        return respostasErradas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntasRespondidas = perguntas;
    }

    public void setRespostasCertas(int respostasCertas) {
        this.respostasCertas = respostasCertas;
    }

    public void setRespostasErradas(int respostasErradas) {
        this.respostasErradas = respostasErradas;
    }

    @Override
    public String toString() {
        return "Resposta{" + "perguntas=" + perguntasRespondidas + ", respostasCertas=" + respostasCertas + ", respostasErradas=" + respostasErradas + '}';
    }

}
