/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.dao;

import br.com.praticas.facade.Facade;
import br.com.praticas.interfaces.PerguntaInterface;
import br.com.praticas.model.Area;
import br.com.praticas.model.Pergunta;
import br.com.praticas.util.PropertiesUtils;
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
 * @author Sidney
 */
public class DaoPergunta extends DaoGeneric implements PerguntaInterface {

    @Override
    public void salvarPergunta(Pergunta p) throws Exception {
        String sql = "insert into pergunta (questao, nivel, id_area) values (?, ?, ?)";

        try {
            PreparedStatement pst = this.getConexao().prepareStatement(sql);
            pst.setString(1, p.getQuestao());
            pst.setString(2, p.getNivel());
            pst.setLong(3, p.getArea().getId());
            pst.executeUpdate();
            this.getConexao().commit();
            this.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(DaoPergunta.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(PropertiesUtils.getMsgValue(PropertiesUtils.MSG_ERRO_ADD_QUESTION));
        }
    }

    @Override
    public boolean verificarPergunta(String nome) throws Exception {
        String sql = "select * from pergunta";
        try {
            PreparedStatement pst = this.getConexao().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString("questao").equalsIgnoreCase(nome)) {
                    this.fecharConexao();
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPergunta.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(PropertiesUtils.getMsgValue(PropertiesUtils.MSG_ERRO_SEARCH_QUESTION));
        }
        return false;
    }

    @Override
    public Pergunta buscarPergunta(String nome) throws Exception {
        String sql = "select * from pergunta";
        try {
            PreparedStatement pst = this.getConexao().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString("questao").equalsIgnoreCase(nome)) {
                    Pergunta p = new Pergunta();
                    p.setId(rs.getInt("id"));
                    p.setQuestao(rs.getString("questao"));
                    p.setNivel(rs.getString("nivel"));
                    Area area = new DaoArea().buscarArea(rs.getLong("id_area"));
                    p.setArea(area);
                    System.out.println(p.toString());
                    this.fecharConexao();
                    return p;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPergunta.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(PropertiesUtils.getMsgValue(PropertiesUtils.MSG_ERRO_SEARCH_QUESTION));
        }
        return null;
    }

    @Override
    public Pergunta buscarPergunta(long id) throws Exception {
        String sql = "select * from pergunta";
        try {
            PreparedStatement pst = this.getConexao().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (Long.valueOf(rs.getString("id")) == id) {
                    Pergunta p = new Pergunta();
                    p.setId(rs.getInt("id"));
                    p.setQuestao(rs.getString("questao"));
                    p.setNivel(rs.getString("nivel"));
                    Area area = new DaoArea().buscarArea(rs.getLong("id_area"));
                    p.setArea(area);
                    this.fecharConexao();
                    return p;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPergunta.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(PropertiesUtils.getMsgValue(PropertiesUtils.MSG_ERRO_SEARCH_QUESTION));
        }
        return null;
    }

    @Override
    public List<Pergunta> listarPergunta() throws Exception {
        List<Pergunta> perguntas = new ArrayList<>();
        String sql = "select * from pergunta";
        try {
            PreparedStatement pst = this.getConexao().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Pergunta p = new Pergunta();
                p.setId(rs.getInt("id"));
                p.setQuestao(rs.getString("questao"));
                p.setNivel(rs.getString("nivel"));
                p.getArea().setId(rs.getInt("id_area"));
                perguntas.add(p);
            }
            this.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(DaoPergunta.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(PropertiesUtils.getMsgValue(PropertiesUtils.MSG_ERRO_LIST_QUESTION));
        }
        return perguntas;
    }

    @Override
    public void removerPergunta(Pergunta p) throws Exception {
        String sql = "DELETE FROM pergunta p where p.id = ?";
        try {
            PreparedStatement pst = this.getConexao().prepareStatement(sql);
            pst.setLong(1, p.getId());
            pst.executeUpdate();
            this.getConexao().commit();
            this.fecharConexao();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(PropertiesUtils.getMsgValue(PropertiesUtils.MSG_ERRO_DELETE));
        }
    }

    public void editarPergunta(Pergunta p) throws Exception {
        String sql = "UPDATE pergunta SET questao = ?, nivel =? where id = ?";
        try {
            PreparedStatement pst = getConexao().prepareStatement(sql);
            pst.setString(1, p.getQuestao());
            pst.setString(2, p.getNivel());
            pst.setInt(3, (int) p.getId());
            pst.executeUpdate();
            this.getConexao().commit();
            this.fecharConexao();
        } catch (SQLException e) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,
                    null, e);
            throw new RuntimeException(PropertiesUtils.getMsgValue(PropertiesUtils.MSG_ERRO_UPDATE));
        }
    }
}
