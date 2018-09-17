package com.example.financialmanager.GUI;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.financialmanager.Controller.BancoController;
import com.example.financialmanager.R;

public class CadastrarTransacao extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_transacao);

        Button botao = (Button) findViewById(R.id.botaoSalvar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController controller = new BancoController(getBaseContext());
                EditText valor = (EditText) findViewById(R.id.edicaoValor);
                EditText descricao = (EditText) findViewById(R.id.edicaoDescricao);
                EditText data = (EditText) findViewById(R.id.edicaoData);
                EditText carteira = (EditText) findViewById(R.id.edicaoCarteira);
                String resultado;

                resultado = controller.inserirInformacoes(
                        Double.parseDouble(valor.getText().toString()),
                        descricao.getText().toString(),
                        carteira.getText().toString(),
                        data.getText().toString());

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}