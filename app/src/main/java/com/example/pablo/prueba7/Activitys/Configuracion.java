package com.example.pablo.prueba7.Activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.sampledata.BarraCargar;
import com.example.pablo.prueba7.sampledata.SplashActivity;
import com.example.pablo.prueba7.sampledata.Util;

import org.json.JSONObject;


public class Configuracion extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Button CS;
    private TextView nombreConfi;
    private Request request = new Request();
    NavigationView barra;
    TextView nombreTec;
    public static ProgressDialog dialogOrdenes;
    BarraCargar barraCargar = new BarraCargar();
    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_configuracion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CS = (Button)findViewById(R.id.btnCerrarSesion);
        nombreConfi = findViewById(R.id.nombreTecnico);
        barra = findViewById(R.id.nav_view);
        View barra1 = barra.getHeaderView(0);
        nombreTec=barra1.findViewById(R.id.tv_NombreTecnico);
        nombreTec.setText(Util.getNombreTecnicoPreference(Util.preferences));
        dialogOrdenes = barraCargar.showDialog(this);
        //Boton para cerrar sesion
        nombreConfi.setText(Util.getNombreTecnicoPreference(Util.preferences));
        CS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Util.preferences = getApplicationContext().getSharedPreferences("credenciales", getApplicationContext().MODE_PRIVATE);
                    Util.preferences.edit().clear().apply();
                    SplashActivity.LoginShare=false;
                    Intent intento = new Intent(Configuracion.this, Login.class);
                    startActivity(intento);
                }
                catch (Exception e){

                }

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
            Intent intent1 = new Intent(Configuracion.this, Inicio.class);
            startActivity(intent1);
        } else if (id == R.id.Ordenes_menu) {
            dialogOrdenes.show();
            request.getListOrd(getApplicationContext(),JsonOrdenes(1,0,""));
        } else if (id == R.id.Reportes) {
            dialogOrdenes.show();
            request.getListQuejas(getApplicationContext(),JsonReportes(1,0,""));
        } else if (id == R.id.Configuraciones) {
            Intent intent1 = new Intent(Configuracion.this, Configuracion.class);
            startActivity(intent1);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public JSONObject JsonReportes(int op,int clvqueja, String contratocom){
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        try{
            jsonObject.put("clv_tecnico",Util.getClvTecnico(Util.preferences) );
            jsonObject.put("op", op);
            jsonObject.put("clv_queja", clvqueja);
            jsonObject.put("contratoCom", contratocom);
            jsonObject2.put("ObjLista", jsonObject);
        }catch (Exception e){}
        return jsonObject2;
    }
    public JSONObject JsonOrdenes(int op,int clvorden, String contratocom){
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        try{
            jsonObject.put("clv_tecnico",Util.getClvTecnico(Util.preferences) );
            jsonObject.put("op", op);
            jsonObject.put("clv_orden", clvorden);
            jsonObject.put("contratoCom", contratocom);
            jsonObject2.put("ObjLista", jsonObject);
        }catch (Exception e){}
        return jsonObject2;
    }
}
