package com.example.pablo.prueba7.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrabajosFragment extends Fragment implements View.OnClickListener {
    public static Spinner solucion,prioridad,clasific;
    public static TextView desc, problm;
    public static  EditText proble;
    Request request = new Request();
    public static int Clv_Sol=-1;


    public TrabajosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSaveInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_trabajos2, container, false);
        //  request.getServiciosAsignados(getContext());
        request.getnombretec(getContext());
        request.getSolucuion(getContext());
        request.getReportesC(getContext());
        request.getReportes(getContext());




         proble=view.findViewById(R.id.problema);
         solucion = view.findViewById(R.id.tiposol);
        solucion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Clv_Sol = Array.clv_Soluc.get(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        solucion.getSelectedItemPosition();


        prioridad= view.findViewById(R.id.Sp2);
        desc= view.findViewById(R.id.observa);
        problm= view.findViewById(R.id.report);
        clasific= view.findViewById(R.id.Sp1);

        proble. setText("  ");

        return view;
    }


    @Override
    public void onClick(View view) {

    }
}


