package com.eduardo.leandro.windowautomation.datamodel;

public class HistoricoDataModel {

    private final static String TABELA = "historico";

    private final static String id = "id";
    private final static String datetime = "datetime";
    private final static String status = "status";

    private static String queryCriarTabela = "";
    private static String queryExcluirTabela = "";


    public static String criarTabela() {

        queryCriarTabela += "CREATE TABLE " + TABELA;
        queryCriarTabela += "(";
        queryCriarTabela += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += datetime + " TEXT, ";
        queryCriarTabela += status + " TEXT ";
        queryCriarTabela += ")";

        return queryCriarTabela;
    }

    public static String excluirTabela() {

        queryExcluirTabela += "DROP TABLE IF EXISTS" +TABELA;

        return queryExcluirTabela;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getId() {
        return id;
    }

    public static String getDatetime() {
        return datetime;
    }

    public static String getStatus() {
        return status;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        HistoricoDataModel.queryCriarTabela = queryCriarTabela;
    }

    public static String getQueryExcluirTabela() {
        return queryExcluirTabela;
    }

    public static void setQueryExcluirTabela(String queryExcluirTabela) {
        HistoricoDataModel.queryExcluirTabela = queryExcluirTabela;
    }
}
