/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.facade;

import br.com.praticas.factory.DaoFactory;
import br.com.praticas.interfaces.AlternativaInterface;
import br.com.praticas.interfaces.AreaInterface;
import br.com.praticas.interfaces.PerguntaInterface;
import br.com.praticas.interfaces.UsuarioInterface;
import br.com.praticas.model.Alternativa;
import br.com.praticas.model.Area;
import br.com.praticas.model.Pergunta;
import br.com.praticas.model.Usuario;
import java.util.List;

/**
 *
 * @author RicksonEllen
 */
public class Facade {
    private UsuarioInterface daoUsuario;
    private PerguntaInterface daoPergunta;
    private AreaInterface daoArea;
    private AlternativaInterface daoAlternativa;
    
    public Facade(){
        daoUsuario = DaoFactory.createUsuarioDao();
        daoPergunta = DaoFactory.createPerguntaDao();
        daoArea = DaoFactory.createAreaDao();
        daoAlternativa = DaoFactory.createAlternativaDao();
    }
    
    //METODOS DO DAO USUARIO
     public void salvarUsuario(Usuario usuario) throws Exception{
         daoUsuario.salvarUsuario(usuario);
     }

    public void removerUsuario(Usuario u) throws Exception{
        daoUsuario.removerUsuario(u);
    }

    public boolean verificarUsuario(String nome) throws Exception{
        return daoUsuario.verificarUsuario(nome);
    }

    public Usuario buscarUsuario(String nome, String senha) throws Exception{
        return daoUsuario.buscarUsuario(nome, senha);
    }

    public List<Usuario> listarUsuario() throws Exception{
        return daoUsuario.listarUsuario();
    }

    public void editarUsuario (Usuario usuario){
        daoUsuario.editarUsuario(usuario);
    }
    
    //METODOS DO DAO PERGUNTA
     public void salvarPergunta(Pergunta p, Alternativa a) throws Exception{
         daoPergunta.salvarPergunta(p, a);
     }

    public boolean verificarPergunta(String questao) throws Exception{
        return daoPergunta.verificarPergunta(questao);
    }
    public Pergunta buscarPergunta(String nome) throws Exception{
        return daoPergunta.buscarPergunta(nome);
    }
    public Pergunta buscarPergunta(long id) throws Exception{
        return daoPergunta.buscarPergunta(id);
    }

    public List<Pergunta> listarPergunta() throws Exception{
        return daoPergunta.listarPergunta();
    }

    public void removerPergunta(Pergunta p) throws Exception{
        daoPergunta.removerPergunta(p);
    }
    
    //METODOS DO DAO AREA
    public void salvarArea(Area a) throws Exception{
        daoArea.salvarArea(a);
    }

    public boolean verificarArea(String area) throws Exception{
        return daoArea.verificarArea(area);
    }

    public Area buscarArea(String area) throws Exception{
        return daoArea.buscarArea(area);
    }

    public List<Area> listarArea() throws Exception{
        return daoArea.listarArea();
    }    
    public void removerArea(Area a) throws Exception{
        daoArea.removerArea(a);
    }
    
    //METODOS DO DAO ALTERNATIVA
     public long salvarAlternativa(Alternativa a) throws Exception{
         return daoAlternativa.salvarAlternativa(a);
     }    
    public List<Alternativa> listar() throws Exception{
        return daoAlternativa.listar();
    }
}
