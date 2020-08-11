package com.eduardo.leandro.windowautomation.fragments;

import android.content.Context;
import android.content.DialogInterface;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import com.eduardo.leandro.windowautomation.R;
import com.eduardo.leandro.windowautomation.adapter.HistoryAdapter;
import com.eduardo.leandro.windowautomation.controller.HistoricoController;


public class HistoryFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    private final String TAG = "HistoryFragment";

    RecyclerView recyclerView;
    HistoryAdapter adapter;
    SwipeRefreshLayout mSwipeRefreshLayout;
    HistoricoController controller;
    Context context;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        setHasOptionsMenu(true);
        Log.i(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler_view, container, false);

        recyclerView = view.findViewById(R.id.list_historico);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        final HistoricoController controller = new HistoricoController(getContext());
        adapter = new HistoryAdapter(controller.consultar(), context);
        recyclerView.setAdapter(adapter);


        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                R.color.colorPrimaryDark,
                R.color.colorPrimary
        );

        return view;
    }

    @Override
    public void onRefresh() {
        loadRecyclerViewData();
    }

    public void loadRecyclerViewData() {

        mSwipeRefreshLayout.postDelayed(new Runnable() {
            //
            @Override
            public void run() {

                mSwipeRefreshLayout.setRefreshing(true);
                HistoricoController controller = new HistoricoController(getContext());
                adapter = new HistoryAdapter(controller.consultar(), context);
                recyclerView.setAdapter(adapter);
                mSwipeRefreshLayout.setRefreshing(false);
                Toast.makeText(getContext(), R.string.data_updated, Toast.LENGTH_SHORT).show();

            }
        }, 2500);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_fragment_history, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection

        switch (item.getItemId()) {
            case R.id.delete_history:
                AlertDialog.Builder msgBox = new AlertDialog.Builder(getContext());
                msgBox.setTitle(R.string.deleting);
                msgBox.setIcon(android.R.drawable.ic_menu_delete);
                msgBox.setMessage(R.string.delete_confirmation);
                msgBox.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        controller = new HistoricoController(context);
                        controller.delete();
                        Toast.makeText(getActivity(), R.string.delete_successful_message, Toast.LENGTH_LONG).show();
                    }
                });
                msgBox.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                msgBox.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}