package dev.volks.filmes.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.volks.filmes.R
import dev.volks.filmes.ViewModel.FilmeViewModel
import dev.volks.filmes.databinding.FragmentFilmeBinding

@AndroidEntryPoint
class FilmeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel : FilmeViewModel by activityViewModels()

        val binding = FragmentFilmeBinding.inflate(layoutInflater)

        var filme = viewModel.filme
        binding.labNome.setText(filme.nome)
        binding.labDesc.setText(filme.descricao)
        binding.labFoto.setText(filme.foto)

        //ONCLICK BOTÃO SALVAR
        binding.btSalvar.setOnClickListener {
            try {
                viewModel.filme.nome = binding.labNome.text.toString()
                viewModel.filme.descricao = binding.labDesc.text.toString()
                viewModel.filme.foto = binding.labFoto.text.toString()
            } catch (e: Exception){
            }
            viewModel.salvar()
            findNavController().popBackStack()

        }
        return binding.root

    }

}