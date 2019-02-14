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
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.NoEntregadosModel;
import com.example.pablo.prueba7.Request.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Trabajos extends Fragment{
    public static JSONObject NoEntregadosObject = new JSONObject();
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

       /* trabajos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Iterator<List<NoEntregadosModel>> itData = array.dataNoent.iterator();
                List<NoEntregadosModel> dat = (List<NoEntregadosModel>) itData.next();
                for(int a=0; a<dat.size(); a++ ){
                    try {
                        NoEntregadosObject = new JSONObject();
                        NoEntregadosObject.put("Clave", dat.get(a).getClave());
                        NoEntregadosObject.put("Clv_Orden", dat.get(a).getClvOrden());
                        NoEntregadosObject.put("Clv_Trabajo", dat.get(a).getClvTrabajo());
                        NoEntregadosObject.put("Descripcion", dat.get(a).getDescripcion());
                        NoEntregadosObject.put("Obs", dat.get(a).getDescripcion());
                        NoEntregadosObject.put("SeRealiza", dat.get(a).getSeRealiza());
                        NoEntregadosObject.put("recibi", dat.get(a).getRecibi());

                        NoEntregadosArray.put(a,NoEntregadosObject);



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        });*/



        return view;
    }

}
