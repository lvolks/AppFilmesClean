package dev.volks.filmes.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilmeRepositorySQLite
@Inject constructor(val filmeDao: FilmeDao)
    : FilmeRepository {

    override val filmes: Flow<List<Filme>>
        get() = filmeDao.listar()

    override suspend fun salvar(filme: Filme) {
        if(filme.id == 0){
            filmeDao.inserir(filme)
        } else {
            filmeDao.atualizar(filme)
        }
    }

    override suspend fun excluir(filme: Filme) {
        filmeDao.excluir(filme)
    }
}