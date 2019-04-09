package com.example.pablo.prueba7.Activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetMuestraAparatosDisponiblesListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraServiciosRelTipoAparatoListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraTipoAparatoListResult;
import com.example.pablo.prueba7.Modelos.children;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.sampledata.BarraCargar;
import com.example.pablo.prueba7.sampledata.Util;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class asignado extends AppCompatActivity {

    private Button escanear, agragar,cancelar;
    private TextView codigo;
    private String contents;
    public ListView serviciosAparato;
    public Spinner spinnerAparato, spinneraparatoDisponible;
    private Request request = new Request();
    private Array array = new Array();
    public int idArticuloasignado, clveAparatoSpinner;
    public String detalleSpinner, nombreSpinner;
    public ArrayList<Integer> selectedStrings = new ArrayList<Integer>();
    public static ProgressDialog progressAsignado;
    public String arrayString;
BarraCargar barraCargar = new BarraCargar();
    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_asignado);
        spinnerAparato=findViewById(R.id.tipo_aparato);
        spinneraparatoDisponible=findViewById(R.id.aparatoDisponible);
        serviciosAparato = findViewById(R.id.Servicios123);
        agragar=findViewById(R.id.agregar);
        cancelar=findViewById(R.id.cancelarAsignacionAparato);
        progressAsignado= barraCargar.showDialog(this);
        progressAsignado.show();
        Intent intent = getIntent();
        arrayString = intent.getStringExtra("array");

        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        try {
            JSONArray jsonArray = new JSONArray(arrayString);
                jsonObject.put("Id", 0);
                jsonObject1.put("obj", jsonObject);
                jsonObject1.put("Lst", jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        request.getTipoAparatos(getApplicationContext(),jsonObject1,spinnerAparato);
        selectedStrings.clear();
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento=new Intent(asignado.this,asignacion.class);
                startActivity(intento);
                finish();
            }
        });
        spinnerAparato.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                JSONObject jsonObject = new JSONObject();
                JSONObject jsonObject1 = new JSONObject();
                JSONObject jsonObject2 = new JSONObject();
                if (position != 0) {
                    clveAparatoSpinner=0;
                    nombreSpinner="";
                    progressAsignado.show();
                    Iterator<List<GetMuestraTipoAparatoListResult>> itdata = array.dataTipoAparatos.iterator();
                    List<GetMuestraTipoAparatoListResult> dat = itdata.next();
                    detalleSpinner= dat.get(position-1).getCategoria();
                    idArticuloasignado = dat.get(position-1).getIdArticulo();
                    try{
                        jsonObject.put("clv_orden", Util.getClvOrden(Util.preferences));
                        jsonObject.put("Clv_Tecnico", Util.getClvTecnico(Util.preferences));
                        jsonObject.put("idArticulo", idArticuloasignado);
                        //////////////////////////////////////////////////
                        JSONArray jsonArray = new JSONArray(arrayString);
                        jsonObject1.put("Id",idArticuloasignado);
                        jsonObject2.put("obj",jsonObject1);
                        jsonObject2.put("Lst",jsonArray);
                    }catch (Exception e){}
                    request.getAparatosDisponibles(getApplicationContext(),jsonObject,spinneraparatoDisponible);
                    request.getServiciosAparatos(getApplicationContext(),jsonObject2,serviciosAparato);
                    serviciosAparato.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                    serviciosAparato.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position1, long id) {
                            Iterator<List<GetMuestraServiciosRelTipoAparatoListResult>> itData2 = array.dataserviciosAparatos.iterator();
                                List<GetMuestraServiciosRelTipoAparatoListResult> dat2 = itData2.next();

                                if(dat2.get(position1).baseIdUser==0){
                                    dat2.get(position1).setBaseIdUser(1);
                                }else{
                                    dat2.get(position1).setBaseIdUser(0);
                                }
                                if(dat2.get(position1).baseIdUser==1){
                                    selectedStrings.add(dat2.get(position1).clv_UnicaNet);
                                }else{
                                    selectedStrings.remove(dat2.get(position1).clv_UnicaNet);
                                }

                        }

                    });
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinneraparatoDisponible.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position1, long id) {
                if (position1 != 0) {
                    Iterator<List<GetMuestraAparatosDisponiblesListResult>> itData1 = array.dataAparatosDisponibles.iterator();
                    List<GetMuestraAparatosDisponiblesListResult> dat1 = itData1.next();
                    clveAparatoSpinner = dat1.get(position1-1).getClv_Aparato();
                    nombreSpinner = dat1.get(position1-1).getDescripcion();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        agragar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedStrings==null){
                    Toast.makeText(getApplicationContext(), "Seleccione minimo un servicio", Toast.LENGTH_SHORT);
                }else {
                    if(clveAparatoSpinner==0||nombreSpinner==""||nombreSpinner==null){
                        Toast.makeText(getApplicationContext(), "Seleccione un aparato", Toast.LENGTH_SHORT);
                    }else{
                        Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData4 = Array.dataArbSer.iterator();
                        List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat4 = itData4.next();
                        for(int c=0; c<dat4.size(); c++){
                            for(int d=0; d<selectedStrings.size();d++){
                                int abc=dat4.get(c).getClv_UnicaNet();
                                if(selectedStrings.get(0)==abc){
                                    children dataChild= new children();
                                    dataChild.setBaseIdUser(0);
                                    dataChild.setBaseRemoteIp(null);
                                    dataChild.setClv_Aparato(clveAparatoSpinner);
                                    dataChild.setClv_UnicaNet(null);
                                    dataChild.setContratoNet(0);
                                    dataChild.setDetalle(detalleSpinner);
                                    dataChild.setNombre(nombreSpinner);
                                    dataChild.setTipo("A");
                                    dataChild.setType("file");
                                    dat4.get(c).children.add(dataChild);
                                    selectedStrings.remove(0);

                                }
                            }
                        }
                        asignacion.aceptarAsignacion.setVisibility(View.VISIBLE);
                        Intent intento=new Intent(asignado.this,asignacion.class);
                        startActivity(intento);
                        finish();
                    }

                }
            }
        });
      /*  escanear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator scanIntegrator = new IntentIntegrator(asignado.this);
                scanIntegrator.initiateScan();
            }
        });*/
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (scanningResult != null){
            contents = data.getStringExtra("SCAN_RESULT");
            codigo.setText(contents);
            codigo.setVisibility(TextView.VISIBLE);
        }
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent intento=new Intent(asignado.this,asignacion.class);
            startActivity(intento);
            finish();
        }
        return true;
    }
}