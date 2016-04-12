/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.dao;

import br.com.praticas.factory.Conexao;
import br.com.praticas.interfaces.InterfaceAlternativa;
import br.com.praticas.model.Alternativa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

}
