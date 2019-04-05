package com.example.pablo.prueba7.sampledata;

import org.json.JSONObject;

public class JsonMachotes {
    public static JSONObject JsonReportes(int op, int clvqueja, String contratocom){
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
    public static JSONObject JsonOrdenes(int op,int clvorden, String contratocom){
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
