package com.example.pablo.prueba7;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class HorasFragment extends Fragment  implements View.OnClickListener{
    public static EditText reportesselectDate, reportesselectTime, reportesselectDate1, reportesselectDate2, reportesselectTime2, reportesselectDate3;
    public static int reporteEjecutada=1, repotteVisita=0,reporteVisita1=0;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private View contenedorParticular;
    private View contenedorCorporativo;
    public static Spinner TecSec1;
    RadioButton btn1, bt2;
    public static String statusHora="E";


    public HorasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_horas, container, false);

        TecSec1= view.findViewById(R.id.tecnicosec1);




        //////////// acciones de botones de hora y fecha//////
        reportesselectDate = view.findViewById(R.id.ejecureal1);
        reportesselectDate1 = view.findViewById(R.id.visita11);
        reportesselectDate2 = view.findViewById(R.id.visita21);
        reportesselectDate3 = view.findViewById(R.id.visita31);


        reportesselectTime = view.findViewById(R.id.horai);
        reportesselectTime2 = view.findViewById(R.id.horaf);
        ///////////////////////////////////////////////////////

        ///////////contenedores y acciones de radiobuttons////
        contenedorParticular = view.findViewById(R.id.RE);
        contenedorCorporativo = view.findViewById(R.id.RV);

        btn1 = view.findViewById(R.id.ejutada);
        bt2 = view.findViewById(R.id.visitada);
        /////////////////////////////////////////////////////

        ////////// fecaha, hora y radio buttons/////////
        reportesselectDate.setOnClickListener(this);
        reportesselectDate1.setOnClickListener(this);
        reportesselectDate2.setOnClickListener(this);
        reportesselectDate3.setOnClickListener(this);
        reportesselectTime.setOnClickListener(this);
        reportesselectTime2.setOnClickListener(this);
        bt2.setOnClickListener(this);
        btn1.setOnClickListener(this);

        reportesselectDate2.setEnabled(false);
        reportesselectDate3.setEnabled(false);

        return view;
    }

    @Override
    public void onClick(View v) {

        btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(btn1.isChecked()==true){
                    reporteEjecutada=0;
                    repotteVisita=1;
                    statusHora="V";
                }

            }
        });
        bt2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(bt2.isChecked()==true){
                    reporteEjecutada=1;
                    repotteVisita=0;
                    statusHora="E";
                }

            }
        });
        switch (v.getId()) {
            case R.id.ejutada:
            {
                mostrarParticular(false);
                reportesselectDate.setText("");
                reportesselectTime.setText("");
                reportesselectTime.setEnabled(false);
                reportesselectDate1.setText("");
                reportesselectDate2.setText("");
                reportesselectDate3.setText("");
                reportesselectTime2.setText("");
                reportesselectTime2.setEnabled(false);
                reporteEjecutada=0;
                repotteVisita=1;
                statusHora="V";

            }
            break;
            case R.id.visitada:
            {
                mostrarParticular(true);
                reportesselectDate.setText("");
                reportesselectTime.setText("");
                reportesselectTime.setEnabled(true);
                reportesselectDate1.setText("");
                reportesselectDate2.setText("");
                reportesselectDate3.setText("");
                reportesselectTime2.setText("");
                reportesselectTime2.setEnabled(true);
                reporteEjecutada=1;
                repotteVisita=0;
                statusHora="E";
            }
            break;
        }


        if (v == reportesselectDate) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    if(monthOfYear<10){
                        if(dayOfMonth<10){
                            reportesselectDate.setText("0"+dayOfMonth + "/0" + (monthOfYear + 1) + "/" + year);
                        }else{
                            reportesselectDate.setText(dayOfMonth + "/0" + (monthOfYear + 1) + "/" + year);
                        }
                    }else {
                        reportesselectDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }

                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == reportesselectTime) {

// Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minutes) {
                    if(hourOfDay<10){
                        if(minutes<10){
                            reportesselectTime.setText("0"+hourOfDay + ":0" + minutes);
                        }else{
                            reportesselectTime.setText("0"+hourOfDay + ":" + minutes);
                        }
                    }else{
                        if(minutes<10){
                            reportesselectTime.setText(hourOfDay + ":0" + minutes);
                        }else{
                            reportesselectTime.setText(hourOfDay + ":" + minutes);
                        }
                    }


                }
            }, mHour, mMinute, false);
            timePickerDialog.show();
        }

        if (v  == reportesselectDate1) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog1 = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    if(monthOfYear<10){
                        if(dayOfMonth<10){
                            reportesselectDate1.setText("0"+dayOfMonth + "/0" + (monthOfYear + 1) + "/" + year);
                        }else{
                            reportesselectDate1.setText(dayOfMonth + "/0" + (monthOfYear + 1) + "/" + year);
                        }
                    }else {
                        reportesselectDate1.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }

                }
            }, mYear, mMonth, mDay);
            datePickerDialog1.show();
        }


        if (v == reportesselectDate2) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    if(monthOfYear<10){
                        if(dayOfMonth<10){
                            reportesselectDate2.setText("0"+dayOfMonth + "/0" + (monthOfYear + 1) + "/" + year);
                        }else {
                            reportesselectDate2.setText(dayOfMonth + "/0" + (monthOfYear + 1) + "/" + year);
                        }
                    }else {
                        reportesselectDate2.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }

                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

        if (v == reportesselectDate3) {
            final Calendar c =Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    if(monthOfYear<10){
                        if(dayOfMonth<10){
                            reportesselectDate3.setText("0"+dayOfMonth + "/0" + (monthOfYear + 1) + "/" + year);
                        }else{
                            reportesselectDate3.setText(dayOfMonth + "/0" + (monthOfYear + 1) + "/" + year);
                        }
                    }else {
                        reportesselectDate3.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }

                }

            },mYear,mMonth,mDay);
            datePickerDialog.show();
            }

        if (v == reportesselectTime2) {

// Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    if(hourOfDay<10){
                        if(minute<10){
                            reportesselectTime2.setText("0"+hourOfDay + ":0" + minute);
                        }else{
                            reportesselectTime2.setText("0"+hourOfDay + ":" + minute);
                        }
                    }else{
                        if(minute<10){
                            reportesselectTime2.setText(hourOfDay + ":0" + minute);
                        }else{
                            reportesselectTime2.setText(hourOfDay + ":" + minute);
                        }
                    }
                }
            }, mHour, mMinute, false);
            timePickerDialog.show();
        }


    }


    private void mostrarParticular(boolean b) {
        contenedorParticular.setVisibility(b ? View.VISIBLE: View.GONE);
        contenedorCorporativo.setVisibility(b ? View.GONE: View.VISIBLE);
    }
}


