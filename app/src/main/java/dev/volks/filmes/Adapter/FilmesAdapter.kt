package dev.volks.filmes.Adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import dev.volks.filmes.Fragments.FilmesFragmentDirections
import dev.volks.filmes.ViewModel.FilmeViewModel
import dev.volks.filmes.data.Banners
import dev.volks.filmes.data.Filme
import dev.volks.filmes.databinding.FilmeItemBinding
import java.lang.reflect.Type

class FilmesAdapter(
    private val filmes: List<Filme>,
    val viewModel: FilmeViewModel
) : RecyclerView.Adapter<FilmesAdapter.FilmeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            FilmeViewHolder{

        return FilmeViewHolder (
            FilmeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: FilmesAdapter.FilmeViewHolder, position: Int) {
        val filme = filmes[position]

        //ATUALIZAÇÃO DOS FILMES
        val imgId = Banners.get(filme.foto)
        holder.img.setImageResource(imgId)
        holder.nome.text = filme.nome
        holder.descricao.text = filme.descricao

        //ONCLICK DE ALGUM FILME
        holder.itemView.setOnClickListener{view ->
            viewModel.editar(filme)
            val action = FilmesFragmentDirections.actionListaToFilme()
            view.findNavController().navigate(action)
        }

        //ONLONGCLICK DE ALGUM FILME
        holder.itemView.setOnLongClickListener { view ->
            AlertDialog.Builder(view.context)
                .setMessage("DESEJA EXCLUIR O FILME?")
                .setPositiveButton("CONFIRMAR") { dialog, id ->
                    viewModel.excluir(filme)
                }
                .setNegativeButton("CANCELAR") { dialog, id ->
                }.create().show()
            true
        }
    }

    override fun getItemCount(): Int = filmes.size

    inner class FilmeViewHolder(binding: FilmeItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
            val img : ImageView = binding.fotoFilme
            val nome : TextView = binding.nomeFilme
            val descricao : TextView = binding.descricaoFilme
            }

}