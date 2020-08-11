package com.eduardo.leandro.windowautomation.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.eduardo.leandro.windowautomation.R;
import com.eduardo.leandro.windowautomation.controller.HistoricoController;
import com.eduardo.leandro.windowautomation.model.Historico;
import com.eduardo.leandro.windowautomation.util.OpenedClosedAux;
import com.eduardo.leandro.windowautomation.view.AcelerometroActivity;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private final String TAG = "HomeFragment";

    OpenedClosedAux openedClosedAux = new OpenedClosedAux(0);

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");

    Historico historico;
    HistoricoController controller;
    Context context;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        context = getContext();
        Log.i(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(TAG, "onCreateView");

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        final ImageButton button = view.findViewById(R.id.button_open_close);
        final TextView textView = view.findViewById(R.id.status);

        final Switch homeSwitch = view.findViewById(R.id.home_switch);


        if (openedClosedAux.getValor() == 0) {
            button.setImageResource(R.drawable.ic_lock_open);
            textView.setText(R.string.closed);
        } else {
            button.setImageResource(R.drawable.ic_lock_outline);
            textView.setText(R.string.opened);
        }

        homeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (homeSwitch.isChecked()){
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }
            }
        });


        historico = new Historico();
        controller = new HistoricoController(context);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (openedClosedAux.getValor() == 0) {
                    button.setImageResource(R.drawable.ic_lock_outline);
                    textView.setText(R.string.opened);
                    openedClosedAux.setValor(1);
                    Toast.makeText(getContext(), "A janela foi aberta!", Toast.LENGTH_SHORT).show();

                    Date date = new Date();
                    String dateTime = dateFormat.format(date);
                    historico.setDatetime(dateTime.toString());
                    historico.setStatus("Aberta");
                    controller.inserir(historico);

                    Log.i("DATA", "DATA E HORA:   " + dateTime);

                } else {
                    button.setImageResource(R.drawable.ic_lock_open);
                    textView.setText(R.string.closed);
                    openedClosedAux.setValor(0);
                    Toast.makeText(getContext(), "A janela foi fechada!", Toast.LENGTH_SHORT).show();

                    Date date = new Date();
                    String dateTime = dateFormat.format(date);
                    historico.setDatetime(dateTime.toString());
                    historico.setStatus("Fechada");
                    controller.inserir(historico);

                    Log.i("DATA", "DATA E HORA:   " + dateTime);
                }
            }
        });

        return view;
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
        inflater.inflate(R.menu.menu_fragment_home, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection

        switch (item.getItemId()) {
            case R.id.sensor:
                Intent vaiParaSensorAcelerometro = new Intent(getContext(), AcelerometroActivity.class);
                startActivity(vaiParaSensorAcelerometro);
            return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
