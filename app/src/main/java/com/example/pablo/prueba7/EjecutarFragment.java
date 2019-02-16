package com.example.pablo.prueba7;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pablo.prueba7.Modelos.DeepConsModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class EjecutarFragment extends Fragment {

    Button reiniciar;
    Button eject;
    EditText edt1;

    public static int check;


    int añoE, mesE, diaE,a;
    public static LocalTime ini,fin;
    InstalacionFragment horas = new InstalacionFragment();
    public static String horaIni,horaFin, fecha;

    public EjecutarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSaveInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ejecutar, container, false);
        reiniciar = view.findViewById(R.id.restart);
        eject = view.findViewById(R.id.ejec);
        edt1 = view.findViewById(R.id.status);

        reiniciar.setEnabled(false);

        eject.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {


                processScreen();

a=0;
                horaIni = String.valueOf(horas.selectTime.getText());
                horaFin = String.valueOf(horas.selectTime2.getText());
                if(horas.ejecutada=true) {
                    try {
                        ini = LocalTime.parse(horaIni);
                    }catch (Exception e){
                        Toast.makeText(getActivity(), "Ingrese Horas", Toast.LENGTH_LONG).show();
                        a=1;
                    }
                    try {
                        fin = LocalTime.parse(horaFin);
                        ValidacionHoras();
                    }catch (Exception e){
                        Toast.makeText(getActivity(), "Ingrese Horas", Toast.LENGTH_LONG).show();
                        a=1;
                    }
                    if(a==0){
                        ValidacionHoras();
                    }
                }
                if(horas.visita==true){
                    ValidacionVisita();
                }



              /*  if ((edt1.getText().toString().trim()).equalsIgnoreCase("ERROR")) {
                    reiniciar.setEnabled(true);
                }
                if ((edt1.getText().toString().trim()).equalsIgnoreCase("PENDIENTE")) {
                    reiniciar.setEnabled(true);
                }
                if ((edt1.getText().toString().trim()).equalsIgnoreCase("EXITOSO")) {
                    reiniciar.setEnabled(false);
                }
                eject.setEnabled(false);
                reiniciar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if ((edt1.getText().toString().trim()).equalsIgnoreCase("EXITOSO")) {
                            eject.setEnabled(true);
                        }
                        if ((edt1.getText().toString().trim()).equalsIgnoreCase("ERROR")) {
                            eject.setEnabled(false);
                        }
                        if ((edt1.getText().toString().trim()).equalsIgnoreCase("PENDIENTE")) {
                            eject.setEnabled(false);
                        }
                    }
                });*/


            }
        });
        return view;
    }

    private void processScreen() {

        // check=Orden.ordenes.getCheckedItemPosition();
        //check=Orden.ordenes.getCheckedItemPosition();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
public void ValidacionHoras(){
    String dateEje = String.valueOf(horas.selectDate.getText());
    String visita1 = String.valueOf(horas.selectDate1.getText());
    String visita2 = String.valueOf(horas.selectDate2.getText());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    final Calendar c = Calendar.getInstance();
    añoE = c.get(Calendar.YEAR);
    mesE = c.get(Calendar.MONTH);
    diaE = c.get(Calendar.DAY_OF_MONTH);

    if(mesE<10){
        fecha = (diaE+1) + "/0" + (mesE + 1) + "/" + añoE;
    }else{
        fecha = (diaE+1) + "/" + (mesE + 1) + "/" + añoE;
    }
    if(horas.ejecutada=true) {
        try {
            if (sdf.parse(DeepConsModel.Fec_Sol).after(sdf.parse(dateEje))) {
                if(sdf.parse(fecha).after(sdf.parse(dateEje))){
                    if (ini.isBefore(fin)) {
                        Toast.makeText(getActivity(), "Hora bien y Fecha bien", Toast.LENGTH_LONG).show();
                    }
                    if (ini.isAfter(fin)) {
                        Toast.makeText(getActivity(), "La hora fin no puede der igual o mayor a la hora inicio", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getActivity(), "La fecha de ejecución no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
                }
            } else {
                //  (sdf.parse(DeepConsModel.Fec_Sol).before(sdf.parse(dateEje)))
                Toast.makeText(getActivity(), "La fecha de ejecución no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
            }
        } catch (ParseException e) {
            Toast.makeText(getActivity(), "La fecha de ejecución no puede ser menor a la fecha de solicitud ni mayo a la fecha actual", Toast.LENGTH_LONG).show();
        }
    }

}
@RequiresApi(api = Build.VERSION_CODES.O)
public void ValidacionVisita() {
    String visita1 = String.valueOf(horas.selectDate1.getText());
    String visita2 = String.valueOf(horas.selectDate2.getText());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    final Calendar c = Calendar.getInstance();
    añoE = c.get(Calendar.YEAR);
    mesE = c.get(Calendar.MONTH);
    diaE = c.get(Calendar.DAY_OF_MONTH);

    if (mesE < 10) {
        fecha = (diaE + 1) + "/0" + (mesE + 1) + "/" + añoE;
    } else {
        fecha = (diaE + 1) + "/" + (mesE + 1) + "/" + añoE;
    }

    if (horas.visita == true) {
        try {
            if (sdf.parse(DeepConsModel.Fec_Sol).after(sdf.parse(visita1))) {
                if (sdf.parse(fecha).after(sdf.parse(visita1))) {
                    if (ini.isBefore(fin)) {
                        Toast.makeText(getActivity(), "Hora bienV y Fecha bienV", Toast.LENGTH_LONG).show();
                    }
                    if (ini.isAfter(fin)) {
                        Toast.makeText(getActivity(), "La fecha de visita 1 no puede ser menor a la fecha de solicitud ni mayor a la fecha actual", Toast.LENGTH_LONG).show();
                    }
                }
            }
        } catch (ParseException e) {
            Toast.makeText(getActivity(), "Fecha mal, visita", Toast.LENGTH_LONG).show();
        }
    }
    if (horas.visita1 == true) {
        try {
            if (sdf.parse(DeepConsModel.Fec_Sol).after(sdf.parse(visita1))) {
                if (sdf.parse(fecha).after(sdf.parse(visita1))) {
                    if (sdf.parse(visita1).after(sdf.parse(visita2))) {
                        Toast.makeText(getActivity(), "Fecha bienV", Toast.LENGTH_LONG).show();
                    }
                    Toast.makeText(getActivity(), "La fecha de visita 2 no puede ser menor a la fecha de visita 1 ni mayor a la fecha actual", Toast.LENGTH_LONG).show();
                }
            }
        } catch (ParseException e) {
            Toast.makeText(getActivity(), "Fecha mal, visita", Toast.LENGTH_LONG).show();
        }
    }



}}