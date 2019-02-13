package com.example.pablo.prueba7;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    EditText selectDate, selectTime, selectDate1, selectDate2, selectTime2, selectDate3;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private View contenedorParticular;
    private View contenedorCorporativo;
    public static Spinner TecSec1;
    RadioButton btn1, bt2;


    public HorasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_horas, container, false);

        TecSec1= view.findViewById(R.id.tecnicosec1);




        //////////// acciones de botones de hora y fecha//////
        selectDate = view.findViewById(R.id.ejecureal1);
        selectDate1 = view.findViewById(R.id.visita11);
        selectDate2 = view.findViewById(R.id.visita21);
        selectDate3 = view.findViewById(R.id.visita31);


        selectTime = view.findViewById(R.id.horai);
        selectTime2 = view.findViewById(R.id.horaf);
        ///////////////////////////////////////////////////////

        ///////////contenedores y acciones de radiobuttons////
        contenedorParticular = view.findViewById(R.id.RE);
        contenedorCorporativo = view.findViewById(R.id.RV);

        btn1 = view.findViewById(R.id.ejutada);
        bt2 = view.findViewById(R.id.visitada);
        /////////////////////////////////////////////////////

        ////////// fecaha, hora y radio buttons/////////
        selectDate.setOnClickListener(this);
        selectDate1.setOnClickListener(this);
        selectDate2.setOnClickListener(this);
        selectDate3.setOnClickListener(this);
        selectTime.setOnClickListener(this);
        selectTime2.setOnClickListener(this);
        bt2.setOnClickListener(this);
        btn1.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ejutada:
            {
                mostrarParticular(false);

            }
            break;
            case R.id.visitada:
            {
                mostrarParticular(true);
            }
            break;
        }


        if (v == selectDate) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    selectDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == selectTime) {

// Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minutes) {

                    selectTime.setText(hourOfDay + " : " + minutes);
                }
            }, mHour, mMinute, false);
            timePickerDialog.show();
        }

        if (v  == selectDate1) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog1 = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    selectDate1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                }
            }, mYear, mMonth, mDay);
            datePickerDialog1.show();
        }


        if (v == selectDate2) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    selectDate2.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

        if (v == selectDate3) {
            final Calendar c =Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    selectDate3.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                }

            },mYear,mMonth,mDay);
            datePickerDialog.show();
            }

        if (v == selectTime2) {

// Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    selectTime2.setText(hourOfDay + " : " + minute);
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


