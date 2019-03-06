package com.example.pablo.prueba7.Fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.DetalleBitacoraModel;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;

import java.util.Iterator;
import java.util.List;

public class Materiales extends Fragment {

    private LayoutInflater inflater;
    private ViewGroup container;
    private Bundle onsavedInstanceState;
    Request request = new Request();
    public static int clvTipoDescMat;
    public static Spinner descripcionMat,clasificacionMat;

    public Materiales() {
        // Required empty public constructor
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        View view  = inflater.inflate(R.layout.activity_descarga, container, false);
        request.MuestraBit(getContext());
        descripcionMat = view.findViewById(R.id.descripcionArticuloDesc);
        clasificacionMat = view.findViewById(R.id.clasificacionMatDesc);

        descripcionMat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    Iterator<List<DetalleBitacoraModel>> itData = Array.dataDetBit.iterator();
                        List<DetalleBitacoraModel> dat = itData.next();
                        clvTipoDescMat=dat.get(position-1).catTipoArticuloClave;
                        request.DetalleBit(getContext());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }
}
