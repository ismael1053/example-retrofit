package com.example.exampleretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaReposAdapter(private val listaRepos: List<ReposResponse>): RecyclerView.Adapter<ListaReposAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_lista_repos, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repo = listaRepos.get(position)
        holder.tvNomRepo.text = repo.nameRepo
    }

    override fun getItemCount(): Int {
        return listaRepos.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvNomRepo: TextView = itemView.findViewById(R.id.tvNomRepo)
    }


}