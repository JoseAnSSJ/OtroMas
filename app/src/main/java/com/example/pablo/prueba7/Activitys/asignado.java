package com.example.pablo.prueba7.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;



import com.example.pablo.prueba7.Adapters.Servicios_Adapter;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetMuestraAparatosDisponiblesListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraArbolServiciosAparatosPorinstalarListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraServiciosRelTipoAparatoListResult;
import com.example.pablo.prueba7.Modelos.GetMuestraTipoAparatoListResult;
import com.example.pablo.prueba7.Modelos.children;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

<<<<<<< HEAD:app/src/main/java/com/example/pablo/prueba7/Activitys/asignado.java
=======

>>>>>>> josue1:app/src/main/java/com/example/pablo/prueba7/asignado.java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class asignado extends AppCompatActivity {

    Button escanear, agragar;
    TextView codigo;
    String contents;
    public static ListView serviciosAparato;
    public static Spinner spinnerAparato, spinneraparatoDisponible;
    Request request = new Request();
    Array array = new Array();
    public static int idArticuloasignado, clveAparatoSpinner;
    public static String detalleSpinner, nombreSpinner;
    CheckBox checkBox;
    public static ArrayList<Integer> selectedStrings = new ArrayList<Integer>();
    public static Iterator<List<GetMuestraArbolServiciosAparatosPorinstalarListResult>> itData4 = Array.dataArbSer.iterator();
    public static List<GetMuestraArbolServiciosAparatosPorinstalarListResult> dat4 = itData4.next();

    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_asignado);
        escanear =  findViewById(R.id.escanear);
        codigo =  findViewById(R.id.codigo);
        spinnerAparato=findViewById(R.id.tipo_aparato);
        spinneraparatoDisponible=findViewById(R.id.aparatoDisponible);
        serviciosAparato = findViewById(R.id.Servicios123);
        agragar=findViewById(R.id.agregar);
        checkBox= findViewById(R.id.chekServicios);
        request.getTipoAparatos(getApplicationContext());
        selectedStrings.clear();




        spinnerAparato.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                if (position != 0) {
                    Iterator<List<GetMuestraTipoAparatoListResult>> itdata = array.dataTipoAparatos.iterator();
                    List<GetMuestraTipoAparatoListResult> dat = itdata.next();
                    detalleSpinner= dat.get(position-1).getCategoria();
                    idArticuloasignado = dat.get(position-1).getIdArticulo();
                    request.getAparatosDisponibles(getApplicationContext());
                    request.getServiciosAparatos(getApplicationContext());
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
                Iterator<List<GetMuestraAparatosDisponiblesListResult>> itData1 = array.dataAparatosDisponibles.iterator();
                    List<GetMuestraAparatosDisponiblesListResult> dat1 =  itData1.next();
                clveAparatoSpinner=dat1.get(position1).getClv_Aparato();
                nombreSpinner= dat1.get(position1).getDescripcion();

                ///////////////


                //////////////////////

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        agragar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for(int c=0; c<dat4.size(); c++){
                    for(int d=0; d<selectedStrings.size();d++){
                            int abc=dat4.get(c).getClv_UnicaNet();
                                 if(selectedStrings.get(d)==abc){
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
                        }
                    }
                }






                ////////////

                asignacion.aceptarAsignacion.setVisibility(View.VISIBLE);
                Intent intento=new Intent(asignado.this,asignacion.class);
                startActivity(intento);
                int d=0;
                for(int a=0; a<dat4.size(); a++){
                    if(dat4.get(a).children.size()>0){
                        d=d+1;
                    }
                }
                if(d==dat4.size()){
                    asignacion.aceptarAsignacion.setEnabled(true);
                }
                finish();

            }
        });

        escanear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator scanIntegrator = new IntentIntegrator(asignado.this);
                scanIntegrator.initiateScan();
            }
        });
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



}