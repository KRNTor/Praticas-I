/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.dao;

import br.com.praticas.factory.Conexao;
import br.com.praticas.interfaces.InterfaceAlternativa;
import br.com.praticas.model.Alternativa;
import br.com.praticas.model.Pergunta;
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
 * @author Felipe
 */
public class AlternativaDao implements InterfaceAlternativa {

    @Override
    public long salvarAlternativa(Alternativa a) throws Exception {
        long resultado = -1;
        String sql = "insert into alternativa (alt1, alt2, alt3, alt4, alt5, altcorreta, id_pergunta) values (?, ?, ?, ?, ?, ?, ?);";
        Connection cn;
        
        System.out.println("teste");

        try {
            cn = Conexao.getConnection();

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, a.getAlt1());
            pst.setString(2, a.getAlt2());
            pst.setString(3, a.getAlt3());
            pst.setString(4, a.getAlt4());
            pst.setString(5, a.getAlt5());
            pst.setString(6, a.getAltCorreta());
            pst.setInt(7, (int) a.getPergunta().getId());
            pst.executeUpdate();

            try (ResultSet rs = pst.getGeneratedKeys()) {
                if (rs.next()) {
                    resultado = rs.getLong(1);
                }
            }
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            resultado = -1;
            Logger.getLogger(PerguntaDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("ERRO AO SALVAR ALTERNATIVAS");
        }
        return resultado;
    }

    @Override
    public List<Alternativa> listar() {
        List<Alternativa> alternativas = new ArrayList<>();
        String sql = "select * from alternativa";
        Connection cn;
        try {
            cn = Conexao.getConnection();

            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Alternativa alternativa = new Alternativa();
                alternativa.setId(rs.getInt("id"));
                alternativa.setAlt1(rs.getString("alt1"));
                alternativa.setAlt2(rs.getString("alt2"));
                alternativa.setAlt3(rs.getString("alt3"));
                alternativa.setAlt4(rs.getString("alt4"));
                alternativa.setAlt5(rs.getString("alt5"));
                alternativa.setAltCorreta(rs.getString("altcorreta"));
                Pergunta p = new PerguntaDao().buscarPergunta(rs.getInt("id_pergunta"));
                alternativa.setPergunta(p);
                alternativas.add(alternativa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alternativas;
    }
}
