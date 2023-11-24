package dev.volks.filmes.data

import kotlinx.coroutines.flow.Flow

interface FilmeRepository {

    val filmes: Flow<List<Filme>>
    suspend fun salvar(filme: Filme)
    suspend fun excluir(filme: Filme)
}