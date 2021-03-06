package com.example.pablo.prueba7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.CambioAparatoDeepModel;
import com.example.pablo.prueba7.Modelos.GetListAparatosDisponiblesByIdArticuloResult;
import com.example.pablo.prueba7.Modelos.GetListClienteAparatosResult;
import com.example.pablo.prueba7.Modelos.GetListTipoAparatosByIdArticuloResult;
import com.example.pablo.prueba7.Modelos.GetSP_StatusAparatosListResult;
import com.example.pablo.prueba7.Request.Request;

import java.util.Iterator;
import java.util.List;

public class CambioAparato extends AppCompatActivity {

    public static Spinner aparato, estado,tipoAparato, aparatoAsignar;
    public static int idArticulo, contrato, idArticulo2, clvAparatoCAPAT;
    public static String statusAparato;
    Integer ab;
    Request request = new Request();
    Array array = new Array();
    Button aceptarCambioAparato;

    @Override
    protected void onCreate(@Nullable Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_cambio_aparato);
        aceptarCambioAparato =  findViewById(R.id.aceptarCambioAparato);
        aparato = findViewById(R.id.aparato);
        estado = findViewById(R.id.estadoaparato);
        tipoAparato = findViewById(R.id.tipo_aparato1);
        aparatoAsignar = findViewById(R.id.aparatoAsignar);


        ab=CambioAparatoDeepModel.AparatoAsignar;
        if(ab!=null){
            request.getDeepCAPAT(getApplicationContext());
            Login.esperar(2);


        }else{
            request.getCliApa(getApplicationContext());
            request.getStatusApa(getApplicationContext());
        }



        aceptarCambioAparato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento1 = new Intent(CambioAparato.this, Orden.class);
                startActivity(intento1);
            }
        });
        estado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    Iterator<List<GetSP_StatusAparatosListResult>> itdata1 = Array.dataStaApa.iterator();
                    List<GetSP_StatusAparatosListResult> dat1 = itdata1.next();
                    statusAparato=dat1.get(position-1).getClv_StatusCableModem();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        aparatoAsignar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    Iterator<List<GetListAparatosDisponiblesByIdArticuloResult>> itdata1 = Array.dataApaTipDis.iterator();
                    List<GetListAparatosDisponiblesByIdArticuloResult> dat1 = itdata1.next();
                    clvAparatoCAPAT=dat1.get(position-1).getClv_Aparato();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        aparato.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position!=0){
                            Iterator<List<GetListClienteAparatosResult>> itdata = array.dataCliApa.iterator();
                            List<GetListClienteAparatosResult> dat = itdata.next();
                            idArticulo = dat.get(position-1).getIdArticulo();
                            contrato = dat.get(position-1).getControNet();
                            request.getApaTipo(getApplicationContext());
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );

        tipoAparato.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0) {
                    Iterator<List<GetListTipoAparatosByIdArticuloResult>> itdata = array.dataApaTipo.iterator();
                    List<GetListTipoAparatosByIdArticuloResult> dat = itdata.next();
                    idArticulo2 = dat.get(position-1).getIdArticulo();
                    request.getApaTipDis(getApplicationContext());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

public static int obtenerPosicionAC(int abc){
        int position=0;
    Iterator<List<GetListClienteAparatosResult>> itdata = Array.dataCliApa.iterator();
        List<GetListClienteAparatosResult> dat = itdata.next();
    for(int i=0; i<dat.size(); i++){
            if(dat.get(i).idArticulo==abc){
                position = i+1;
            }
        }
        return position;
}
    public static int obtenerPosicionSA(Spinner spinner, String abc){
        int position=0;
        Iterator<List<GetSP_StatusAparatosListResult>> itdata = Array.dataStaApa.iterator();
        List<GetSP_StatusAparatosListResult> dat = itdata.next();
        for(int i=0; i<dat.size(); i++){
            if(dat.get(i).Clv_StatusCableModem.equalsIgnoreCase(abc)){
                position = i+1;
            }
        }
        return position;
    }
    public static int obtenerPosicionTA(Spinner spinner, int abc){
        int position=0;
        Iterator<List<GetListTipoAparatosByIdArticuloResult>> itdata = Array.dataApaTipo.iterator();
        List<GetListTipoAparatosByIdArticuloResult> dat = itdata.next();
        for(int i=0; i<dat.size(); i++){
            if(dat.get(i).IdArticulo==(abc)){
                position = i+1;
            }
        }
        return position;
    }
    public static int obtenerPosicionA(Spinner spinner, int abc){
        int position=0;
        Iterator<List<GetListAparatosDisponiblesByIdArticuloResult>> itdata = Array.dataApaTipDis.iterator();
        List<GetListAparatosDisponiblesByIdArticuloResult> dat = itdata.next();
        for(int i=0; i<dat.size(); i++){
            if(dat.get(i).Clv_Aparato==(abc)){
                position = i+1;
            }
        }
        return position;
    }
}
