/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.dao;

import br.com.praticas.facade.Facade;
import br.com.praticas.model.HistoricoJogador;
import br.com.praticas.model.Pergunta;
import br.com.praticas.model.Usuario;
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
public class DaoHistoricoTest {

    Facade facade;
    HistoricoJogador hj;
    Pergunta p;
    Usuario user;

    public DaoHistoricoTest() {
    }

    @Before
    public void setUp() {
        facade = new Facade();
        hj = new HistoricoJogador();
        p = new Pergunta();
        user = new Usuario();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of salvarHistoricoJogador method, of class HistoricoJogadorDao.
     */
    @Test
    public void testSalvarHistoricoJogador() throws Exception {
        System.out.println("salvarHistoricoJogador");
        hj.setPerguntasCertas(0);
        hj.setPerguntasRespondidas(0);
        user = facade.buscarUsuario("KRNTor", "Wanderson");
        hj.setUsuario(user);
        p = facade.buscarPergunta(3);
        hj.setPergunta(p);
        Pergunta p = null;
        Usuario u = null;
        facade.salvarHistorico(hj, p, u);
    }

    /**
     * Test of buscarHistorico method, of class HistoricoJogadorDao.
     */
    @Ignore
    public void testBuscarHistorico() throws Exception {
        System.out.println("buscarHistorico");
        long id = 0L;
        DaoHistorico instance = new DaoHistorico();
        HistoricoJogador expResult = null;
        HistoricoJogador result = instance.buscarHistorico(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarHistorico method, of class HistoricoJogadorDao.
     */
    @Ignore
    public void testEditarHistorico() throws Exception {
        System.out.println("editarHistorico");
        Usuario u = null;
        Pergunta p = null;
        HistoricoJogador h = null;
        DaoHistorico instance = new DaoHistorico();
        instance.editarHistorico(u, p, h);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarHistorico2 method, of class HistoricoJogadorDao.
     */
    @Ignore
    public void testEditarHistorico2() throws Exception {
        System.out.println("editarHistorico2");
        Usuario u = null;
        Pergunta p = null;
        HistoricoJogador h = null;
        DaoHistorico instance = new DaoHistorico();
        instance.editarHistorico2(u, p, h);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvarPergunta method, of class HistoricoJogadorDao.
     */
    @Ignore
    public void testSalvarPergunta() throws Exception {
        System.out.println("salvarPergunta");
        Pergunta p = null;
        DaoHistorico instance = new DaoHistorico();
        long expResult = 0L;
        long result = instance.salvarPergunta(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
