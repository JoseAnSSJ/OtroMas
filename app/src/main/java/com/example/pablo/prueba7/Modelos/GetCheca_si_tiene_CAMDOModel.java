package com.example.pablo.prueba7.Modelos;

public class GetCheca_si_tiene_CAMDOModel {
    public String Error;

    public GetCheca_si_tiene_CAMDOModel(String error) {
        this.Error = error;
    }

    public String getError() {
        return Error;
    }

    public void setError(String error) {
        Error = error;
    }
}
