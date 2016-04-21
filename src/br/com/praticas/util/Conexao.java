package br.com.praticas.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Felipe
 */
public class Conexao {

    /**
     *
     * @return retorna a conexao com a database
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtils.getConfigValue(PropertiesUtils.URL),
                    PropertiesUtils.getConfigValue(PropertiesUtils.USERNAME),
                    PropertiesUtils.getConfigValue(PropertiesUtils.PASSWORD));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
