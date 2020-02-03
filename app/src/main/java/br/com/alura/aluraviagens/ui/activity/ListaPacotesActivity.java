package br.com.alura.aluraviagens.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.dao.PacoteDAO;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.ui.adapter.ListaPacotesAdapter;

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

        pacotes = new PacoteDAO().lista();
        listViewPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}