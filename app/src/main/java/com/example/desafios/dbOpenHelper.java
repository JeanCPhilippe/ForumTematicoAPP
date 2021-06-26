package com.example.desafios;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class dbOpenHelper extends SQLiteOpenHelper {
    private static final int Versao_db = 1;
    private static final String Nome_Banco = "db_Historico";


    private static final String Tabela_Banco = "tb_Contas";
    private static final String Colunm1_Banco = "Expressão";
    private static final String Colunm2_Banco = "Resultado";


    public dbOpenHelper(Context context)
    {
        super(context, Nome_Banco, null, Versao_db);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String Querry_Colunas = "CREATE TABLE "+ Tabela_Banco+ " ( "
                + Colunm1_Banco+" TEXT, " +Colunm2_Banco+ " TEXT ) ";

        db.execSQL(Querry_Colunas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void Histórico(Conta conta)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues ctv = new ContentValues();

        ctv.put(Colunm1_Banco, conta.getExpressao());
        ctv.put(Colunm2_Banco, conta.getResultado());


        db.insert("tb_Contas",null,ctv);
        db.close();
    }

    public List<Conta> lista()
    {
        List<Conta> listaconta = new ArrayList<Conta>();

        String q = "SELECT * FROM "+ Tabela_Banco;

        SQLiteDatabase dbs = this.getWritableDatabase();
        Cursor c = dbs.rawQuery(q,null);
        if (c.moveToFirst())
        {
            do
            {
             Conta contas = new Conta();
             contas.setExpressao(c.getString(0));
             contas.setResultado(c.getString(1));

             listaconta.add(contas);
            }
            while(c.moveToNext());
        }
        return listaconta;
    }
    public void delete()
    {
        String qd = "DELETE FROM "+ Tabela_Banco;
        SQLiteDatabase dbd = this.getWritableDatabase();
        dbd.execSQL(qd);
    }
}
