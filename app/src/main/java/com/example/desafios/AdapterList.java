package com.example.desafios;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class AdapterList extends ArrayAdapter<Conta> {
    private final Context context;
    private final ArrayList<Conta> Contas;

    public AdapterList(Context context, ArrayList<Conta> contas) {
        super(context, R.layout.lvcontas, contas);
        this.context = context;
        this.Contas = contas;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.lvcontas,parent,false);
        TextView exp = (TextView) rowView.findViewById(R.id.txtExpressao);
        TextView res = (TextView) rowView.findViewById(R.id.txtResultado);

        exp.setText(Contas.get(position).getExpressao());
        res.setText(Contas.get(position).getResultado());
        return rowView;
    }
}
