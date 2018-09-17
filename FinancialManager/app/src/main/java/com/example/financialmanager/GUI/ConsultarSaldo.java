package com.example.financialmanager.GUI;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.financialmanager.Controller.BancoController;
import com.example.financialmanager.R;


public class ConsultarSaldo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultar_saldo);
        EditText carteira = (EditText)findViewById(R.id.consultarCarteira);
        EditText mes = (EditText)findViewById(R.id.consultarMes);

        BancoController crud = new BancoController(getBaseContext());
        Double saldo = crud.consultarSaldo(
                mes.getText().toString(),
                carteira.getText().toString());

        EditText total = (EditText)findViewById(R.id.exibirTotal);
        total.setText(saldo.toString());
    }
}
