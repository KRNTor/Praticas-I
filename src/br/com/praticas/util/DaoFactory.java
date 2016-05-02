/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.util;

import br.com.praticas.dao.DaoAlternativa;
import br.com.praticas.dao.DaoArea;
import br.com.praticas.dao.DaoHistorico;
import br.com.praticas.dao.DaoPergunta;
import br.com.praticas.dao.DaoUsuario;
import br.com.praticas.interfaces.AlternativaInterface;
import br.com.praticas.interfaces.AreaInterface;
import br.com.praticas.interfaces.PerguntaInterface;
import br.com.praticas.interfaces.UsuarioInterface;

/**
 *
 * @author RicksonEllen
 */
public class DaoFactory {
    public static UsuarioInterface createUsuarioDao(){
        return new DaoUsuario();
    }
    
    public static PerguntaInterface createPerguntaDao(){
        return new DaoPergunta();
    }
    
    public static AreaInterface createAreaDao(){
        return new DaoArea();
    }
    
    public static AlternativaInterface createAlternativaDao(){
        return new DaoAlternativa();
    }

    public static DaoHistorico createHistoricoDao() {
        return new DaoHistorico();
    }
}
