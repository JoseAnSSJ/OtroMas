package com.example.pablo.prueba7;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.pablo.prueba7.Adapters.ordenes_adapter_result.clvor;
import com.example.pablo.prueba7.Adapters.Arbol_Adapter;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.children;
import com.example.pablo.prueba7.Request.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;


public class asignacion extends AppCompatActivity {
Array array = new Array();
Request request = new Request();

    public static Button siguiente, eliminar, aceptarAsignacion,eliminarAparato, cancelarAsigancion;
    public static  Button aceptarmedio,cancelarmedio;
    public static ListView Asignacion;
    public static Spinner spinnerMedio;
    public static RelativeLayout layoutMedio;


int c,d,e;
String f;



    public static JSONArray jsonArray = new JSONArray();
    public static JSONArray jsonArray2 = new JSONArray();
    public static JSONArray jsonArray3 = new JSONArray();
    public static JSONObject jsonObject2 = new JSONObject();
    public static JSONObject jsonObject3 = new JSONObject();
    public static JSONObject jsonObject4 = new JSONObject();


    public static Arbol_Adapter adapter;


    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_asignacion);
        siguiente= findViewById(R.id.siguiente);

        Asignacion = findViewById(R.id.Asignacion);
        eliminar = findViewById(R.id.eliminar);
        eliminarAparato = findViewById(R.id.eliminarAparatos);
        aceptarmedio = findViewById(R.id.aceptarMedio);
        cancelarmedio = findViewById(R.id.cancelarMedio);
        spinnerMedio = findViewById(R.id.spinnerMedio);
        aceptarAsignacion = findViewById(R.id.aceptarAsignacion);
        layoutMedio = findViewById(R.id.poiuyt);
        cancelarAsigancion = findViewById(R.id.cancelarAsignacion);

        adapter = new Arbol_Adapter(getApplicationContext());
        Asignacion.setAdapter(adapter);
        Asignacion.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData = array.dataArbSer.iterator();
                List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat = itData.next();
                for(int a=0; a<dat.size(); a++ ){
                    try {
                        jsonObject2 = new JSONObject();
                        jsonObject2.put("Clv_UnicaNet", dat.get(a).Clv_UnicaNet);
                        jsonObject2.put("idMedio", dat.get(a).IdMedio);
                        jsonArray.put(a,jsonObject2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Log.d("numero", String.valueOf(Arbol_Adapter.a));
                Intent intento=new Intent(asignacion.this,asignado.class);
                startActivity(intento);
                finish();

            }
        });
        Asignacion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("posision", String.valueOf(position));
            }
        });
aceptarAsignacion.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        for(int a=0; a<Array.dataArbSer.get(0).size(); a++){
            Array.dataArbSer.get(0).get(a).setClv_orden(clvor);
        }
        Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData = array.dataArbSer.iterator();
            List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat =  itData.next();

            for(int c=0; c<dat.size(); c++){
                jsonObject3 = new JSONObject();
                jsonArray3 = new JSONArray();
                try {
                    jsonObject3.put("BaseIdUser", dat.get(c).BaseIdUser);
                    jsonObject3.put("BaseRepoteIp", JSONObject.NULL);
                    jsonObject3.put("Clv_TipSer", dat.get(c).Clv_TipSer);
                    jsonObject3.put("Clv_UnicaNet", dat.get(c).Clv_UnicaNet);
                    jsonObject3.put("Contrato", JSONObject.NULL);
                    jsonObject3.put("Detalle", dat.get(c).Detalle);
                    jsonObject3.put("Expanded", dat.get(c).Expanded);
                    jsonObject3.put("IdMedio", dat.get(c).IdMedio);
                    jsonObject3.put("Nombre", dat.get(c).Nombre);
                    jsonObject3.put("Tipo", dat.get(c).Tipo);
                    jsonObject3.put("Type", dat.get(c).Type);
                    for(int b=0; b< dat.get(c).children.size(); b++){
                        jsonObject4 = new JSONObject();
                        jsonObject4.put("BaseIdUser",dat.get(c).children.get(b).baseIdUser);
                        jsonObject4.put("BaseRemoteIp",JSONObject.NULL);
                        jsonObject4.put("Clv_Aparato",dat.get(c).children.get(b).Clv_Aparato);
                        jsonObject4.put("Clv_UnicaNet",JSONObject.NULL);
                        jsonObject4.put("ContratoNet",dat.get(c).children.get(b).ContratoNet);
                        jsonObject4.put("Detalle",dat.get(c).children.get(b).Detalle);
                        jsonObject4.put("Nombre",dat.get(c).children.get(b).Nombre);
                        jsonObject4.put("Tipo",dat.get(c).children.get(b).Tipo);
                        jsonObject4.put("Type",dat.get(c).children.get(b).Type);
                        jsonArray3.put(b,jsonObject4);
                    }
                    jsonObject3.put("children", jsonArray3);
                    jsonObject3.put("clv_orden", dat.get(c).clv_orden);
                    jsonArray2.put(c, jsonObject3);
                    Toast.makeText(getApplicationContext(), "Espere", Toast.LENGTH_LONG).show();
                    request.getAceptatAsignacino(getApplicationContext());
                    finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(asignacion.this, "Error",Toast.LENGTH_LONG);
                }
            }



    }
});
eliminarAparato.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData = array.dataArbSer.iterator();
        List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat =  itData.next();

        while(Arbol_Adapter.DeletChildren.isEmpty()==false) {
            for (c = 0; c < dat.size(); c++) {
                f = String.valueOf(c);
                e = 0;
                if (dat.get(c).children != null) {
                    for (int d = 0; d < dat.get(c).children.size(); d++) {
                        String abc = dat.get(c).children.get(d).getClv_Aparato() + f;
                        try {


                            if (Integer.parseInt(abc) == (Arbol_Adapter.DeletChildren.get(0))) {
                                dat.get(c).children.remove(d);
                                Arbol_Adapter.DeletChildren.remove(0);
                            }
                        } catch (Exception x) {

                        }
                    }
                }

            }
        }
        ////////////
        for( c=0; c<dat.size(); c++) {
            f= String.valueOf(c);
            e=0;
            if(dat.get(c).IdMedio!=null&& dat.get(c).Detalle!=null) {
                    String abc = dat.get(c).IdMedio+dat.get(c).Detalle ;
                    try {
                        if ((abc).equals(Arbol_Adapter.DeletMedio.get(0))) {
                            dat.get(c).setDetalle("");
                            dat.get(c).setIdMedio(0);
                            Arbol_Adapter.DeletChildren.remove(c);
                            e = e + 1;

                        }
                    }catch (Exception x){

                    }
                }
            }



        adapter = new Arbol_Adapter(getApplicationContext());
        Asignacion.setAdapter(adapter);
        siguiente.setEnabled(false);
    }
});
cancelarAsigancion.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});


    }

    }
