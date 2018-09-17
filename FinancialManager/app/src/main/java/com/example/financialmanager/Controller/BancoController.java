package com.example.financialmanager.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.financialmanager.Banco.BancoTransacao;

public class BancoController {

    private SQLiteDatabase db;
    private BancoTransacao banco;

    public BancoController(Context context){
        banco = new BancoTransacao(context);
    }

    public String inserirInformacoes(double valor, String descricao, String carteira, String data){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BancoTransacao.VALOR, valor);
        valores.put(BancoTransacao.DESCRICAO, descricao);
        valores.put(BancoTransacao.CARTEIRA, carteira);
        valores.put(BancoTransacao.DATA, data);
        resultado = db.insert(BancoTransacao.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Ocorreu um erro inesperado ao inserir a transação.";
        else
            return "Transação inserida com sucesso.";
    }

    public Double consultarSaldo(String mes, String carteira){
        Cursor cursor;
        double total = 0;
        String[] campos =  {BancoTransacao.VALOR};
        String where = BancoTransacao.DATA + " LIKE %" + mes + "% AND " +
                        BancoTransacao.CARTEIRA + " = " + carteira;
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, where, null,
                null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false)
            {
                total = total + cursor.getDouble(cursor.getColumnIndexOrThrow(banco.VALOR));
                cursor.moveToNext();
            }
        }
        db.close();
        return total;
    }
}