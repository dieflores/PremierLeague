package com.example.premierleageapp.Api

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "PremierLeague_table")
data class PremierLeague(
    @SerializedName("titles")
    @PrimaryKey(autoGenerate = true) val title: String?,
    val embed: String?,
    // val url : String?,
    val thumbnail: String?,
    val date: String?,
//    @Embedded val side2 : Side2?,
    @Embedded val competition: Competition?,
    //  @Embedded val videos : List<Videos>?
)








