package com.eduardo.leandro.windowautomation.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.eduardo.leandro.windowautomation.datamodel.HistoricoDataModel;
import com.eduardo.leandro.windowautomation.model.Historico;

import java.util.ArrayList;
import java.util.List;

public class DataSource extends SQLiteOpenHelper {

    private static final String DB_NAME = "historico.sqlite";
    private static final int DB_VERSION = 1;


    Cursor cursor;
    SQLiteDatabase db;

    public DataSource(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            db.execSQL(HistoricoDataModel.criarTabela());

        } catch (Exception e) {

            Log.e("Historico", "DB ------> ESTÁ COM ERRO");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(HistoricoDataModel.excluirTabela());
        onCreate(db);
    }

    public boolean insert(String tabela, ContentValues dados) {

        boolean sucesso = true;
        try {
            sucesso = db.insert(tabela, null, dados) > 0;

        } catch (Exception e) {
            sucesso = false;
        }

        return sucesso;
    }

    public void delete() {
        db.delete("historico", null, null);
    }


    public List<Historico> getAllHistorico() {

        Historico obj;

        List<Historico> lista = new ArrayList<>();

        String sql = " SELECT * FROM " + HistoricoDataModel.getTABELA() + " ORDER BY datetime DESC";

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new Historico();
                obj.setId(cursor.getInt(cursor.getColumnIndex(HistoricoDataModel.getId())));
                obj.setDatetime(cursor.getString(cursor.getColumnIndex(HistoricoDataModel.getDatetime())));
                obj.setStatus(cursor.getString(cursor.getColumnIndex(HistoricoDataModel.getStatus())));

                lista.add(obj);

            } while (cursor.moveToNext());

        }

        cursor.close();

        return lista;

    }


}
