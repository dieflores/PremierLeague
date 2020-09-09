package com.example.premierleageapp.Api

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "PremierLeague_table")
data class PremierLeague(
    @SerializedName("title")
    @PrimaryKey(autoGenerate = true) val title : String,
    val embed : String,
    val url : String,
    val thumbnail : String,
    val date : String,
    @Embedded val side1 : Side1,
    @Embedded val side2 : Side2,
    @Embedded val competition : Competition,
    @Embedded val videos : List<Videos>
)

data class Side1(val name : String,
                 val url : String)

data class Side2(val name : String,
                 val url : String)

data class Competition(val name : String,
                       val id : Int,
                       val url : String)

data class Videos(val title : String,
                  val embed : String)

