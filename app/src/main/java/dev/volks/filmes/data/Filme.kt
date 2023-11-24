package dev.volks.filmes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "filmes")
data class Filme(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var nome : String,
    var descricao : String,
    var foto : String
) {
    constructor(): this(0, "", "", "nopic.png")
}