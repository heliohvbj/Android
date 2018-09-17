package com.example.financialmanager.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoTransacao extends SQLiteOpenHelper
{
    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "transacoes";
    public static final String ID = "_id";
    public static final String VALOR = "valor";
    public static final String CARTEIRA = "carteira";
    public static final String DESCRICAO = "descricao";
    public static final String DATA = "data";
    private static final int VERSAO = 1;

    public BancoTransacao(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+" ("
                + ID + " integer primary key autoincrement,"
                + VALOR + " real,"
                + CARTEIRA + " text,"
                + DESCRICAO + " text,"
                + DATA + " text"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
