package com.example.pablo.prueba7.Activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.Fragments.EjecutarFragment;
import com.example.pablo.prueba7.Fragments.InstalacionFragment;
import com.example.pablo.prueba7.Fragments.Materiales;
import com.example.pablo.prueba7.Fragments.Trabajos;

import static com.example.pablo.prueba7.Request.Request.nombre_tecnico;


//import static com.example.pablo.prueba7.Request.Request.nombre_tecnico;


public class MainActivity extends AppCompatActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    ScrollView hzScrollView;
    Button info;
    RelativeLayout layoutAnimado;
    public static TextView NombreTec, Contrato, Status, Empresa, Nombre, Direccion, InfoServicios;

    Request request = new Request();


    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setRetainInstance(true);
        if (onSaveInstanceState != null) {
            //Restore the fragment's instance

            Fragment mcontext = getSupportFragmentManager().getFragment(onSaveInstanceState, "asd");

        }

        setContentView(R.layout.activity_swipe);
        info= findViewById(R.id.info);
        layoutAnimado= findViewById(R.id.animado);
        hzScrollView= findViewById(R.id.scv);
        NombreTec= findViewById(R.id.tecniconame);
        Contrato= findViewById(R.id.contrato);
        Status= findViewById(R.id.status);
        Empresa= findViewById(R.id.infoempresa);
        Nombre= findViewById(R.id.infonombre);
        Direccion= findViewById(R.id.infodireccion);
        InfoServicios= findViewById(R.id.infoservicios);
        setTitle(null);

       NombreTec.setText(nombre_tecnico);


//* Boton de informacion

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request.getInfoCliente();
                    request.getServicios();
                if(layoutAnimado.getVisibility()==View.GONE) {
                    layoutAnimado.setVisibility(View.VISIBLE);
                    hzScrollView.setVisibility(View.VISIBLE);

                    info.setText("Ocultar");
                }
                else{
                    layoutAnimado.setVisibility(View.GONE);
                    hzScrollView.setVisibility(View.GONE);
                    info.setText("Info");
                }
            }
        });

        //* Swipe




        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);


        mViewPager.setAdapter(adapter);

        mViewPager.setOnPageChangeListener(this);


        ActionBar actionBar = getSupportActionBar();


        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        ActionBar.Tab tab = actionBar.newTab().setText("Horas").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Trabajo").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Material").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Ejecutar").setTabListener(this);
        actionBar.addTab(tab);

    }

    private void setRetainInstance(boolean b) {




    }

    public class PagerAdapter extends FragmentPagerAdapter {


        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int arg0) {
            switch (arg0) {
                case 0:
                    return new InstalacionFragment();
                case 1:

                    return new Trabajos();
                case 2:
                    return new Materiales();
                case 3:
                    return new EjecutarFragment();

                default:
                    return null;
            }
        }


            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();


        public int getCount() {
            return 4;
        }
    }
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        getSupportActionBar().setSelectedNavigationItem(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }


}