package com.example.desafios;

public class Conta {
    String Expressao;
    String Resultado;

    public Conta()
    {

    }


    public Conta(String Express, String Result)
    {
        this.Expressao = Express;
        this.Resultado = Result;
    }


    public String getExpressao() {
        return Expressao;
    }

    public void setExpressao(String expressao) {
        Expressao = expressao;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String resultado) {
        Resultado = resultado;
    }
}
