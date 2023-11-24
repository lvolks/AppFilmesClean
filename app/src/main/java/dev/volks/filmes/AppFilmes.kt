package dev.volks.filmes

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.volks.filmes.data.FilmeDao
import dev.volks.filmes.data.FilmeRepository
import dev.volks.filmes.data.FilmeRepositorySQLite
import dev.volks.filmes.data.SQLite
import javax.inject.Singleton

@Module
@HiltAndroidApp
@InstallIn(SingletonComponent::class)
class AppFilmes : Application() {

    @Provides
    fun provideFilmeRepository(repositorySQLite: FilmeRepositorySQLite): FilmeRepository {
        return repositorySQLite
    }

    @Provides
    fun provideFilmeDao(banco: SQLite): FilmeDao {
        return banco.filmeDao()
    }

    @Provides
    @Singleton
    fun provideBanco(@ApplicationContext ctx: Context): SQLite {
        return SQLite.get(ctx)
    }

}