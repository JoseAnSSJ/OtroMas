package com.example.pablo.prueba7.Listas;

import com.example.pablo.prueba7.Modelos.GetConHIHFOrdenQejaResult;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONHIHF {
    @SerializedName("GetConHIHF_OrdenQejaResult")
    @Expose
    private GetConHIHFOrdenQejaResult getConHIHFOrdenQejaResult;

    public GetConHIHFOrdenQejaResult getGetConHIHFOrdenQejaResult() {
        return getConHIHFOrdenQejaResult;
    }

    public void setGetConHIHFOrdenQejaResult(GetConHIHFOrdenQejaResult getConHIHFOrdenQejaResult) {
        this.getConHIHFOrdenQejaResult = getConHIHFOrdenQejaResult;
    }

}

