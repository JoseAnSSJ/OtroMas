package com.example.pablo.prueba7;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pablo.prueba7.Adapters.trabajos_adapter_result;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetBUSCADetOrdSerListResult;
import com.example.pablo.prueba7.Post.RecibiAparato;
import com.example.pablo.prueba7.Request.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

import static com.example.pablo.prueba7.Adapters.ordenes_adapter_result.clvor;
import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.Clave;
import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.clvTra;
import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.descr;
import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.stat;
import static com.example.pablo.prueba7.Listas.Array.recibix;
import static com.example.pablo.prueba7.Post.RecibiAparato.jsonObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class Trabajos extends Fragment {
    RelativeLayout layoutAnimado;
    Request request = new Request();
    public static TextView trabajo;
    public static Button accion;
    public static trabajos_adapter_result adaptertrabajos;
    public static ListView trabajos;
    public static Integer conta;
    CheckBox recibiap;

    public Trabajos() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSaveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trabajos, container, false);

        trabajos = view.findViewById(R.id.listTrabajos);
        accion = view.findViewById(R.id.send);
        recibiap = view.findViewById(R.id.recibiap);


        accion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    adaptertrabajos.norec();
                   request.send_aparat();
            }
        });

        adaptertrabajos = new trabajos_adapter_result(getActivity().getApplicationContext(), Array.trabajox, Array.accionx, recibix);
        //trabajos.setAdapter(adaptertrabajos);    //Asignacion del adapatador a la listView

        //////////////////////////////////////////


        return view;
    }
    ///////////////////Adaptador Trabajos//////////////////////////

}
///////////////////////////////////////////////

