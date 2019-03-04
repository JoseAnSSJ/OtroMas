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
    public Trabajos() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSaveInstanceState) {
        super.onActivityCreated(onSaveInstanceState);
        View view = inflater.inflate(R.layout.fragment_trabajos, container, false);

        trabajos=view.findViewById(R.id.listTrabajos);


        ////////////////////////////////////////
        //trabajos.setAdapter(null);
        // TrabajosAdapter trabadapt=new TrabajosAdapter();
        // trabajos.setAdapter(trabadapt);    //Asignacion del adapatador a la listView

        adaptertrabajos = new trabajos_adapter_result(getContext(), Array.trabajox, Array.accionx, recibix);

        //////////////////////////////////////////

        return view;
    }
    ///////////////////Adaptador Trabajos//////////////////////////

}
///////////////////////////////////////////////

