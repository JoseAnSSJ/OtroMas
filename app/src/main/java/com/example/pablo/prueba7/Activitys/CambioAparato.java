package com.example.pablo.prueba7.Activitys;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pablo.prueba7.Adapters.trabajos_adapter_result;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.DeepConsModel;
import com.example.pablo.prueba7.Modelos.GetListAparatosDisponiblesByIdArticuloResult;
import com.example.pablo.prueba7.Modelos.GetListClienteAparatosResult;
import com.example.pablo.prueba7.Modelos.GetListTipoAparatosByIdArticuloResult;
import com.example.pablo.prueba7.Modelos.GetSP_StatusAparatosListResult;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.sampledata.BarraCargar;
import com.example.pablo.prueba7.sampledata.Util;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.dialogTrabajos;

public class CambioAparato extends AppCompatActivity {

    public Spinner aparato, estado, tipoAparato, aparatoAsignar;
    private String statusAparato;
    private Request request = new Request();
    ConstraintLayout aa;
    private Array array = new Array();
    private Button aceptarCambioAparato, Finish;
    public static ProgressDialog dialogCAPAT;
    int clv = 0;
    private int contrato, idArticulo, idArticulo2, clvAparatoCAPAT;

    @Override
    protected void onCreate(@Nullable final Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_cambio_aparato);
        aceptarCambioAparato = findViewById(R.id.uno);
        aparato = findViewById(R.id.aparato);
        estado = findViewById(R.id.estadoaparato);
        tipoAparato = findViewById(R.id.tipo_aparato1);
        aparatoAsignar = findViewById(R.id.aparatoAsignar);
        aa = findViewById(R.id.aa);
        Finish = findViewById(R.id.dos);
        dialogCAPAT = new BarraCargar().showDialog(this);

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Clv_Orden", Util.getClvOrden(Util.preferences));
            jsonObject.put("Clave", getIntent().getExtras().getInt("clv"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        request.getDeepCAPAT(getApplicationContext(), jsonObject,aparato,tipoAparato,aparatoAsignar,estado);
        final boolean ftth = getIntent().getExtras().getBoolean("ftth");
        if (!ftth) {
            aa.setVisibility(View.VISIBLE);
        } else {
            aa.setVisibility(View.GONE);
        }

        Finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogTrabajos.dismiss();
                finish();
            }
        });
        aparato.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        JSONObject jsonObject = new JSONObject();

                        if (position != 0) {
                            Iterator<List<GetListClienteAparatosResult>> itdata = array.dataCliApa.iterator();
                            List<GetListClienteAparatosResult> dat = itdata.next();
                            if (ftth == true) {
                                idArticulo = dat.get(position - 1).getIdArticulo();
                                contrato = dat.get(position - 1).getControNet();
                                try {
                                    jsonObject.put("Clv_Tecnico", Util.getClvTecnico(Util.preferences));
                                    jsonObject.put("Id_Articulo", idArticulo);
                                } catch (Exception e) {
                                }
                                request.getApaTipDis(getApplicationContext(), jsonObject,aparatoAsignar);
                            } else {
                                idArticulo = dat.get(position - 1).getIdArticulo();
                                contrato = dat.get(position - 1).getControNet();
                                try {
                                    jsonObject.put("ContratoNet", contrato);
                                    jsonObject.put("Id_Articulo", idArticulo);
                                } catch (Exception e) {
                                }
                                request.getApaTipo(getApplicationContext(), jsonObject,tipoAparato,aparatoAsignar);
                            }

                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );
        estado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Iterator<List<GetSP_StatusAparatosListResult>> itdata1 = Array.dataStaApa.iterator();
                    List<GetSP_StatusAparatosListResult> dat1 = itdata1.next();
                    statusAparato = dat1.get(position - 1).getClv_StatusCableModem();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tipoAparato.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                JSONObject jsonObject = new JSONObject();
                if (position != 0) {
                    Iterator<List<GetListTipoAparatosByIdArticuloResult>> itdata = array.dataApaTipo.iterator();
                    List<GetListTipoAparatosByIdArticuloResult> dat = itdata.next();
                    idArticulo2 = dat.get(position - 1).getIdArticulo();
                    try {
                        jsonObject.put("Clv_Tecnico", Util.getClvTecnico(Util.preferences));
                        jsonObject.put("Id_Articulo", idArticulo2);
                    } catch (Exception e) {
                    }
                    request.getApaTipDis(getApplicationContext(), jsonObject,aparatoAsignar);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        aparatoAsignar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Iterator<List<GetListAparatosDisponiblesByIdArticuloResult>> itdata1 = Array.dataApaTipDis.iterator();
                    List<GetListAparatosDisponiblesByIdArticuloResult> dat1 = itdata1.next();
                    clvAparatoCAPAT = dat1.get(position - 1).getClv_Aparato();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        aceptarCambioAparato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ftth == false) {
                    if (aparato.getSelectedItemPosition() == 0 || estado.getSelectedItemPosition() == 0 || tipoAparato.getSelectedItemPosition() == 0 || aparatoAsignar.getSelectedItemPosition() == 0) {
                        Toast.makeText(getApplicationContext(), "Selecicone todos los campos", Toast.LENGTH_LONG).show();
                    } else {
                        ejecutar();
                        finish();
                    }
                } else {
                    if (aparato.getSelectedItemPosition() == 0 || estado.getSelectedItemPosition() == 0 || aparatoAsignar.getSelectedItemPosition() == 0) {
                        Toast.makeText(getApplicationContext(), "Selecicone todos los campos", Toast.LENGTH_LONG).show();
                    } else {
                        ejecutar();
                        finish();
                    }
                }


            }
        });
    }

    private void ejecutar() {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        try {
            jsonObject.put("ClvAparato", clvAparatoCAPAT);
            jsonObject.put("ClvOrden", Util.getClvOrden(Util.preferences));
            jsonObject.put("ContratoNet", contrato);
            jsonObject.put("Status", statusAparato);
            jsonObject.put("Trabajo", "CAPAT");
            jsonObject1.put("ObjCambioAparato", jsonObject);
        } catch (Exception e) {
        }
        request.SetCambioAparato(getApplicationContext(), jsonObject1);
        dialogCAPAT.show();

    }

    public static int obtenerPosicionAC(int abc) {
        int position = 0;
        Iterator<List<GetListClienteAparatosResult>> itdata = Array.dataCliApa.iterator();
        List<GetListClienteAparatosResult> dat = itdata.next();
        for (int i = 0; i < dat.size(); i++) {
            if (dat.get(i).Clv_Aparato == abc) {
                position = i + 1;
            }
        }
        return position;
    }

    public static int obtenerPosicionSA(String abc) {
        int position = 0;
        Iterator<List<GetSP_StatusAparatosListResult>> itdata = Array.dataStaApa.iterator();
        List<GetSP_StatusAparatosListResult> dat = itdata.next();
        for (int i = 0; i < dat.size(); i++) {
            if (dat.get(i).Clv_StatusCableModem.equalsIgnoreCase(abc)) {
                position = i + 1;
            }
        }
        return position;
    }

    public static int obtenerPosicionTA(int abc) {
        int position = 0;
        Iterator<List<GetListTipoAparatosByIdArticuloResult>> itdata = Array.dataApaTipo.iterator();
        List<GetListTipoAparatosByIdArticuloResult> dat = itdata.next();
        for (int i = 0; i < dat.size(); i++) {
            if (dat.get(i).IdArticulo == (abc)) {
                position = i + 1;
            }
        }
        return position;
    }

    public static int obtenerPosicionA(int abc) {
        int position = 0;
        Iterator<List<GetListAparatosDisponiblesByIdArticuloResult>> itdata = Array.dataApaTipDis.iterator();
        List<GetListAparatosDisponiblesByIdArticuloResult> dat = itdata.next();
        for (int i = 0; i < dat.size(); i++) {
            if (dat.get(i).Clv_Aparato == (abc)) {
                position = i + 1;
            }
        }
        return position;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            dialogTrabajos.dismiss();
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
