package com.example.pablo.prueba7;

import android.content.Context;

import com.example.pablo.prueba7.Request.Request;

public class ReintentarComando {
     Request request = new Request();
     EjecutarFragment ejecutarFragment = new EjecutarFragment();
     public static int b=0;
    public void reintentarComando(Context context){
        for(int a=0; a==1;){
            request.ConsultaIp();
            ejecutarFragment.msgEjecutarOrd.setText("");
            if(request.msgComando.length()<=2&&request.reintentarComando==false){
                ejecutarFragment.msgEjecutarOrd.setText(request.msgComando);
                a=1;
                b=1;
            }else{
                a=0;
            }
            if(request.reintentarComando==true){
                ejecutarFragment.reiniciar.setEnabled(true);
                ejecutarFragment.msgEjecutarOrd.setText(request.msgComando);
            }
            Login.esperar(3);
        }

    }

}
