package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import br.com.alura.aluraviagens.R;

public class PagamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle("Pagamento");


        Intent intent = new Intent(this, ResumoCompraActivity.class);
        startActivity(intent);
    }
}
