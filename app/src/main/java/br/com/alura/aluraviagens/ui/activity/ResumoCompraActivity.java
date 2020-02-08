package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourceUtil;

import static br.com.alura.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR);
        carregaPacoteRecebido();


    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();

        if (intent.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = obtemPacote(intent);
            inicializaCampos(pacote);
        }
    }

    private void inicializaCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraData(pacote);
        mostraValor(pacote);
    }

    private Pacote obtemPacote(Intent intent) {
        return (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
    }

    private void mostraValor(Pacote pacote) {
        TextView valor = findViewById(R.id.resumo_compra_preco);
        String moedaBrasileira = MoedaUtil.formataMoedaBrasileira(pacote.getPreco());
        valor.setText(moedaBrasileira);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data);
        String dataFormatada = DataUtil.formataPeriodoEmTexto(pacote.getDias());
        data.setText(dataFormatada);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem);
        Drawable drawablePacote = ResourceUtil
                .devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawablePacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local);
        local.setText(pacote.getLocal());
    }
}

