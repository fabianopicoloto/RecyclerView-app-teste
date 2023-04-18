package com.example.recyclerviewfilmes.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerviewfilmes.R;
import com.example.recyclerviewfilmes.activity.adapter.Adapter;
import com.example.recyclerviewfilmes.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    //Cria um lista do tipo filme
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Listagem de filmes
        this.criarFilmes();

        // Configuração do adapter
        Adapter adapter = new Adapter(listaFilmes);

        // Configuração do RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //Cria o divisor para o linear layout vertical
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        //Pega os dados e monta uma visualização para cada um dos itens
        recyclerView.setAdapter(adapter);

        //Adicionar evento de click
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Filme filme = listaFilmes.get(position);
                    Toast.makeText(getApplicationContext(), "Item pressionado - " + filme.getTitulo(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onLongItemClick(View view, int position) {
                    Filme filme = listaFilmes.get(position);
                    Toast.makeText(getApplicationContext(), "Click longo - " + filme.getTitulo(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                }
            }));

    }

    public void criarFilmes() {
        Filme filme = new Filme("Tudo em Todo Lugar","Ação", "2022");
        listaFilmes.add(filme);

        filme = new Filme("Batman","Ação", "2022");
        listaFilmes.add(filme);

        filme = new Filme("Pinóquio","Fantasia", "2022");
        listaFilmes.add(filme);

        filme = new Filme("Avatar: O Caminho da Água","Aventura", "2022");
        listaFilmes.add(filme);

        filme = new Filme("Top Gun: Maverick","Ação", "2022");
        listaFilmes.add(filme);

        filme = new Filme("A Mulher Rei","Drama", "2022");
        listaFilmes.add(filme);

        filme = new Filme("O Telefone Preto","Terror", "2022");
        listaFilmes.add(filme);

        filme = new Filme("O Homem do Norte","Ação", "2022");
        listaFilmes.add(filme);

        filme = new Filme("Noites Brutais","Terror", "2022");
        listaFilmes.add(filme);

        filme = new Filme("Pânico","Terror", "2022");
        listaFilmes.add(filme);

        filme = new Filme("Esquema de Risco: Fortune","Ação", "2023");
        listaFilmes.add(filme);

        filme = new Filme("Tetris","Biografia", "2023");
        listaFilmes.add(filme);

        filme = new Filme("Rock Dog","Animação", "2023");
        listaFilmes.add(filme);
    }

}