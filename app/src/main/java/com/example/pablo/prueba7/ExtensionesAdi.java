package com.example.pablo.prueba7;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExtensionesAdi extends AppCompatActivity {
    Button aceptar;
    public static TextView txtExtencion;

    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_extencion);
        aceptar = findViewById(R.id.extencionAceptar);
        txtExtencion = findViewById(R.id.txtExtencion);

    aceptar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
    }
}
