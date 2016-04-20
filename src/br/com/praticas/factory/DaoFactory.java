/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.factory;

import br.com.praticas.dao.AlternativaDao;
import br.com.praticas.dao.AreaDao;
import br.com.praticas.dao.PerguntaDao;
import br.com.praticas.dao.UsuarioDao;
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
        return new UsuarioDao();
    }
    
    public static PerguntaInterface createPerguntaDao(){
        return new PerguntaDao();
    }
    
    public static AreaInterface createAreaDao(){
        return new AreaDao();
    }
    
    public static AlternativaInterface createAlternativaDao(){
        return new AlternativaDao();
    }
}
