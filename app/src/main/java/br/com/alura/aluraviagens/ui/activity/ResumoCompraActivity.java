package br.com.alura.aluraviagens.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluraviagens.R;

public class ResumoCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle("Resumo da compra");

    }
}
