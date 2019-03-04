package com.example.pablo.prueba7.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pablo.prueba7.Adapters.trabajos_adapter_result;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;

import static com.example.pablo.prueba7.Listas.Array.recibix;


/**
 * A simple {@link Fragment} subclass.
 */
public class Trabajos extends Fragment{
    RelativeLayout layoutAnimado;
    Request request = new Request();
    public static TextView trabajo;
    public static Button accion;
    public static trabajos_adapter_result adaptertrabajos;
    public static ListView trabajos;
    private LayoutInflater inflater;
    private ViewGroup container;
    private Bundle onsavedInstanceState;


    public Trabajos() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle OnsavedInstanceState) {

        this.inflater = inflater;
        this.container = container;
        onsavedInstanceState = OnsavedInstanceState;


        View view = inflater.inflate(R.layout.fragment_trabajos, container, false);
        trabajos=view.findViewById(R.id.listTrabajos);
        adaptertrabajos = new trabajos_adapter_result(getContext(), Array.trabajox, Array.accionx, recibix);
        trabajos.setAdapter(adaptertrabajos);
        return view;
    }
}

