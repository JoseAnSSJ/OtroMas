package com.example.pablo.prueba7.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;


public class CambioDom extends AppCompatActivity {
    private Button aceptar,  regresar;
    public TextView Ciudad, Localidad, Colonia, Calle, Numero, Numero_i, Telefono, CalleN, CalleS, CallleE, CalleO;
    public ImageView CasaNorte, CasaSur, CasaEste, CasaOeste;


    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_cambio_domicilio);
        aceptar = findViewById(R.id.aceptar);
        Ciudad = findViewById(R.id.CiudadCAMDO);
        Localidad = findViewById(R.id.localidad);
        Colonia = findViewById(R.id.colonia);
        Calle = findViewById(R.id.Calledom);
        Numero = findViewById(R.id.numero);
        Numero_i = findViewById(R.id.numeroi);
        Telefono = findViewById(R.id.telefono);
        CalleN = findViewById(R.id.callenorte);
        CalleS = findViewById(R.id.callesur);
        CallleE = findViewById(R.id.calleeste);
        CalleO = findViewById(R.id.calleoeste);
        CasaNorte = findViewById(R.id.casanorte);
        CasaSur = findViewById(R.id.casasur);
        CasaEste = findViewById(R.id.casaeste);
        CasaOeste = findViewById(R.id.casaoeste);
        regresar=findViewById(R.id.regresa);
        Ciudad.setText(getIntent().getExtras().getString("ciudad"));
        Localidad.setText(getIntent().getExtras().getString("localidad"));
        Colonia.setText(getIntent().getExtras().getString("colonia"));
        Calle.setText(getIntent().getExtras().getString("calle"));
        Numero.setText(getIntent().getExtras().getString("numero"));
        Numero_i.setText(getIntent().getExtras().getString("numeroint"));
        Telefono.setText(getIntent().getExtras().getString("telefono"));
        CalleN.setText(getIntent().getExtras().getString("callen"));
        CalleS.setText(getIntent().getExtras().getString("calles"));
        CallleE.setText(getIntent().getExtras().getString("callee"));
        CalleO.setText(getIntent().getExtras().getString("calleo"));
        if (getIntent().getExtras().getString("casa").equals("N")) {
            CasaNorte.setVisibility(View.VISIBLE);
        }
        if (getIntent().getExtras().getString("casa").equals("S")) {
            CasaSur.setVisibility(View.VISIBLE);
        }
        if (getIntent().getExtras().getString("casa").equals("E")) {
            CasaEste.setVisibility(View.VISIBLE);
        }
        if (getIntent().getExtras().getString("casa").equals("O")) {
            CasaOeste.setVisibility(View.VISIBLE);
        }
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
