package com.example.pablo.prueba7;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pablo.prueba7.Adapters.trabajos_adapter_result;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Post.RecibiAparato;
import com.example.pablo.prueba7.Request.Request;

import org.json.JSONException;


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
    RecibiAparato rec=new RecibiAparato();
    public Trabajos() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSaveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trabajos, container, false);

        trabajos=view.findViewById(R.id.listTrabajos);


        ////////////////////////////////////////
        //trabajos.setAdapter(null);
        // TrabajosAdapter trabadapt=new TrabajosAdapter();
        // trabajos.setAdapter(trabadapt);    //Asignacion del adapatador a la listView

        adaptertrabajos =new trabajos_adapter_result(getActivity().getApplicationContext(),Array.trabajox,Array.accionx,Array.recibix);
        //trabajos.setAdapter(adaptertrabajos);    //Asignacion del adapatador a la listView

        //////////////////////////////////////////



        return view;
    }
    ///////////////////Adaptador Trabajos//////////////////////////

}
///////////////////////////////////////////////

