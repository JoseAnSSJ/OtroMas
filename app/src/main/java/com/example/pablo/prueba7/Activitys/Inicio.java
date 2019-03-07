package com.example.pablo.prueba7.Activitys;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;

import static com.example.pablo.prueba7.Services.Services.clavequeja;
import static com.example.pablo.prueba7.Services.Services.clvorden;
import static com.example.pablo.prueba7.Services.Services.opcion;


public class Inicio extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static int OE,OP,OV,OEP,OO,RE,RP,REP,RV,RO;

    public static PieChart  pieChart;
    private Request request = new Request();
    public static TextView trabajo, direccion;



    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        pieChart =(PieChart)findViewById(R.id.pastel);
        trabajo= (TextView)findViewById(R.id.proximotrabajo);
        direccion = (TextView)findViewById(R.id.direccion);
        setSupportActionBar(toolbar);
        trabajo.setText(request.sigueinteTrabajo);
        direccion.setText(request.siguenteDireccion);
        Error.Errores(this);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ///////////////////////////////////////////////////////////////
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
                request.getOrdenes();


            finish();
        } else if (id == R.id.Órdenes) {
            Intent intent1 = new Intent(Inicio.this, Orden.class);
            clvorden=0;
            opcion=1;
            request.getListOrd();
            //request.getTrabajos();
            //request.getDeepCons();
            startActivity(intent1);

            finish();
        } else if (id == R.id.Reportes) {
            Intent intent1 = new Intent(Inicio.this, Reportes.class);
            clavequeja=0;
            opcion=1;
            request.getListQuejas();
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
    public static void Grafica(){

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
           if (OE != 0){
               yValues.add(new PieEntry(OE,"OrdenEjecutada"));
           }
           if (OP != 0) {
               yValues.add(new PieEntry(OP,"OrdenPendiente"));
           }
           if (OV != 0){
               yValues.add(new PieEntry(OV,"OrdenEnVisita"));
           }
           if (OEP != 0){
               yValues.add(new PieEntry(OV,"OrdenEnProceso"));
           }
           if (OO != 0){
               yValues.add(new PieEntry(OV,"Otros"));
           }
           if (RE != 0){
               yValues.add(new PieEntry(RE,"ReportesEjecutadas"));
           }
           if (RP != 0){
               yValues.add(new PieEntry(RP,"ReportesPendiente"));
           }
           if (REP != 0){
               yValues.add(new PieEntry(REP,"ReportesEnProceso"));
           }
           if (RV != 0){
               yValues.add(new PieEntry(RV,"ReportesEnVisita"));
           }
           if (RO != 0){
               yValues.add(new PieEntry(OV,"Otros"));
           }
           PieDataSet dataSet = new PieDataSet(yValues, "");
           dataSet.setSliceSpace(7f);
           dataSet.setSelectionShift(10f);
           dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
           dataSet.setHighlightEnabled(true);
           PieData data = new PieData((dataSet));
           data.setValueTextSize(15f);
           data.setValueTextColor(Color.BLACK);
           pieChart.setData(data);
       }



  /*      ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);

        dataSet.setColors(colors);*/


    }

}
