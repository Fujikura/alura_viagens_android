package br.com.alura.aluraviagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.util.ResourceUtil;
import br.com.alura.aluraviagens.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context contexto;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context contexto){

        this.pacotes = pacotes;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View listView, ViewGroup viewGroup) {

        final View viewItemPacote = LayoutInflater
                .from(contexto)
                .inflate(R.layout.item_pacote, viewGroup, false);

        Pacote pacote = pacotes.get(position);

        mostraLocal(viewItemPacote, pacote);
        mostraImagem(viewItemPacote, pacote);
        mostraDias(viewItemPacote, pacote);
        mostraPreco(viewItemPacote, pacote);


        return viewItemPacote;
    }

    private void mostraPreco(View viewItemPacote, Pacote pacote) {
        TextView preco = viewItemPacote.findViewById(R.id.item_pacote_preco);
        String precoFormatado =
                MoedaUtil.formataMoedaBrasileira(pacote.getPreco());
        preco.setText(precoFormatado);
    }

    private void mostraDias(View viewItemPacote, Pacote pacote) {
        TextView dias = viewItemPacote.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }



    private void mostraImagem(View viewCriada, Pacote pacote) {
        //Bind da imagem
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemPacote = ResourceUtil.devolveDrawable(contexto, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote );
    }


    private void mostraLocal(View viewCriada, Pacote pacote) {
        // Bind do local
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }
}
