/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.dao;

import br.com.praticas.model.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Felipe
 */
public class DaoUsuarioTest {

    Usuario user;

    public DaoUsuarioTest() {
    }

    @Before
    public void setUp() {
        user = new Usuario();
    }

    @After
    public void tearDown() {
        user = null;
    }

    /**
     * Test of salvarUsuario method, of class UsuarioDao.
     */
    @Ignore
    public void testSalvarUsuario() {
        System.out.println("salvarUsuario");
        user.setNome("TesteNome");
        user.setNick("TesteUsername");
        user.setSenha("teste123");
        user.setEmail("testJunit@gmail.com");
        user.setTipo("J");
        DaoUsuario instance = new DaoUsuario();
        try {
            instance.salvarUsuario(user);
        } catch (Exception ex) {
            Logger.getLogger(DaoUsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of removerUsuario method, of class UsuarioDao.
     */
    @Ignore
    public void testRemoverUsuario() throws Exception {
        System.out.println("removerUsuario");
        DaoUsuario instance = new DaoUsuario();
        Usuario u = instance.buscarUsuario("TesteUsername", "teste123");
        instance.removerUsuario(u);
    }

    /**
     * Test of buscarUsuario method, of class UsuarioDao.
     */
    @Ignore
    public void testBuscarUsuario() throws Exception {
        System.out.println("buscarUsuario");
        DaoUsuario instance = new DaoUsuario();
        String expResult = "Felipe";
        Usuario result = instance.buscarUsuario("KRNTor", "Wanderson");
        assertEquals(expResult, result.getNome());
    }

    /**
     * Test of editarUsuario method, of class UsuarioDao.
     */
    @Ignore
    public void testEditarUsuario() {
        System.out.println("editarUsuario");
        Usuario u = null;
        DaoUsuario instance = new DaoUsuario();
        instance.editarUsuario(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
