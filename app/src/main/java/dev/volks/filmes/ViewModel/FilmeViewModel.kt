package dev.volks.filmes.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.volks.filmes.data.Filme
import dev.volks.filmes.data.FilmeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmeViewModel
@Inject constructor(val repository: FilmeRepository) : ViewModel() {

    var filme: Filme = Filme()
    private var _filmes = MutableStateFlow(listOf<Filme>())
    val filmes : Flow<List<Filme>> = _filmes


    init {
        viewModelScope.launch {
            repository.filmes.collect{ filmes ->
                _filmes.value = filmes
            }
        }
    }

    //FUNÇÕES
    fun novo(){
        this.filme = Filme()
    }

    fun editar(filme: Filme){
        this.filme = filme
    }

    fun salvar() = viewModelScope.launch {
        repository.salvar(filme)
    }

    fun excluir(filme: Filme) = viewModelScope.launch {
        repository.excluir(filme)
    }

}