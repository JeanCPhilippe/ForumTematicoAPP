package com.example.desafios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListadeHist extends AppCompatActivity {

    private ListView lvcon;
    ArrayAdapter<String> adapter;
    ArrayList<String> array;
    dbOpenHelper dbr = new dbOpenHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listade_hist);


        lvcon = (ListView) findViewById(R.id.LvContas);
        listarhistorico();
    }

    public void listarhistorico()
    {
        List<Conta> contas = dbr.lista();
        array = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(ListadeHist.this,
                android.R.layout.simple_list_item_1,array);
        lvcon.setAdapter(adapter);
        for (Conta c: contas)
        {
            array.add(c.getExpressao()+" = "+c.getResultado());
            adapter.notifyDataSetChanged();
        }
    }
}