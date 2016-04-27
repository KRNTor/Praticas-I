/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.dao;

import br.com.praticas.facade.Facade;
import br.com.praticas.model.Area;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Felipe
 */
public class AreaDaoTest {
    
    Area area;
    Facade facade;
    
    public AreaDaoTest() {
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
        area.setAreaNome("Biologia");
        facade.salvarArea(area);
    }

    /**
     * Test of buscarArea method, of class AreaDao.
     */
    @Ignore
    public void testBuscarArea() throws Exception {
        System.out.println("buscarArea");
        String areaNome = "Fizica";
        AreaDao instance = new AreaDao();
        String expResult = "Fizica";
        Area result = instance.buscarArea(areaNome);
        assertEquals(expResult, result.getAreaNome());
    }

    /**
     * Test of removerArea method, of class AreaDao.
     */
    @Ignore
    public void testRemoverArea() throws Exception {
        System.out.println("removerArea");
        String busca = "Quimica";
        Area a = new AreaDao().buscarArea(busca);
        AreaDao instance = new AreaDao();
        instance.removerArea(a);
    }

    /**
     * Test of editarArea method, of class AreaDao.
     */
    @Ignore
    public void testEditarArea() throws Exception {
        System.out.println("editarArea");
        Area a = null;
        AreaDao instance = new AreaDao();
        instance.editarArea(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
