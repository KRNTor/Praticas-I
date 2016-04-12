/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.dao;

import br.com.praticas.factory.Conexao;
import br.com.praticas.interfaces.InterfaceArea;
import br.com.praticas.model.Area;
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
public class AreaDao implements InterfaceArea {

    @Override
    public void salvarArea(Area a) throws Exception {
        try {
            String sql = "insert into area (nome) values (?)";
            Connection cn;
            if (!verificarArea(a.getAreaNome())) {
                cn = Conexao.getConnection();

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, a.getAreaNome());
                pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("ERRO AO CADASTRAR AREA");
        }
    }

    @Override
    public boolean verificarArea(String areaNome) throws Exception {
        Area a = null;
        String sql = "select * from area";
        Connection cn;
        try {
            cn = Conexao.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString("nome").equalsIgnoreCase(areaNome)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,
                    null, e);
            throw new Exception("ERRO AO ENCONTRAR AREA");
        }
        return false;
    }

    @Override
    public Area buscarArea(String areaNome) throws Exception {
        Area a = null;
        String sql = "select * from area";
        Connection cn;
        try {
            cn = Conexao.getConnection();

            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString("nome").equalsIgnoreCase(areaNome)) {
                    a = new Area();
                    a.setId(rs.getInt("id"));
                    a.setAreaNome(rs.getString("nome"));
                    return a;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,
                    null, e);
            throw new Exception("ERRO AO BUSCAR AREA");
        }
        return null;
    }

    @Override
    public List<Area> listarArea() throws Exception{
        List<Area> areas = new ArrayList<>();
        String sql = "select * from area";
        Connection cn;
        try {
            cn = Conexao.getConnection();

            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Area area = new Area();
                area.setId(rs.getLong("id"));
                area.setAreaNome(rs.getString("nome"));
                areas.add(area);
            }
        } catch (SQLException e) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,
                    null, e);
            throw new Exception("ERRO AO LISTAR PERGUNTAS");
        }
        return areas;
    }

    @Override
    public void removerArea(Area a) throws Exception {
        String sql = "delete from area a where a.id = ?";
        Connection cn;
        try {
            cn = Conexao.getConnection();

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, (int)a.getId());
            pst.executeUpdate();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("ERRO AO REMOVER AREA");
        }
    }
    
     public void editarArea(Area a) {
        String sql = "UPDATE area SET nome = ? where id = ?";
        Connection cn;
        try {
            cn = Conexao.getConnection();

            PreparedStatement pst = null;
            pst = cn.prepareStatement(sql);
            pst.setString(1, a.getAreaNome());
            pst.setInt(2, (int)a.getId());
            pst.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,
                    null, e);
            throw new RuntimeException(e);
        }
    }

}
