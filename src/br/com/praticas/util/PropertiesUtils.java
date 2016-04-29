package br.com.praticas.util;

import java.util.ResourceBundle;

/**
 *
 * @author Felipe
 */
public class PropertiesUtils {

    private static final String FILE_CONFIG = "br\\com\\praticas\\properties/config";
    private static final String FILE_MSG = "br\\com\\praticas\\properties/msg";
    private static final ResourceBundle resConfig = ResourceBundle.getBundle(FILE_CONFIG);
    private static final ResourceBundle resMsg = ResourceBundle.getBundle(FILE_MSG);

    public static final String URL = "jdbc.url";
    public static final String USERNAME = "jdbc.username";
    public static final String PASSWORD = "jdbc.password";
    public static final String CLOSECONNECTION = "jdbc.closeConnection";

    //MSG USER
    public static final String MSG_ERRO_ADD_USER = "msg.error.add_user";
    public static final String MSG_ERRO_SEARCH_USER = "msg.error.search_user";
    public static final String MSG_ERRO_UPDATE_USER = "msg.error.update_user";
    public static final String MSG_ERRO_DELETE_USER = "msg.error.delete_user";
    public static final String MSG_ERRO_LIST_USER = "msg.error.list_user";
    public static final String MSG_SUCCEED_ADD_USER = "msg.succeed.add_user";
    public static final String MSG_SUCCEED_SEARCH_USER = "msg.succeed.search_user";
    public static final String MSG_SUCCEED_UPDATE_USER = "msg.succeed.update_user";
    public static final String MSG_SUCCEED_DELETE_USER = "msg.succeed.delete_user";
    public static final String MSG_SUCCEED_LIST_USER = "msg.succeed.list_user";
    //MSG QUESTION
    public static final String MSG_ERRO_ADD_QUESTION = "msg.error.add_question";
    public static final String MSG_ERRO_SEARCH_QUESTION = "msg.error.search_question";
    public static final String MSG_ERRO_UPDATE_QUESTION = "msg.error.update_question";
    public static final String MSG_ERRO_DELETE_QUESTION = "msg.error.delete_question";
    public static final String MSG_ERRO_LIST_QUESTION = "msg.error.list_question";
    public static final String MSG_SUCCEED_ADD_QUESTION = "msg.succeed.add_question";
    public static final String MSG_SUCCEED_SEARCH_QUESTION = "msg.succeed.search_question";
    public static final String MSG_SUCCEED_UPDATE_QUESTION = "msg.succeed.update_question";
    public static final String MSG_SUCCEED_DELETE_QUESTION = "msg.succeed.delete_question";
    public static final String MSG_SUCCEED_LIST_QUESTION = "msg.succeed.list_question";
    //MSG AREA
    public static final String MSG_ERRO_ADD_AREA = "msg.error.add_area";
    public static final String MSG_ERRO_ADD_AREA_DUPLICATE = "msg.error.add_area_duplicate";
    public static final String MSG_ERRO_SEARCH_AREA = "msg.error.search_area";
    public static final String MSG_ERRO_UPDATE_AREA = "msg.error.update_area";
    public static final String MSG_ERRO_DELETE_AREA = "msg.error.delete_area";
    public static final String MSG_ERRO_LIST_AREA = "msg.error.list_area";
    public static final String MSG_SUCCEED_ADD_AREA = "msg.succeed.add_area";
    public static final String MSG_SUCCEED_SEARCH_AREA = "msg.succeed.search_area";
    public static final String MSG_SUCCEED_UPDATE_AREA = "msg.succeed.update_area";
    public static final String MSG_SUCCEED_DELETE_AREA = "msg.succeed.delete_area";
    public static final String MSG_SUCCEED_LIST_AREA = "msg.succeed.list_area";
    //MSG ALTERNATIVE
    public static final String MSG_ERRO_ADD_ALTERNATIVE = "msg.error.add_alternative";
    public static final String MSG_ERRO_SEARCH_ALTERNATIVE = "msg.error.search_alternative";
    public static final String MSG_ERRO_UPDATE_ALTERNATIVE = "msg.error.update_alternative";
    public static final String MSG_ERRO_DELETE_ALTERNATIVE = "msg.error.delete_alternative";
    public static final String MSG_ERRO_LIST_ALTERNATIVE = "msg.error.list_alternative";
    public static final String MSG_SUCCEED_ADD_ALTERNATIVE = "msg.succeed.add_alternative";
    public static final String MSG_SUCCEED_SEARCH_ALTERNATIVE = "msg.succeed.search_alternative";
    public static final String MSG_SUCCEED_UPDATE_ALTERNATIVE = "msg.succeed.update_alternative";
    public static final String MSG_SUCCEED_DELETE_ALTERNATIVE = "msg.succeed.delete_alternative";
    public static final String MSG_SUCCEED_LIST_ALTERNATIVE = "msg.succeed.list_alternative";
    //MSG HISTORICO
    public static final String MSG_ERRO_ADD_HISTORICO = "msg.error.add_historico";
    public static final String MSG_ERRO_SEARCH_HISTORICO = "msg.error.search_historico";
    public static final String MSG_ERRO_UPDATE_HISTORICO = "msg.error.update_historico";

    /*
    *
    * @return retorna chave do arquivo Properties de configuraçoes
     */

    public static String getConfigValue(String key) {
        return resConfig.getString(key);
    }

    /*
    *
    * @return retorna chave do arquivo Properties de mensagens
     */
    public static String getMsgValue(String key) {
        return resMsg.getString(key);
    }

}
