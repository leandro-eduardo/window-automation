package com.eduardo.leandro.windowautomation.controller;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;

import com.eduardo.leandro.windowautomation.datamodel.HistoricoDataModel;
import com.eduardo.leandro.windowautomation.datasource.DataSource;
import com.eduardo.leandro.windowautomation.model.Historico;

import java.security.AccessControlContext;
import java.util.List;

public class HistoricoController extends DataSource{

    ContentValues dados;

    public HistoricoController(Context context) {
        super(context);
    }



    public  boolean inserir(Historico obj) {

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(HistoricoDataModel.getDatetime(), obj.getDatetime());
        dados.put(HistoricoDataModel.getStatus(), obj.getStatus());

        sucesso = insert(HistoricoDataModel.getTABELA(), dados);

        return sucesso;
    }

    public List<Historico> consultar() {
        return  getAllHistorico();
    }


}
