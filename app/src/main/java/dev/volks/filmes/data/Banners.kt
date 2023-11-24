package dev.volks.filmes.data

import dev.volks.filmes.R

class Banners {
    companion object {
        fun get(key: String): Int {
            val mapOfBanners = mapOf(
                "alice.png" to R.drawable.alice,
            )
            return mapOfBanners[key] ?: R.drawable.nopic
        }
    }
}