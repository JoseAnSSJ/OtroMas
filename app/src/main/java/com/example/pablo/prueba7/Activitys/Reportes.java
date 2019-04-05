package com.example.pablo.prueba7.Activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.pablo.prueba7.Adapters.quejas_adapter_result;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.sampledata.BarraCargar;
import com.example.pablo.prueba7.sampledata.Util;

import org.json.JSONObject;

import static com.example.pablo.prueba7.sampledata.JsonMachotes.JsonOrdenes;
import static com.example.pablo.prueba7.sampledata.JsonMachotes.JsonReportes;

public class Reportes extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
   private Request request = new Request();
   private ListView reportes;
   private Button breporte,bcontrato;
   private EditText reportesearch,contratosearch;
   private quejas_adapter_result adapterqueja;
    public static ProgressDialog dialogReportes;
    BarraCargar barraCargar = new BarraCargar();
    NavigationView barra;
    TextView nombreTec;
    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_reportes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        reportes=findViewById(R.id.listreporte);
        breporte=findViewById(R.id.breporte);
        bcontrato=findViewById(R.id.bcontrato);
        reportesearch=findViewById(R.id.reportesearch);
        contratosearch=findViewById(R.id.contsearch);
        barra = findViewById(R.id.nav_view);
        View barra1 = barra.getHeaderView(0);
        dialogReportes= barraCargar.showDialog(this);
        nombreTec=barra1.findViewById(R.id.tv_NombreTecnico);
        nombreTec.setText(Util.getNombreTecnicoPreference(Util.preferences));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        adapterqueja=new quejas_adapter_result(this);
        reportes.setAdapter(adapterqueja);    //Asignacion del adapatador a la listView
//----
        barraCargar.terminarBarra();
        //----
        breporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reportesearch.getText().toString().trim().equalsIgnoreCase("")){
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Campo de Reporte vacío", Toast.LENGTH_SHORT);
                    toast1.show();
                    request.getListQuejas(getApplicationContext(),JsonReportes(1,0,""));
                } else {
                    request.getListQuejas(getApplicationContext(),JsonReportes(2,Integer.parseInt(reportesearch.getText().toString().toLowerCase().trim()),""));
                    Toast toast1 =Toast.makeText(getApplicationContext(), "Reporte encontrado", Toast.LENGTH_SHORT);toast1.show();
                }
            }
        });
        //Busqueda de Contrato//
        bcontrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contratosearch.getText().toString().trim().equalsIgnoreCase("")){
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Campo de Contrato vacio", Toast.LENGTH_SHORT);
                   request.getListQuejas(getApplicationContext(),JsonReportes(1,0,""));
                    toast1.show();
                } else {
                    request.getListQuejas(getApplicationContext(),JsonReportes(3,0,contratosearch.getText().toString().toLowerCase().trim()));
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Contrato encontrado", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent intento1=new Intent(Reportes.this,Inicio.class);
        startActivity(intento1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.inicio, menu);
        return true; }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.Inicio) {
            Intent intento = new Intent(getApplicationContext(), Inicio.class);
            startActivity(intento);
        } else if (id == R.id.Ordenes_menu) {
            dialogReportes.show();
          request.getListOrd(getApplicationContext(),JsonOrdenes(1,0,""));
        } else if (id == R.id.Reportes) {

        } else if (id == R.id.Configuraciones) {
            Intent intent1 = new Intent(Reportes.this, Configuracion.class);
            startActivity(intent1);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

