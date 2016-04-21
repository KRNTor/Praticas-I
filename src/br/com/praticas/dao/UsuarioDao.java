/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.dao;

import br.com.praticas.util.Conexao;
import br.com.praticas.interfaces.UsuarioInterface;
import br.com.praticas.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RicksonEllen
 */
public class UsuarioDao implements UsuarioInterface {

    private Connection cn;

    @Override
    public void salvarUsuario(Usuario u) throws Exception {

        cn = Conexao.getConnection();

        String sql = "insert into usuario (nome, nick, senha, email, tipo) values (?, ?, ?, ?, ?);";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, u.getNome());
            pst.setString(2, u.getNick());
            pst.setString(3, u.getSenha());
            pst.setString(4, u.getEmail());
            pst.setString(5, u.getTipo());
            pst.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,
                    null, e);
            throw new Exception("USUARIO");
        }

    }

    @Override
    public void removerUsuario(Usuario u) throws Exception {
        cn = Conexao.getConnection();

        String sql = "delete from usuario u where u.id = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, (int) u.getId());
            pst.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("ERRO AO REMOVER USUARIO");
        }
    }

    @Override
    public boolean verificarUsuario(String nome) throws Exception {
        cn = Conexao.getConnection();

        String sql = "select * from usuario u";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString("nick").equalsIgnoreCase(nome) && rs.getString("senha").equalsIgnoreCase(nome)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,
                    null, e);
            throw new Exception("ERRO AO VERIFICAR EXISTENCIA DE USUARIO");
        }
        return false;
    }

    @Override
    public Usuario buscarUsuario(String nick, String senha) throws Exception {
        cn = Conexao.getConnection();

        String sql = "select * from usuario c";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString("nick").equalsIgnoreCase(nick) && rs.getString("senha").equalsIgnoreCase(senha)) {
                    Usuario user = new Usuario();
                    user.setId(rs.getInt("id"));
                    user.setNome(rs.getString("nome"));
                    user.setNick(rs.getString("nick"));
                    user.setSenha(rs.getString("senha"));
                    user.setEmail(rs.getString("email"));
                    user.setTipo(rs.getString("tipo"));
                    return user;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,
                    null, e);
            throw new Exception("ERRO AO BUSCAR USUARIO");
        }
        return null;
    }

    @Override
    public List<Usuario> listarUsuario() {
        cn = Conexao.getConnection();
        
        List<Usuario> usuarios = new ArrayList<>();
        
        String sql = "select * from usuario c";
       
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setNick(rs.getString("nick"));
                user.setSenha(rs.getString("senha"));
                user.setEmail(rs.getString("email"));
                user.setTipo(rs.getString("tipo"));
                usuarios.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public void editarUsuario(Usuario u) {
        cn = Conexao.getConnection();
        
        String sql = "UPDATE usuario SET nome = ?, nick =?, senha=? where id = ?";
        
        try {
            PreparedStatement pst = null;
            pst = cn.prepareStatement(sql);
            pst.setString(1, u.getNome());
            pst.setString(2, u.getNick());
            pst.setString(3, u.getSenha());
            pst.setInt(4, (int) u.getId());
            pst.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,
                    null, e);
            throw new RuntimeException(e);
        }
    }

}
