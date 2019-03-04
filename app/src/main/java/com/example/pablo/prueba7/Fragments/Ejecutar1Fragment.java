package com.example.pablo.prueba7.Fragments;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.DeepConsModel;
import com.example.pablo.prueba7.Modelos.GetQuejasListResult;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Activitys.Reportes;
import com.example.pablo.prueba7.Request.Request;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ejecutar1Fragment extends Fragment {

    Button eject;
    Request request = new Request();
    HorasFragment horas = new HorasFragment();
    int rañoE, rmesE, rdiaE, ra;
    public static LocalTime rini, rfin;
    public static String rhoraIni, rhoraFin, rfecha, fecha_sol = "";
    public static String hora1I, horafin, solution;
    public static Date datetime;
    int añoE, mesE, diaE;

    public Ejecutar1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle OnsavedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ejecutar2, container, false);
        eject = view.findViewById(R.id.ejec1);
        hora1I = HorasFragment.reportesselectTime.getText().toString();
        horafin = HorasFragment.reportesselectTime2.getText().toString();
        solution = TrabajosFragment.proble.getText().toString();

        Iterator<List<GetQuejasListResult>> itData = Array.dataReport.iterator();
        List<GetQuejasListResult> dat = (List<GetQuejasListResult>) itData.next();
        char[] caracteres = dat.get(0).getFechaSoliciutud().toCharArray();
        fecha_sol = "";
        for (int i = 0; i < 10; i++) {

            fecha_sol = fecha_sol + caracteres[i];
        }
        final Calendar c = Calendar.getInstance();
        añoE = c.get(Calendar.YEAR);
        mesE = c.get(Calendar.MONTH);
        diaE = c.get(Calendar.DAY_OF_MONTH);

        eject.setOnClickListener(new View.OnClickListener() {


            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {


                if (horas.reporteEjecutada == 1) {
                    if (ValidarFechas(Integer.parseInt(HorasFragment.diaI1), Integer.parseInt(HorasFragment.mesI1), Integer.parseInt(HorasFragment.añoI1), fecha_sol, diaE, mesE + 1, añoE, HorasFragment.hi1, HorasFragment.hf1) == 1) {
                        request.getGuardaHoraReporte(getContext());
                        request.getGuardaCampos(getContext());
                        Intent intent1 = new Intent(getActivity(), Reportes.class);
                        startActivity(intent1);
                        request.getListQuejas();

                    }
                    if (ValidarFechas(Integer.parseInt(HorasFragment.diaI1), Integer.parseInt(HorasFragment.mesI1), Integer.parseInt(HorasFragment.añoI1), fecha_sol, diaE, mesE + 1, añoE, HorasFragment.hi1, HorasFragment.hf1) == 0) {
                        Toast.makeText(getActivity(), "La fecha de ejecución no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
                    }
                    if (ValidarFechas(Integer.parseInt(HorasFragment.diaI1), Integer.parseInt(HorasFragment.mesI1), Integer.parseInt(HorasFragment.añoI1), fecha_sol, diaE, mesE + 1, añoE, HorasFragment.hi1, HorasFragment.hf1) == 2) {
                        Toast.makeText(getActivity(), "La hora inicio debe de ser menor a la hora fin", Toast.LENGTH_LONG).show();
                    }
                }
                if (horas.repotteVisita == 1) {
                    if (ValidarFechas(Integer.parseInt(HorasFragment.diaV11), Integer.parseInt(HorasFragment.mesV11), Integer.parseInt(HorasFragment.añoV11), fecha_sol, diaE, mesE + 1, añoE, HorasFragment.hi1, HorasFragment.hf1) == 1) {
                        Toast.makeText(getContext(), "FechaBien", Toast.LENGTH_SHORT);
                    }
                    if (ValidarFechas(Integer.parseInt(HorasFragment.diaV11), Integer.parseInt(HorasFragment.mesV11), Integer.parseInt(HorasFragment.añoV11), fecha_sol, diaE, mesE + 1, añoE, HorasFragment.hi1, HorasFragment.hf1) == 0) {
                        Toast.makeText(getActivity(), "La fecha de Visita no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
                    }
                    if (ValidarFechas(Integer.parseInt(HorasFragment.diaV11), Integer.parseInt(HorasFragment.mesV11), Integer.parseInt(HorasFragment.añoV11), fecha_sol, diaE, mesE + 1, añoE, HorasFragment.hi1, HorasFragment.hf1) == 2) {
                        Toast.makeText(getActivity(), "La hora inicio debe de ser menor a la hora fin", Toast.LENGTH_LONG).show();
                    }
                }
                if (horas.reporteVisita1 == 1) {
                    if (ValidarFechas(Integer.parseInt(HorasFragment.diaV21), Integer.parseInt(HorasFragment.mesV21), Integer.parseInt(HorasFragment.añoV21), fecha_sol, diaE, mesE + 1, añoE, HorasFragment.hi1, HorasFragment.hf1) == 1) {
                        Toast.makeText(getContext(), "FechaBien", Toast.LENGTH_SHORT);
                    }
                    if (ValidarFechas(Integer.parseInt(HorasFragment.diaV21), Integer.parseInt(HorasFragment.mesV21), Integer.parseInt(HorasFragment.añoV21), fecha_sol, diaE, mesE + 1, añoE, HorasFragment.hi1, HorasFragment.hf1) == 0) {
                        Toast.makeText(getActivity(), "La fecha de Visita no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
                    }
                    if (ValidarFechas(Integer.parseInt(HorasFragment.diaV21), Integer.parseInt(HorasFragment.mesV21), Integer.parseInt(HorasFragment.añoV21), fecha_sol, diaE, mesE + 1, añoE, HorasFragment.hi1, HorasFragment.hf1) == 2) {
                        Toast.makeText(getActivity(), "La hora inicio debe de ser menor a la hora fin", Toast.LENGTH_LONG).show();
                    }
                    if (horas.reporteVisita2 == 1) {
                        if (ValidarFechas(Integer.parseInt(HorasFragment.diaV21), Integer.parseInt(HorasFragment.mesV21), Integer.parseInt(HorasFragment.añoV21), fecha_sol, diaE, mesE + 1, añoE, HorasFragment.hi1, HorasFragment.hf1) == 1) {
                            Toast.makeText(getContext(), "FechaBien", Toast.LENGTH_SHORT);
                        }
                        if (ValidarFechas(Integer.parseInt(HorasFragment.diaV21), Integer.parseInt(HorasFragment.mesV21), Integer.parseInt(HorasFragment.añoV21), fecha_sol, diaE, mesE + 1, añoE, HorasFragment.hi1, HorasFragment.hf1) == 0) {
                            Toast.makeText(getActivity(), "La fecha de Visita no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
                        }
                        if (ValidarFechas(Integer.parseInt(HorasFragment.diaV21), Integer.parseInt(HorasFragment.mesV21), Integer.parseInt(HorasFragment.añoV21), fecha_sol, diaE, mesE + 1, añoE, HorasFragment.hi1, HorasFragment.hf1) == 2) {
                            Toast.makeText(getActivity(), "La hora inicio debe de ser menor a la hora fin", Toast.LENGTH_LONG).show();
                        }
                    }
                }


            }
        });
        return view;
    }

    public int ValidarFechas(int diaE, int mesE, int añoE, String fechaSol, int diaA, int mesA, int añoA, int horaI, int horaF) {
        int a = 0;
        char[] fechaSol1 = fechaSol.toCharArray();
        String diaS = "";
        for (int i = 0; i < 2; i++) {
            diaS = diaS + fechaSol1[i];
        }
        //******
        String mesS = "";
        for (int i = 3; i < 5; i++) {
            mesS = mesS + fechaSol1[i];
        }
        //*****
        String añoS = "";
        for (int i = 6; i < 10; i++) {
            añoS = añoS + fechaSol1[i];
        }
        //******
        if (Integer.parseInt(añoS) <= añoE) {
            if (Integer.parseInt(mesS) <= mesE) {
                if (Integer.parseInt(diaS) <= diaE) {
                    if (añoE <= añoA) {
                        if (mesE <= mesA) {
                            if (diaE <= diaA) {
                                if (ValidadrHoras(horaI, horaF)) {
                                    a = 1;
                                } else {
                                    a = 2;
                                }
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    public boolean ValidadrHoras(int horaInicio, int horaFin) {
        boolean a = false;
        if (horaInicio <= horaFin) {
            a = true;
        }
        return a;
    }
}



