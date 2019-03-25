package com.example.pablo.prueba7.Activitys;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
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
import com.example.pablo.prueba7.sampledata.SplashActivity;
import com.example.pablo.prueba7.sampledata.Util;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;

import static com.example.pablo.prueba7.Services.Services.clavequeja;
import static com.example.pablo.prueba7.Services.Services.clvorden;
import static com.example.pablo.prueba7.Services.Services.opcion;
import static java.security.AccessController.getContext;


public class Inicio extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static int OE,OP,OV,OEP,OO,RE,RP,REP,RV,RO;
    public static String tipodeDescarga;
        NavigationView barra;
    public static PieChart  pieChart;
    public static ProgressBar progressBarInicio;
    private Request request = new Request();
    public static TextView tipoTrabajo,contratoTrabajo, horaTrabajo, calleDireccion,numeroDireccion,coloniaDireccion, nombreTec;

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
        Util.preferences = getApplicationContext().getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        if (SplashActivity.LoginShare==true) {
            request.getClv_tecnico(getApplicationContext());
showProgress(true);

        }else{
            pieChart.setVisibility(View.VISIBLE);
            Grafica(pieChart);
        }
        barra = findViewById(R.id.nav_view);
        View barra1 = barra.getHeaderView(0);
        nombreTec=barra1.findViewById(R.id.tv_NombreTecnico);
        nombreTec.setText(Util.getNombreTecnicoPreference(Util.preferences));
        setSupportActionBar(toolbar);
        Error.Errores(this);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        tipoTrabajo.setText(request.sigueinteTipo);
        contratoTrabajo.setText(request.siguenteContrato);
        horaTrabajo.setText(request.sigueinteHora);
        calleDireccion.setText(request.siguenteCalle);
        numeroDireccion.setText(request.sigueinteNumero);
        coloniaDireccion.setText(request.siguenteColonia);

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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Inicio) {
            Intent intent1 = new Intent(Inicio.this, Inicio.class);
            startActivity(intent1);
            //Actualizar la siguente cita y la grafica
            request.getProximaCita(getApplicationContext());
                request.getOrdenes(getApplicationContext());


            finish();
        } else if (id == R.id.Ordenes_menu) {
            Intent intent1 = new Intent(Inicio.this, Orden.class);
            clvorden=0;
            opcion=1;
            request.getListOrd(getApplicationContext());
            tipodeDescarga="O";
            startActivity(intent1);

            finish();
        } else if (id == R.id.Reportes) {
            Intent intent1 = new Intent(Inicio.this, Reportes.class);
            clavequeja=0;
            opcion=1;
            request.getListQuejas(getApplicationContext());
            tipodeDescarga="Q";
            startActivity(intent1);
            finish();
        } else if (id == R.id.Configuraciones) {
            Intent intent1 = new Intent(Inicio.this, Configuracion.class);
            startActivity(intent1);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //Grafica de pastel
    public static void Grafica(PieChart pieChart1){
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
       public static void showProgress(boolean show) {
        progressBarInicio.setVisibility(show ? View.VISIBLE : View.GONE);
    }

}
