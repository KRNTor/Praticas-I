/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.dao;

import br.com.praticas.util.Conexao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author RicksonEllen
 */
public class DaoGeneric {
    private Connection con;
    
    public Connection getConexao() throws SQLException{
        if(this.con == null || this.con.isClosed()){
            this.con = Conexao.getConnection();
            this.con.setAutoCommit(false);
        }
        return this.con;
    } 
    
    public void fecharConexao(){
        Conexao.closeConnection();
    }
}
