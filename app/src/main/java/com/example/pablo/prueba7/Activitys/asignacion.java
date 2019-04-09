package com.example.pablo.prueba7.Activitys;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;



import com.example.pablo.prueba7.Adapters.Arbol_Adapter;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.children;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.sampledata.BarraCargar;
import com.example.pablo.prueba7.sampledata.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;


public class asignacion extends AppCompatActivity {
    Array array = new Array();
    Request request = new Request();

    public static Button siguiente, aceptarAsignacion, eliminarAparato, cancelarAsigancion;
    public static Button aceptarmedio, cancelarmedio;
    public static ListView Asignacion;
    public static Spinner spinnerMedio;
    public static ConstraintLayout layoutMedio;
    public static ProgressDialog dialogAsignacion;
        public Arbol_Adapter adapter;
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_asignacion);
        siguiente = findViewById(R.id.siguiente);
        Asignacion = findViewById(R.id.Asignacion);
        eliminarAparato = findViewById(R.id.eliminarAparatos);
        aceptarmedio = findViewById(R.id.aceptarMedio);
        cancelarmedio = findViewById(R.id.cancelarMedio);
        spinnerMedio = findViewById(R.id.spinnerMedio);
        aceptarAsignacion = findViewById(R.id.aceptarAsignacion);
        layoutMedio = findViewById(R.id.poiuyt);
        cancelarAsigancion = findViewById(R.id.cancelarAsignacion);
        dialogAsignacion= new BarraCargar().showDialog(this);
        //----------
        adapter = new Arbol_Adapter(getApplicationContext());
        Asignacion.setAdapter(adapter);
        Asignacion.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        Asignacion.refreshDrawableState();
///////////////////
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();
                Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData = array.dataArbSer.iterator();
                List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat = itData.next();
                for (int a = 0; a < dat.size(); a++) {
                    try {
                        jsonObject = new JSONObject();
                        jsonObject.put("Clv_UnicaNet", dat.get(a).Clv_UnicaNet);
                        jsonObject.put("idMedio", dat.get(a).IdMedio);
                        jsonArray.put(a, jsonObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Intent intento = new Intent(asignacion.this, asignado.class);
                intento.putExtra("array",jsonArray.toString());
                startActivity(intento);
                finish();

            }
        });
/////////////////////
        aceptarAsignacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAsignacion.show();
                for (int a = 0; a < Array.dataArbSer.get(0).size(); a++) {
                    Array.dataArbSer.get(0).get(a).setClv_orden(Util.getClvOrden(Util.preferences));
                }
                Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData = array.dataArbSer.iterator();
                List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat = (List<GetMuestraArbolServiciosAparatosPorinstalarListResult>) itData.next();
                JSONObject jsonObject = new JSONObject();
                JSONArray jsonArray = new JSONArray();
                JSONArray jsonArray1 = new JSONArray();
                JSONObject jsonObject2 = new JSONObject();
                JSONObject jsonObject3 = new JSONObject();
                for (int c = 0; c < dat.size(); c++) {
                    try {
                        jsonObject.put("BaseIdUser", dat.get(c).BaseIdUser);
                        jsonObject.put("BaseRepoteIp", JSONObject.NULL);
                        jsonObject.put("Clv_TipSer", dat.get(c).Clv_TipSer);
                        jsonObject.put("Clv_UnicaNet", dat.get(c).Clv_UnicaNet);
                        jsonObject.put("Contrato", JSONObject.NULL);
                        jsonObject.put("Detalle", dat.get(c).Detalle);
                        jsonObject.put("Expanded", dat.get(c).Expanded);
                        jsonObject.put("IdMedio", dat.get(c).IdMedio);
                        jsonObject.put("Nombre", dat.get(c).Nombre);
                        jsonObject.put("Tipo", dat.get(c).Tipo);
                        jsonObject.put("Type", dat.get(c).Type);
                        for (int b = 0; b < dat.get(c).children.size(); b++) {
                            JSONObject jsonObject1 = new JSONObject();
                            jsonObject1.put("BaseIdUser", dat.get(c).children.get(b).baseIdUser);
                            jsonObject1.put("BaseRemoteIp", JSONObject.NULL);
                            jsonObject1.put("Clv_Aparato", dat.get(c).children.get(b).Clv_Aparato);
                            jsonObject1.put("Clv_UnicaNet", JSONObject.NULL);
                            jsonObject1.put("ContratoNet", dat.get(c).children.get(b).ContratoNet);
                            jsonObject1.put("Detalle", dat.get(c).children.get(b).Detalle);
                            jsonObject1.put("Nombre", dat.get(c).children.get(b).Nombre);
                            jsonObject1.put("Tipo", dat.get(c).children.get(b).Tipo);
                            jsonObject1.put("Type", dat.get(c).children.get(b).Type);
                            jsonArray.put(b, jsonObject1);
                        }
                        jsonObject.put("children", jsonArray);
                        jsonObject.put("clv_orden", dat.get(c).clv_orden);
                        jsonArray1.put(c, jsonObject);
                        jsonObject2.put("Id", 0);
                        jsonObject3.put("obj",jsonObject2);
                        jsonObject3.put("Lst",jsonArray1);
                        request.getAceptatAsignacino(getApplicationContext(),jsonObject3);
                        finish();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(asignacion.this, "Error", Toast.LENGTH_LONG);
                        dialogAsignacion.dismiss();
                    }
                }
            }
        });

        eliminarAparato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData = array.dataArbSer.iterator();
                List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat = (List<GetMuestraArbolServiciosAparatosPorinstalarListResult>) itData.next();
                while (Arbol_Adapter.DeletChildren.isEmpty() == false) {
                    for (int c = 0; c < dat.size(); c++) {
                        if (dat.get(c).children != null) {
                            for (int d = 0; d < dat.get(c).children.size(); d++) {
                                try {
                                    if (Integer.parseInt(dat.get(c).children.get(d).getClv_Aparato() + String.valueOf(c)) == (Arbol_Adapter.DeletChildren.get(0))) {
                                        dat.get(c).children.remove(d);
                                        Arbol_Adapter.DeletChildren.remove(0);
                                    }
                                } catch (Exception x) {

                                }
                            }
                        }

                    }
                }

                do{
                    for (int c = 0; c < dat.size(); c++) {
                        if (dat.get(c).IdMedio != null && dat.get(c).Detalle != null) {
                            String abc = dat.get(c).IdMedio + dat.get(c).Detalle;
                            try {
                                if ((abc).equals(Arbol_Adapter.DeletMedio.get(0))) {
                                    dat.get(c).setDetalle(null);
                                    dat.get(c).setIdMedio(0);
                                    Arbol_Adapter.DeletMedio.remove(0);
                                }

                            } catch (Exception x) {
                            }
                        }
                    }
                }while (Arbol_Adapter.DeletMedio.isEmpty()==false);



                Asignacion.setAdapter(adapter);

            }
        });
        cancelarAsigancion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
        }
        return true;
    }
}
