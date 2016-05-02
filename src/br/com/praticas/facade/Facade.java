/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.facade;

import br.com.praticas.util.DaoFactory;
import br.com.praticas.interfaces.AlternativaInterface;
import br.com.praticas.interfaces.AreaInterface;
import br.com.praticas.interfaces.InterfaceHistoricoJogador;
import br.com.praticas.interfaces.PerguntaInterface;
import br.com.praticas.interfaces.UsuarioInterface;
import br.com.praticas.model.Alternativa;
import br.com.praticas.model.Area;
import br.com.praticas.model.HistoricoJogador;
import br.com.praticas.model.Pergunta;
import br.com.praticas.model.Usuario;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author RicksonEllen
 */
public class Facade implements Serializable {

    private UsuarioInterface daoUsuario;
    private PerguntaInterface daoPergunta;
    private AreaInterface daoArea;
    private AlternativaInterface daoAlternativa;
    private InterfaceHistoricoJogador daoHistoricoJogador;

    public Facade() {
        this.daoUsuario = DaoFactory.createUsuarioDao();
        this.daoPergunta = DaoFactory.createPerguntaDao();
        this.daoArea = DaoFactory.createAreaDao();
        this.daoAlternativa = DaoFactory.createAlternativaDao();
        this.daoHistoricoJogador = DaoFactory.createHistoricoDao();
    }

    //METODOS DO DAO USUARIO
    public void salvarUsuario(Usuario usuario) throws Exception {
        this.daoUsuario.salvarUsuario(usuario);
    }

    public void removerUsuario(Usuario u) throws Exception {
        this.daoUsuario.removerUsuario(u);
    }

    public boolean verificarUsuario(String nome) throws Exception {
        return this.daoUsuario.verificarUsuario(nome);
    }

    public Usuario buscarUsuario(String nome, String senha) throws Exception {
        return this.daoUsuario.buscarUsuario(nome, senha);
    }

    public List<Usuario> listarUsuario() throws Exception {
        return this.daoUsuario.listarUsuario();
    }

    public void editarUsuario(Usuario usuario) {
        this.daoUsuario.editarUsuario(usuario);
    }

    //METODOS DO DAO PERGUNTA
    public void salvarPergunta(Pergunta p) throws Exception {
        this.daoPergunta.salvarPergunta(p);
    }

    public boolean verificarPergunta(String questao) throws Exception {
        return this.daoPergunta.verificarPergunta(questao);
    }

    public Pergunta buscarPergunta(String nome) throws Exception {
        return this.daoPergunta.buscarPergunta(nome);
    }

    public Pergunta buscarPergunta(long id) throws Exception {
        return this.daoPergunta.buscarPergunta(id);
    }

    public List<Pergunta> listarPergunta() throws Exception {
        return this.daoPergunta.listarPergunta();
    }

    public void removerPergunta(Pergunta p) throws Exception {
        this.daoPergunta.removerPergunta(p);
    }

    //METODOS DO DAO AREA
    public void salvarArea(Area a) throws Exception {
        this.daoArea.salvarArea(a);
    }

    public boolean verificarArea(String area) throws Exception {
        return this.daoArea.verificarArea(area);
    }

    public Area buscarArea(String area) throws Exception {
        return this.daoArea.buscarArea(area);
    }

    public List<Area> listarArea() throws Exception {
        return this.daoArea.listarArea();
    }

    public void removerArea(Area a) throws Exception {
        this.daoArea.removerArea(a);
    }
    
    public void editarArea(Area a) throws Exception{
        this.daoArea.editarArea(a);
    }

    //METODOS DO DAO ALTERNATIVA
    public long salvarAlternativa(Alternativa a) throws Exception {
        return this.daoAlternativa.salvarAlternativa(a);
    }

    public List<Alternativa> listar() throws Exception {
        return this.daoAlternativa.listar();
    }

    //METODOS DO DAO HISTORICOJOGADOR
    public void salvarHistorico(HistoricoJogador h, Pergunta p, Usuario u) throws Exception {
        this.daoHistoricoJogador.salvarHistoricoJogador(h, p, u);
    }
}
