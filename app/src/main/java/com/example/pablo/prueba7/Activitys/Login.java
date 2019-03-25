package com.example.pablo.prueba7.Activitys;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;
import com.example.pablo.prueba7.sampledata.Util;


public class Login extends AppCompatActivity {

    private EditText usurio, contraseña;
    private Button entrar, entrar2;
    private String user;
    public static String enco,cvl_usuario;
    public static ProgressBar progressBar;
    private Request request = new Request();
    public final static String CHANNEL_ID = "NOTIFICACION";
    public final static int NOTIFICACION_ID = 0;
    public static TextView clave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usurio = (EditText) findViewById(R.id.usuario);
        contraseña = (EditText) findViewById(R.id.contrasenia);
        entrar = (Button)findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.barlog);
        setTitle(null);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usurio.getText().toString().length()==0){
    Toast.makeText(getApplicationContext(), "Introduzca usuario", Toast.LENGTH_LONG).show();
     }else{
                    if(contraseña.getText().toString().length()==0){
        Toast.makeText(getApplicationContext(), "Introduzca contraseña", Toast.LENGTH_LONG).show();
    }else{
if(!isOnline()){
   Toast.makeText(getApplicationContext(), "No cuenta con conexion a internet", Toast.LENGTH_LONG).show();
}else{
    user = usurio.getText().toString() + ":" + contraseña.getText().toString();
    enco = (android.util.Base64.encodeToString(user.getBytes(), android.util.Base64.NO_WRAP));
    guardarPre(getApplicationContext(),usurio.getText().toString(),enco);

    request.getReviews(getApplicationContext());
    showProgress(true);
    Toast.makeText(getApplicationContext(), "Espere", Toast.LENGTH_LONG).show();
}

    }
}
            }
        });

    }
public void guardarPre(Context context,String usario,String encode){
    Util.preferences = context.getSharedPreferences("credenciales", Context.MODE_PRIVATE);
    Util.editor = Util.preferences.edit();
    Util.editor.putString("usuario",usario);
    Util.editor.putString("enco","Basic: " +encode);
    Util.editor.commit();
}
    //Notificaciones
    public void noti(){
        createNotificationChannel();
        createNotification();
    }
    public void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Noticacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
    public void createNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_menu_send);
        builder.setContentTitle("SofTv");
        builder.setContentText("Nueva Ordenn de Servicio");
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.setDefaults(Notification.DEFAULT_SOUND);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICACION_ID, builder.build());

    }
    //Metodo para hacer detener el codigo
    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void showProgress(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }
    private boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

}
