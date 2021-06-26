package com.example.desafios;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.xml.xpath.XPathExpression;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btndiv;
    private Button btnmult;
    private Button btnmais;
    private Button btnmenos;
    private ImageButton btnback;
    private Button btnclear;
    private Button btnigual;
    private Button btnponto;
    private TextView result, exp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbOpenHelper db = new dbOpenHelper(this);
        db.delete();
        /**
         * Inicializa os componentes que serão utilizados
         **/
        Inicializar();
        SetListener();
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText("");
                result.setText("");
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expressão = (TextView) findViewById(R.id.txtExp);
                String back = expressão.getText().toString();

                if (!back.isEmpty())
                {
                    byte var0 = 0;
                    int var1 = back.length()-1;
                    String express = back.substring(var0,var1);
                    expressão.setText(express);
                }
                result.setText("");
            }
        });


        btnigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expression expre = new ExpressionBuilder(exp.getText().toString()).build();
                double resultado = expre.evaluate();
                String res,expressao;
                expressao = exp.getText().toString();
                long results = (long) resultado;


                if (resultado == (double) results)
                {
                    result.setText((CharSequence) String.valueOf(results));
                    res = result.getText().toString();
                    db.Histórico(new Conta(expressao,res));
                }
                else
                {
                    result.setText((CharSequence) String.valueOf(resultado));
                    res = result.getText().toString();
                    db.Histórico(new Conta(expressao,res));
                }
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ListadeHist.class));
            }
        });
    }
    private void Inicializar ()
    {
        btn0 = (Button) findViewById(R.id.btnzero);
        btn1 = (Button) findViewById(R.id.btnum);
        btn2 = (Button) findViewById(R.id.btndois);
        btn3 = (Button) findViewById(R.id.btntres);
        btn4 = (Button) findViewById(R.id.btnquatro);
        btn5 = (Button) findViewById(R.id.btncinco);
        btn6 = (Button) findViewById(R.id.btnseis);
        btn7 = (Button) findViewById(R.id.btnsete);
        btn8 = (Button) findViewById(R.id.btnoito);
        btn9 = (Button) findViewById(R.id.btnove);
        btndiv = (Button) findViewById(R.id.div);
        btnmult = (Button) findViewById(R.id.multi);
        btnmais = (Button) findViewById(R.id.mais);
        btnigual = (Button) findViewById(R.id.igual);
        btnmenos = (Button) findViewById(R.id.menos);
        btnback = (ImageButton) findViewById(R.id.btnLimpar);
        btnclear = (Button) findViewById(R.id.btnClear);
        result = (TextView) findViewById(R.id.txtResult);
        exp = (TextView) findViewById(R.id.txtExp);
        btnponto = (Button) findViewById(R.id.ponto);
    }
    public void Expressão (String string, boolean apagar)
    {
        if (apagar)
        {
            result.setText(" ");
            exp.append(string);
        }else
        {
            exp.append(result.getText());
            exp.append(string);
            result.setText("");
        }
    }
    @Override
    public void onClick(View v)
    {
       switch (v.getId())
       {
           case R.id.btnzero:
               Expressão("0",true);
               break;
           case R.id.btnum:
               Expressão("1",true);
               break;
           case R.id.btndois:
               Expressão("2",true);
               break;
           case R.id.btntres:
               Expressão("3",true);
               break;
           case R.id.btnquatro:
               Expressão("4",true);
               break;
           case R.id.btncinco:
               Expressão("5",true);
               break;
           case R.id.btnseis:
               Expressão("6",true);
               break;
           case R.id.btnsete:
               Expressão("7",true);
               break;
           case R.id.btnoito:
               Expressão("8",true);
               break;
           case R.id.btnove:
               Expressão("9",true);
               break;
           case R.id.div:
               Expressão("/",true);
               break;
           case R.id.multi:
               Expressão("*",true);
               break;
           case R.id.mais:
               Expressão("+",true);
               break;
           case R.id.menos:
               Expressão("-",true);
               break;
           case R.id.ponto:
               Expressão(".",true);
               break;
       }

    }
    public void SetListener()
    {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnmais.setOnClickListener(this);
        btnmenos.setOnClickListener(this);
        btnmult.setOnClickListener(this);
        btnigual.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnponto.setOnClickListener(this);
    }
}