package com.example.recyclerviewfilmes.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewfilmes.R;
import com.example.recyclerviewfilmes.activity.model.Filme;

import java.util.List;

//Adapter recebe uma ViewHolder como parametro <>
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;
    //Contrutor recebe uma lista que é passada dentro do adapter
    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override //Cria as primeiras visualizações que aparecem para o usuário
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Converte o xml em uma view
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override //Recebe o objeto MyViewHolder e transfere para os TextView
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Filme filme = listaFilmes.get(position);
        holder.titulo.setText(filme.getTitulo());
        holder.genero.setText(filme.getGenero());
        holder.ano.setText(filme.getAno());
    }

    @Override //Retorna a quantidade de itens a ser exibido
    public int getItemCount() {
        return listaFilmes.size();
    }

    //Classe interna para guardar os elementos da ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo, ano, genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }

    }

}
