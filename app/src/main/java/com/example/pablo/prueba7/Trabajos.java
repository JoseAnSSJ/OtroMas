package com.example.pablo.prueba7;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.NoEntregadosModel;
import com.example.pablo.prueba7.Request.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

import static com.example.pablo.prueba7.Adapters.ordenes_adapter_result.clvor;
import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.ClaveTrabajo;
import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.claveTra;
import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.statusv;
import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.trabajoq;


/**
 * A simple {@link Fragment} subclass.
 */
public class Trabajos extends Fragment{
    public static JSONObject NoEntregadosObject;
    public static JSONArray NoEntregadosArray=new JSONArray();
    Array array=new Array();
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
        View view = inflater.inflate(R.layout.fragment_trabajos, container, false);

        trabajos=view.findViewById(R.id.listTrabajos);
        accion=view.findViewById(R.id.send);

//////////////
        adaptertrabajos =new trabajos_adapter_result(getActivity().getApplicationContext(),Array.trabajox,Array.accionx);



        //trabajos.setAdapter(adaptertrabajos);    //Asignacion del adapatador a la listView
/////////////

        accion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iterator<List<NoEntregadosModel>> itData = array.dataNoent.iterator();
                List<NoEntregadosModel> dat = (List<NoEntregadosModel>) itData.next();
          //     for(int a=0; a<Array.dataTrabajos.size(); a++ ){
                    try {
                        NoEntregadosObject = new JSONObject();
                        NoEntregadosObject.put("Clave", ClaveTrabajo);
                        NoEntregadosObject.put("Clv_Orden", clvor);
                        NoEntregadosObject.put("Clv_Trabajo", claveTra);
                        NoEntregadosObject.put("Descripcion",trabajoq );
                        NoEntregadosObject.put("Obs", null);
                        NoEntregadosObject.put("SeRealiza", true);
                        NoEntregadosObject.put("recibi",true);

                        NoEntregadosArray.put(NoEntregadosObject);



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                   //  }




            }
        });



        return view;
    }

}
