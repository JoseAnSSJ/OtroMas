package com.example.pablo.prueba7.Post;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.Listas.NoEntregadosList;
import com.example.pablo.prueba7.Modelos.NoEntregadosModel;
import com.example.pablo.prueba7.Modelos.UserModel;
import com.example.pablo.prueba7.sampledata.Constants;
import com.example.pablo.prueba7.sampledata.Service;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.pablo.prueba7.Adapters.ordenes_adapter_result.clvor;
import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.Clave;
import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.clvTra;
import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.descr;
import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.stat;
import static com.example.pablo.prueba7.Adapters.trabajos_adapter_result.x;
import static com.example.pablo.prueba7.Listas.Array.recibix;


public class RecibiAparato {


    //List<NoEntregadosModel>noent=new ArrayList<NoEntregadosModel>(1);
    public static  JSONObject jsonObject2 = new JSONObject();
    public static  JSONObject jsonObject = new JSONObject();
    public static JSONArray jsonArrayap = new JSONArray();
    //public static JsonArray jsonArrayap = jsonObject.getJSONArray("objSP_InsertaTbl_NoEntregados");

    public void agregaap( ){
        try {

      for(int i=0;i<x;i++){
          jsonArrayap.put(x,jsonObject);
      }
      jsonObject2.put("objSP_InsertaTbl_NoEntregados",jsonArrayap);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Service recibiapar() throws JSONException {


        MediaType JSON = MediaType.parse("application/json; charset=utf-8");


        final RequestBody body = RequestBody.create(JSON, String.valueOf(jsonObject2));


        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {

                //Modificacion del Header
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", UserModel.Codigo)
                        .addHeader("Content-Type", "application/json")
                        .post(body).build();


                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.NEW_URL)
                .client(client).addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);

    }

}
