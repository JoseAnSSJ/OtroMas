package com.example.pablo.prueba7.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pablo.prueba7.Adapters.ordenes_adapter_result;
import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;

import static com.example.pablo.prueba7.Services.Services.clavequeja;
import static com.example.pablo.prueba7.Services.Services.clvorden;
import static com.example.pablo.prueba7.Services.Services.cont;
import static com.example.pablo.prueba7.Services.Services.opcion;

public class Orden extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    private Request request = new Request();
    private ordenes_adapter_result adapterord;
    private Button cambiodom, cambioapa,ordenb,contratob;
    public static   ListView ordenes;
    private EditText ordsearch,contsearch;
    NavigationView barra;
    TextView nombreTec;
   private Request rqs=new Request();


    @Override


    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.activity_orden);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ordenes=findViewById(R.id.listorden);
        ordenb=findViewById(R.id.borden);
        contratob=findViewById(R.id.bcontrato);
        ordsearch=findViewById(R.id.ordsearch);
        contsearch=findViewById(R.id.contsearch);
        Error.Errores(this);
        barra = findViewById(R.id.nav_view);
        View barra1 = barra.getHeaderView(0);
        nombreTec=barra1.findViewById(R.id.tv_NombreTecnico);
        nombreTec.setText(request.nombre_tecnico);
        ////////////////////////////////////////
        clvorden=0;
        opcion=1;
        cont="";
        adapterord=new ordenes_adapter_result(Orden.this,Array.ordensrc,Array.nombresrc,Array.statusrc,Array.contratosrc,Array.direccionsrc);
        ordenes.setAdapter(adapterord);    //Asignacion del adapatador a la listView
        ordenes.refreshDrawableState();
/////////////////////////////////////////////

        //* Boton para ir a menu principal

       /* cambiodom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request.getCAMDO();
                Intent intent = new Intent(Orden.this, CambioDom.class);
                startActivity(intent);
            }
        });

        cambioapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Orden.this, CambioAparato.class);
                startActivity(intent);
            }
        });*/

        ///////////Busqueda de orden/////////////

        ordenb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (ordsearch.getText().toString().trim().equalsIgnoreCase("")){
                    Array.ordensrc.clear();
                    Array.nombresrc.clear();
                    Array.statusrc.clear();
                    Array.contratosrc.clear();
                    Array.direccionsrc.clear();
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Campo de Orden Vacio", Toast.LENGTH_SHORT);
                    clvorden=0;
                    opcion=1;
                    request.getListOrd(getApplicationContext());
                    toast1.show();
                    ordenes.setAdapter(adapterord);
                }
                else {

                    Array.ordensrc.clear();
                    Array.nombresrc.clear();
                    Array.statusrc.clear();
                    Array.contratosrc.clear();
                    Array.direccionsrc.clear();

                    opcion=2;
                    clvorden=Integer.parseInt(ordsearch.getText().toString().toLowerCase().trim());
                    rqs.getListOrd(getApplicationContext());

                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Orden encontrada", Toast.LENGTH_SHORT);
                    toast1.show();

                    ordenes.setAdapter(adapterord);
                }
            }
        });

//////////////////Busqueda de Contrato//////////////////
        contratob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (contsearch.getText().toString().trim().equalsIgnoreCase("")){
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Campo de Contrato vacio", Toast.LENGTH_SHORT);
                    Array.ordensrc.clear();
                    Array.nombresrc.clear();
                    Array.statusrc.clear();
                    Array.contratosrc.clear();
                    Array.direccionsrc.clear();

                    clvorden=0;
                    opcion=1;
                    request.getListOrd(getApplicationContext());
                    toast1.show();
                    ordenes.setAdapter(adapterord);
                    toast1.show();

                }
                else {

                    Array.ordensrc.clear();
                    Array.nombresrc.clear();
                    Array.statusrc.clear();
                    Array.contratosrc.clear();
                    Array.direccionsrc.clear();

                    opcion=3;
                    cont=(contsearch.getText().toString().toLowerCase().trim());
                    rqs.getListOrd(getApplicationContext());

                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Contrato encontrado", Toast.LENGTH_SHORT);
                    toast1.show();
                    //contsearch.setText(" ");
                    ordenes.setAdapter(adapterord);
                }
            }
        });
        //////////////////////////////////////////////


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
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Intent intento1=new Intent(Orden.this,Inicio.class);
        startActivity(intento1);
        //Intent intento1 = new Intent(mContext, MainReportes.class);
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
            Intent intent1 = new Intent(Orden.this, Inicio.class);
            startActivity(intent1);
            //Actualizar la siguente cita y la grafica
           request.getProximaCita(getApplicationContext());

                request.getOrdenes(getApplicationContext());

        } else if (id == R.id.Órdenes) {
            Intent intent1 = new Intent(Orden.this, Orden.class);
            clvorden=0;
            opcion=1;
            request.getListOrd(getApplicationContext());
            //request.getTrabajos();
            //request.getDeepCons();
            startActivity(intent1);


        } else if (id == R.id.Reportes) {
            Intent intent1 = new Intent(Orden.this, Reportes.class);
            clavequeja=0;
            opcion=1;
            request.getListQuejas(getApplicationContext());
            startActivity(intent1);

        } else if (id == R.id.Configuraciones) {
            Intent intent1 = new Intent(Orden.this, Configuracion.class);
            startActivity(intent1);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
