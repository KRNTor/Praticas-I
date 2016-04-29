/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.dao;

import br.com.praticas.interfaces.InterfaceHistoricoJogador;
import br.com.praticas.model.Alternativa;
import br.com.praticas.model.HistoricoJogador;
import br.com.praticas.model.Pergunta;
import br.com.praticas.model.Usuario;
import br.com.praticas.util.Conexao;
import br.com.praticas.util.PropertiesUtils;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sidney
 */
public class HistoricoJogadorDao implements InterfaceHistoricoJogador {

    @Override
    public void salvarHistoricoJogador(HistoricoJogador h, Pergunta p, Usuario u) throws Exception {
        String sql = "insert into historicoJogador (perguntascertas, perguntasrespondidas, id_usuario, id_pergunta ) values(?, ?, ?, ?);";
        Connection cn;

        cn = Conexao.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, h.getPerguntasCertas());
            pst.setInt(2, h.getPerguntasRespondidas());
            pst.setLong(3, u.getId());
            pst.setLong(4, p.getId());
            pst.executeUpdate();
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,
                    null, e);
            throw new Exception("ERRO AO CADASTRAR HISTORICO DO JOGADOR");
        }
    }

    public HistoricoJogador buscarHistorico(long id) throws Exception {
        String sql = "select * from historicoJogador where id = ?";
        Connection cn;

        cn = Conexao.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            HistoricoJogador hisJog = new HistoricoJogador();
            hisJog.setPerguntasCertas(rs.getInt("perguntascertas"));
            hisJog.setPerguntasRespondidas(rs.getInt("perguntasrespondidas"));
            return hisJog;
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,
                    null, e);
            throw new Exception("ERRO AO BUSCAR HISTORICO DO JOGADOR");
        }
        
    }

    

    
    public void atualizarHistorico(Usuario u, Pergunta p, HistoricoJogador h) throws Exception {
        String sql = "UPDATE historicojogador SET perguntascertas = ?, perguntasrespondidas = ?,  ";
        Connection cn;

        cn = Conexao.getConnection();
        long id_pergunta = salvarPergunta(p);

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, h.getPerguntasCertas() + 1);
            pst.setInt(2, h.getPerguntasRespondidas() + 1);

        } catch (SQLException e) {
            Logger.getLogger(PerguntaDao.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception(PropertiesUtils.getMsgValue(PropertiesUtils.MSG_ERRO_ADD_QUESTION));
        }

    }

    public void atualizarHistorico2(Usuario u, Pergunta p, HistoricoJogador h) throws Exception {
        String sql = "UPDATE historicojogador SET perguntasrespondidas = ?,  ";
        Connection cn;

        cn = Conexao.getConnection();

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, h.getPerguntasRespondidas() + 1);

        } catch (SQLException e) {
            Logger.getLogger(PerguntaDao.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception(PropertiesUtils.getMsgValue(PropertiesUtils.MSG_ERRO_ADD_QUESTION));
        }

    }

    public long salvarPergunta(Pergunta p) throws Exception {
        String sql = "insert into perguntahistorico  (questao, nivel, id_area) values (?, ?, ?);";
        Connection cn;

        try {
            cn = Conexao.getConnection();

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, p.getQuestao());
            pst.setString(2, p.getNivel());
            pst.setInt(3, (int) p.getArea().getId());
            pst.executeUpdate();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PerguntaDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(PropertiesUtils.getMsgValue(PropertiesUtils.MSG_ERRO_ADD_QUESTION));
        }
        return p.getId();
    }

}
