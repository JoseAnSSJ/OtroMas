package com.example.pablo.prueba7.Activitys;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.sampledata.BarraCargar;
import com.example.pablo.prueba7.sampledata.SplashActivity;
import com.example.pablo.prueba7.sampledata.Util;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.annotation.NonNull;




public class Inicio extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static int OE,OP,OV,OEP,OO,RE,RP,REP,RV,RO;
    public static String tipodeDescarga;
        NavigationView barra;
    public static DrawerLayout drawer;
    public static PieChart  pieChart;
    public static ProgressBar progressBarInicio;
    private Request request = new Request();
    public static TextView tipoTrabajo,contratoTrabajo, horaTrabajo, calleDireccion,numeroDireccion,coloniaDireccion, nombreTec;
    public static ProgressDialog dialogInicio;


BarraCargar barraCargar = new BarraCargar();

    public Inicio() throws JSONException {
    }

    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        pieChart =(PieChart)findViewById(R.id.graficaPastel);
        tipoTrabajo= (TextView)findViewById(R.id.tipoDeTrabajo);
        contratoTrabajo = (TextView)findViewById(R.id.contrato);
        horaTrabajo= (TextView)findViewById(R.id.hora);
        calleDireccion = (TextView)findViewById(R.id.calle);
        numeroDireccion= (TextView)findViewById(R.id.numero);
        coloniaDireccion = (TextView)findViewById(R.id.colonia);
        progressBarInicio = findViewById(R.id.barloginicio);
        barra = findViewById(R.id.nav_view);
        dialogInicio= new BarraCargar().showDialog(this);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        Util.preferences = getApplicationContext().getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        if (SplashActivity.LoginShare==true) {
            if(!isOnline()){
                Toast.makeText(getApplicationContext(), "No cuenta con conexion a internet", Toast.LENGTH_LONG).show();
                finish();

            }else {
                dialogInicio.show();
                request.getClv_tecnico(getApplicationContext());
                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

            }
        }else{
            pieChart.setVisibility(View.VISIBLE);
            Grafica(pieChart);
        }
        View barra1 = barra.getHeaderView(0);
        nombreTec=barra1.findViewById(R.id.tv_NombreTecnico);
        nombreTec.setText(Util.getNombreTecnicoPreference(Util.preferences));
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        tipoTrabajo.setText(getIntent().getStringExtra("tipo"));
        contratoTrabajo.setText(getIntent().getStringExtra("contrato"));
        horaTrabajo.setText(getIntent().getStringExtra("hora"));
        calleDireccion.setText(getIntent().getStringExtra("calle"));
        numeroDireccion.setText(getIntent().getStringExtra("numero"));
        coloniaDireccion.setText(getIntent().getStringExtra("colonia"));


    }

    @Override
    public void onBackPressed() {
    dialogoSalida();
    }

    public void dialogoSalida() {
        new AlertDialog.Builder(this)
        .setTitle("SALIR")
                .setMessage("¿Desea salir de la aplicacón?")
                .setPositiveButton("CANCELAR",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                .setNegativeButton("ACEPTAR",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //----------------
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        try{
            jsonObject.put("clv_tecnico",Util.getClvTecnico(Util.preferences) );
            jsonObject.put("op", 1);
            jsonObject.put("clv_queja", 0);
            jsonObject.put("contratoCom", 0);
            jsonObject2.put("ObjLista", jsonObject);
        }catch (Exception e){}

        //----------------
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Inicio) {
            Intent intent1 = new Intent(Inicio.this, Inicio.class);
            startActivity(intent1);
            finish();

        } else if (id == R.id.Ordenes_menu) {
            Intent intent1 = new Intent(Inicio.this, Orden.class);
            request.getListOrd(getApplicationContext(),jsonObject2);
            tipodeDescarga="O";
            startActivity(intent1);

            finish();
        } else if (id == R.id.Reportes) {

            request.getListQuejas(getApplicationContext(),jsonObject2);
            tipodeDescarga="Q";
            finish();
        } else if (id == R.id.Configuraciones) {
            Intent intent1 = new Intent(Inicio.this, Configuracion.class);
            intent1.putExtra("json",jsonObject.toString());
            startActivity(intent1);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //Grafica de pastel
    public static void Grafica(PieChart pieChart){
        //Propiedades de la grafica
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(1f);
        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(android.R.color.white);
        pieChart.setTransparentCircleRadius(1f);

        //Datos de la grafica
        ArrayList<PieEntry> yValues = new ArrayList<>();
        if(OE==0 && OP==0 && OV==0 && RP==0 && OEP==0 && OO==0 && RE==0 && RV==0 && REP==0&& RO==0 ){
            yValues.add(new PieEntry(100f, "Completado"));
            PieDataSet dataSet = new PieDataSet(yValues, "");
            dataSet.setSliceSpace(7f);
            dataSet.setSelectionShift(10f);
            dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
            dataSet.setHighlightEnabled(true);
            PieData data = new PieData((dataSet));
            data.setValueTextSize(15f);
            data.setValueTextColor(Color.BLACK);
            pieChart.setData(data);
        }else {
            if (OE != 0) {
                yValues.add(new PieEntry(OE, "OrdenEjecutada"));
            }
            if (OP != 0) {
                yValues.add(new PieEntry(OP, "OrdenPendiente"));
            }
            if (OV != 0) {
                yValues.add(new PieEntry(OV, "OrdenEnVisita"));
            }
            if (OEP != 0) {
                yValues.add(new PieEntry(OV, "OrdenEnProceso"));
            }
            if (OO != 0) {
                yValues.add(new PieEntry(OV, "Otros"));
            }
            if (RE != 0) {
                yValues.add(new PieEntry(RE, "ReportesEjecutadas"));
            }
            if (RP != 0) {
                yValues.add(new PieEntry(RP, "ReportesPendiente"));
            }
            if (REP != 0) {
                yValues.add(new PieEntry(REP, "ReportesEnProceso"));
            }
            if (RV != 0) {
                yValues.add(new PieEntry(RV, "ReportesEnVisita"));
            }
            if (RO != 0) {
                yValues.add(new PieEntry(OV, "Otros"));
            }
        }
        PieDataSet dataSet = new PieDataSet(yValues, "");
        dataSet.setSliceSpace(7f);
        dataSet.setSelectionShift(10f);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setHighlightEnabled(true);
        PieData data = new PieData((dataSet));
        data.setValueTextSize(15f);
        data.setValueTextColor(Color.BLACK);
        pieChart.animateXY(2000, 2000);
        pieChart.setData(data);
    }
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
}
