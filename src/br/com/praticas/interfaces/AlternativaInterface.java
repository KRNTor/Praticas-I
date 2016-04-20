/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfaces;

import br.com.praticas.model.Alternativa;
import java.util.List;

/**
 *
 * @author Felipe
 */
public interface AlternativaInterface {
    
    public long salvarAlternativa(Alternativa a) throws Exception;
    
    public List<Alternativa> listar() throws Exception;
    
}
