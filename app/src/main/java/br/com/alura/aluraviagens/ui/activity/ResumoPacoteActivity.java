package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourceUtil;

import static br.com.alura.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APPBAR);
        carregaPacoteRecebido();

    }

    private void carregaPacoteRecebido() {
        final Intent intent = getIntent();

        if (intent.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = obtemPacote(intent);
            inicializaCampos(pacote);
            acaoBotaoRealizaPagamento(intent);
        }
    }

    private void inicializaCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDia(pacote);
        mostraPreco(pacote);
        mostraData(pacote);
    }

    private void acaoBotaoRealizaPagamento(final Intent intent) {
        Button botaoRealizarPagamento = findViewById(R.id.resumo_pacote_botao_realizar_pagamento);
        botaoRealizarPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(ResumoPacoteActivity.this, PagamentoActivity.class);
                startActivity(intent);
            }
        });
    }

    private Pacote obtemPacote(Intent intent) {
        return (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaViagem = DataUtil.formataPeriodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaViagem);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_valor);
        String moedaBrasileira = MoedaUtil.formataMoedaBrasileira(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraDia(Pacote pacote) {
        TextView dia = findViewById(R.id.resumo_pacote_dia);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dia.setText(diasEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawable = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}
