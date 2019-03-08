package com.example.pablo.prueba7.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Modelos.GetDameDatosCAMDOResult;
import com.example.pablo.prueba7.R;

import java.util.Iterator;
import java.util.List;

public class CambioDom extends AppCompatActivity {

    Button aceptar,  regresar;
   public static TextView Ciudad, Localidad, Colonia, Calle, Numero, Numero_i, Telefono, CalleN, CalleS, CallleE, CalleO;
   public static ImageView CasaNorte, CasaSur, CasaEste, CasaOeste;


    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_cambio_domicilio);
        aceptar = findViewById(R.id.aceptar);
        Ciudad = findViewById(R.id.ciudadCAMDO);
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






        Iterator<List<GetDameDatosCAMDOResult>> itdata = Array.dataCAMDO.iterator();
            List<GetDameDatosCAMDOResult> dat = itdata.next();
        Ciudad.setText(dat.get(0).Ciudad);
        Localidad.setText(dat.get(0).getLocalidad());
        Colonia.setText(dat.get(0).getColonia());
        Calle.setText(dat.get(0).getCalle());
        Numero.setText(String.valueOf(dat.get(0).getNUMERO()));
        Numero_i.setText(dat.get(0).getNum_int());
        Telefono.setText(dat.get(0).getTELEFONO());
        CalleN.setText(dat.get(0).getCalleNorte());
        CalleS.setText(dat.get(0).getCalleSur());
        CallleE.setText(dat.get(0).getCalleEste());
        CalleO.setText(dat.get(0).getCalleOeste());

        if (dat.get(0).getCasa().equals("N")) {
            CasaNorte.setVisibility(View.VISIBLE);
        }
        if (dat.get(0).getCasa().equals("S")) {
            CasaSur.setVisibility(View.VISIBLE);
        }
        if (dat.get(0).getCasa().equals("E")) {
            CasaEste.setVisibility(View.VISIBLE);
        }
        if (dat.get(0).getCasa().equals("O")) {
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
                Intent intento1 = new Intent(CambioDom.this, Orden.class);
                startActivity(intento1);
            }
        });


    }
}
