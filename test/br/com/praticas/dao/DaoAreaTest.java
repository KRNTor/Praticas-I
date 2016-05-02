/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.dao;

import br.com.praticas.facade.Facade;
import br.com.praticas.model.Area;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Felipe
 */
public class DaoAreaTest {
    
    Area area;
    Facade facade;
    
    public DaoAreaTest() {
    }
    
    @Before
    public void setUp() {
        area = new Area();
        facade = new Facade();
    }
    
    @After
    public void tearDown() {
        area = null;
        facade = null;
    }

    /**
     * Test of salvarArea method, of class AreaDao.
     */
    @Test
    public void testSalvarArea() throws Exception {
        System.out.println("salvarArea");
        area.setAreaNome("Quimica");
        facade.salvarArea(area);
    }

    /**
     * Test of buscarArea method, of class AreaDao.
     */
    @Ignore
    public void testBuscarArea() throws Exception {
        System.out.println("buscarArea");
        String expResult = "Fizica";
        Area result = facade.buscarArea(expResult);
        assertEquals(expResult, result.getAreaNome());
    }

    /**
     * Test of removerArea method, of class AreaDao.
     */
    @Ignore
    public void testRemoverArea() throws Exception {
        System.out.println("removerArea");
        String expResult = "Quimica";
        Area a = new DaoArea().buscarArea(expResult);
        facade.removerArea(a);
    }

    /**
     * Test of editarArea method, of class AreaDao.
     */
    @Ignore
    public void testEditarArea() throws Exception {
        System.out.println("editarArea");
        Area a = null;
        facade.editarArea(a);
    }
    
}
