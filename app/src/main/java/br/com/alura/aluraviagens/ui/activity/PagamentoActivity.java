package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.MoedaUtil;

import static br.com.alura.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        final Intent intent = getIntent();

        if (intent.hasExtra(CHAVE_PACOTE)) {

            Pacote pacote = obtemPacote(intent);
            inicializaCampos(pacote);
            acaoBotaoFinalizaPagamento(intent);
        }
    }

    private void inicializaCampos(Pacote pacote) {
        mostraPreco(pacote);
    }

    private void acaoBotaoFinalizaPagamento(final Intent intent) {
        Button botaoFinalizarPagamento = findViewById(R.id.pagamento_botao_finalizar_compra);
        botaoFinalizarPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(PagamentoActivity.this, ResumoCompraActivity.class);
                startActivity(intent);
            }
        });
    }

    private Pacote obtemPacote(Intent intent) {
        return (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_valor_da_compra);
        String moedaBrasileira = MoedaUtil.formataMoedaBrasileira(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }


}

