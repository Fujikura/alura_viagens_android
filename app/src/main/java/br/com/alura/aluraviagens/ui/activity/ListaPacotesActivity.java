package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.dao.PacoteDAO;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.ui.adapter.ListaPacotesAdapter;

import static br.com.alura.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";
    private List<Pacote> pacotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APPBAR);
        configuraListView();

    }

    private void configuraListView() {
        ListView listViewPacotes =
                findViewById(R.id.lista_pacotes_listview);

        obtemListaDePacotes();

        listViewPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));

        listViewPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {

                Pacote pacoteSelecionado = pacotes.get(posicao);
                vaiParaResumoPacote(pacoteSelecionado);
            }
        });
    }

    private void vaiParaResumoPacote(Pacote pacoteSelecionado) {
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteSelecionado);
        startActivity(intent);
    }

    private void obtemListaDePacotes() {
        pacotes = new PacoteDAO().lista();
    }
}
