/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfaces;

import br.com.praticas.model.Area;
import java.util.List;

/**
 *
 * @author Felipe
 */
public interface AreaInterface {

    public void salvarArea(Area a) throws Exception;

    public boolean verificarArea(String area) throws Exception;

    public Area buscarArea(String area) throws Exception;

    public List<Area> listarArea() throws Exception;
    
    public void removerArea(Area a) throws Exception;

}
