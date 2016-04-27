/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.dao;

import br.com.praticas.facade.Facade;
import br.com.praticas.model.Alternativa;
import br.com.praticas.model.Area;
import br.com.praticas.model.Pergunta;
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
public class PerguntaDaoTest {

    Pergunta p;
    Alternativa a;
    Facade facade;

    public PerguntaDaoTest() {
    }

    @Before
    public void setUp() {
        p = new Pergunta();
        a = new Alternativa();
        facade = new Facade();
    }

    @After
    public void tearDown() {
        p = null;
        a = null;
        facade = null;
    }

    /**
     * Test of salvarPergunta method, of class PerguntaDao.
     */
    @Test
    public void testSalvarPergunta() throws Exception {
        System.out.println("salvarPergunta");
        p.setNivel("Facil");
        Area area = facade.buscarArea("Fizica");
        System.out.println(area.toString());
        p.setArea(area);
        a.setAlt1("a");
        a.setAlt2("b");
        a.setAlt3("c");
        a.setAlt4("d");
        a.setAlt5("e");
        a.setAltCorreta("a");
        a.setPergunta(p);
        facade.salvarPergunta(p, a);
    }

    /**
     * Test of buscarPergunta method, of class PerguntaDao.
     */
    @Ignore
    public void testBuscarPergunta_String() throws Exception {
        System.out.println("buscarPergunta");
        String nome = "";
        PerguntaDao instance = new PerguntaDao();
        Pergunta expResult = null;
        Pergunta result = instance.buscarPergunta(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPergunta method, of class PerguntaDao.
     */
    @Ignore
    public void testBuscarPergunta_long() throws Exception {
        System.out.println("buscarPergunta");
        long id = 0L;
        PerguntaDao instance = new PerguntaDao();
        Pergunta expResult = null;
        Pergunta result = instance.buscarPergunta(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarPergunta method, of class PerguntaDao.
     */
    @Ignore
    public void testListarPergunta() throws Exception {
        System.out.println("listarPergunta");
        PerguntaDao instance = new PerguntaDao();
        List<Pergunta> expResult = null;
        List<Pergunta> result = instance.listarPergunta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerPergunta method, of class PerguntaDao.
     */
    @Ignore
    public void testRemoverPergunta() throws Exception {
        System.out.println("removerPergunta");
        Pergunta p = null;
        PerguntaDao instance = new PerguntaDao();
        instance.removerPergunta(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarPergunta method, of class PerguntaDao.
     */
    @Ignore
    public void testEditarPergunta() throws Exception {
        System.out.println("editarPergunta");
        Pergunta p = null;
        PerguntaDao instance = new PerguntaDao();
        instance.editarPergunta(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
