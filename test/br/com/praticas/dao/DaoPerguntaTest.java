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
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Felipe
 */
public class DaoPerguntaTest {

    Pergunta p;
    Alternativa a;
    Facade facade;

    public DaoPerguntaTest() {
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
    @Ignore
    public void testSalvarPergunta() throws Exception {
        System.out.println("salvarPergunta");
        p.setNivel("Facil");
        Area area = facade.buscarArea("Biologia");
        p.setArea(area);
        p.setQuestao("o que e o que eh? teste");
        a.setAlt1("a");
        a.setAlt2("b");
        a.setAlt3("c");
        a.setAlt4("d");
        a.setAlt5("e");
        a.setAltCorreta("a");
        a.setPergunta(p);
        facade.salvarPergunta(p);
    }

    /**
     * Test of buscarPergunta method, of class PerguntaDao.
     */
    @Ignore
    public void testBuscarPergunta_String() throws Exception {
        System.out.println("buscarPergunta");
        String questao = "o que e o que eh? teste";
        Pergunta result = facade.buscarPergunta(questao);
        assertEquals(questao, result.getQuestao());
    }

    /**
     * Test of buscarPergunta method, of class PerguntaDao.
     */
    @Ignore
    public void testBuscarPergunta_long() throws Exception {
        System.out.println("buscarPergunta");
        long id = 3;
        Pergunta result = facade.buscarPergunta(id);
        assertEquals(id, result.getId());
    }

    /**
     * Test of removerPergunta method, of class PerguntaDao.
     */
    @Ignore
    public void testRemoverPergunta() throws Exception {
        System.out.println("removerPergunta");
        DaoPergunta instance = new DaoPergunta();
        p = instance.buscarPergunta(3);
        instance.removerPergunta(p);

    }

    /**
     * Test of editarPergunta method, of class PerguntaDao.
     */
    @Ignore
    public void testEditarPergunta() throws Exception {
        System.out.println("editarPergunta");
        Pergunta p = null;
        DaoPergunta instance = new DaoPergunta();
        instance.editarPergunta(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
