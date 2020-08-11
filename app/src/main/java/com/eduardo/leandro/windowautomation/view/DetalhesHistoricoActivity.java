package com.eduardo.leandro.windowautomation.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.eduardo.leandro.windowautomation.R;
import com.eduardo.leandro.windowautomation.adapter.HistoryAdapter;
import com.eduardo.leandro.windowautomation.controller.HistoricoController;

public class DetalhesHistoricoActivity extends AppCompatActivity {

    private final String TAG = "DetalhesHistoricoActivity";


    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_detalhes_historico);

        Log.i(TAG, "onCreate");

        getIncomingIntent();

    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("itemTitle") && getIntent().hasExtra("itemDetail")){
            String itemTitle = getIntent().getStringExtra("itemTitle");
            String itemDetail = getIntent().getStringExtra("itemDetail");

            setDetails(itemTitle, itemDetail);
        }
    }


    private void setDetails(String itemTitle, String itemDetail) {

        TextView descricao = findViewById(R.id.item_title);
        TextView datatime = findViewById(R.id.item_detail);

        descricao.setText(itemTitle);
        datatime.setText(itemDetail);

    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

}
