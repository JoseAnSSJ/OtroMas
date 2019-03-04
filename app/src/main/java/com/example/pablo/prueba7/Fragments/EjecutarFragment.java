package com.example.pablo.prueba7.Fragments;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pablo.prueba7.Fragments.InstalacionFragment;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.DeepConsModel;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import java.util.Calendar;



/**
 * A simple {@link Fragment} subclass.
 */
public class EjecutarFragment extends Fragment {

    public static Button reiniciar;
    public static Button eject;
    EditText edt1;
    public static TextView msgEjecutarOrd;
    int añoE, mesE, diaE;
    InstalacionFragment horas = new InstalacionFragment();
    Request request = new Request();

    public EjecutarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSaveInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_ejecutar, container, false);
        reiniciar = view.findViewById(R.id.restart);
        eject = view.findViewById(R.id.ejec);
        msgEjecutarOrd = view.findViewById(R.id.msgEjecutarOrd);

        reiniciar.setEnabled(false);

        eject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Array.recibixnew.size() == 0) {
                    Toast.makeText(getContext(), "Ningun aparato seleccionado", Toast.LENGTH_LONG).show();
                } else {
                    request.send_aparat();
                }
                //**************************************
                final Calendar c = Calendar.getInstance();
                añoE = c.get(Calendar.YEAR);
                mesE = c.get(Calendar.MONTH);
                diaE = c.get(Calendar.DAY_OF_MONTH);
                if (horas.ejecutada == 1) {
                    try {
                        if (ValidarFechas(Integer.parseInt(InstalacionFragment.diaI), Integer.parseInt(InstalacionFragment.mesI), Integer.parseInt(InstalacionFragment.añoI), DeepConsModel.Fec_Sol, diaE, mesE + 1, añoE, InstalacionFragment.hi, InstalacionFragment.hf) == 1) {
                            eject.setEnabled(false);
                            request.getValidaOrdSer(getActivity());
                        }
                        if (ValidarFechas(Integer.parseInt(InstalacionFragment.diaI), Integer.parseInt(InstalacionFragment.mesI), Integer.parseInt(InstalacionFragment.añoI), DeepConsModel.Fec_Sol, diaE, mesE + 1, añoE, InstalacionFragment.hi, InstalacionFragment.hf) == 0) {
                            Toast.makeText(getActivity(), "La fecha de ejecución no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
                        }
                        if (ValidarFechas(Integer.parseInt(InstalacionFragment.diaI), Integer.parseInt(InstalacionFragment.mesI), Integer.parseInt(InstalacionFragment.añoI), DeepConsModel.Fec_Sol, diaE, mesE + 1, añoE, InstalacionFragment.hi, InstalacionFragment.hf) == 2) {
                            Toast.makeText(getActivity(), "La hora inicio debe de ser menor a la hora fin", Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(getContext(), "La Fecha es obligatoria", Toast.LENGTH_SHORT).show();
                    }

                }
                if (horas.visita == 1) {
                    try {
                        if (ValidarFechas(Integer.parseInt(InstalacionFragment.diaV1), Integer.parseInt(InstalacionFragment.mesV1), Integer.parseInt(InstalacionFragment.añoV1), DeepConsModel.Fec_Sol, diaE, mesE + 1, añoE, InstalacionFragment.hi, InstalacionFragment.hf) == 1) {
                            Toast.makeText(getContext(), "FechaBien", Toast.LENGTH_SHORT);
                        }
                        if (ValidarFechas(Integer.parseInt(InstalacionFragment.diaV1), Integer.parseInt(InstalacionFragment.mesV1), Integer.parseInt(InstalacionFragment.añoV1), DeepConsModel.Fec_Sol, diaE, mesE + 1, añoE, InstalacionFragment.hi, InstalacionFragment.hf) == 0) {
                            Toast.makeText(getActivity(), "La fecha de Visita no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
                        }
                        if (ValidarFechas(Integer.parseInt(InstalacionFragment.diaV1), Integer.parseInt(InstalacionFragment.mesV1), Integer.parseInt(InstalacionFragment.añoV1), DeepConsModel.Fec_Sol, diaE, mesE + 1, añoE, InstalacionFragment.hi, InstalacionFragment.hf) == 2) {
                            Toast.makeText(getActivity(), "La hora inicio debe de ser menor a la hora fin", Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(getContext(), "La Fecha es obligatoria", Toast.LENGTH_SHORT).show();
                    }

                }
                if (horas.visita1 == 1) {
                    try {
                        if (ValidarFechas(Integer.parseInt(InstalacionFragment.diaV2), Integer.parseInt(InstalacionFragment.mesV2), Integer.parseInt(InstalacionFragment.añoV2), DeepConsModel.Fec_Sol, diaE, mesE + 1, añoE, InstalacionFragment.hi, InstalacionFragment.hf) == 1) {
                            Toast.makeText(getContext(), "FechaBien", Toast.LENGTH_SHORT);
                        }
                        if (ValidarFechas(Integer.parseInt(InstalacionFragment.diaV2), Integer.parseInt(InstalacionFragment.mesV2), Integer.parseInt(InstalacionFragment.añoV2), DeepConsModel.Fec_Sol, diaE, mesE + 1, añoE, InstalacionFragment.hi, InstalacionFragment.hf) == 0) {
                            Toast.makeText(getActivity(), "La fecha de Visita no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
                        }
                        if (ValidarFechas(Integer.parseInt(InstalacionFragment.diaV2), Integer.parseInt(InstalacionFragment.mesV2), Integer.parseInt(InstalacionFragment.añoV2), DeepConsModel.Fec_Sol, diaE, mesE + 1, añoE, InstalacionFragment.hi, InstalacionFragment.hf) == 2) {
                            Toast.makeText(getActivity(), "La hora inicio debe de ser menor a la hora fin", Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(getContext(), "La Fecha es obligatoria", Toast.LENGTH_SHORT).show();
                    }
                }
                ////////*************************

                reiniciar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        request.ReintentarComando(getActivity());
                        reiniciar.setEnabled(false);
                    }
                });


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
                                if (ValidadrHoras(horaI, horaF) == 1) {
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
        public int ValidadrHoras ( int horaInicio, int horaFin){
            int a = 0;
            if (horaInicio <= horaFin) {
                a = 1;
            }
            if (horaFin == 0 || horaFin == 0) {
                Toast.makeText(getContext(), "Ingrese horas", Toast.LENGTH_SHORT).show();
            }
            return a;
        }

    }

