package dev.volks.filmes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.volks.filmes.Fragments.FilmesFragment
import dev.volks.filmes.Fragments.FilmesFragmentDirections
import dev.volks.filmes.ViewModel.FilmeViewModel
import dev.volks.filmes.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel : FilmeViewModel by viewModels()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btAdd.setOnClickListener{ view ->
            viewModel.novo()
            val action = FilmesFragmentDirections.actionListaToFilme()
            findNavController(R.id.list)
                .navigate(action)
        }
    }
}