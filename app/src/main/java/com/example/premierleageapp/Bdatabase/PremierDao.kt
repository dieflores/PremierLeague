package com.example.premierleageapp.Bdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.premierleageapp.Api.PremierLeague
import com.example.premierleageapp.Api.Videos


@Dao
interface PremierDao {

    // Para insertar listado de partidos


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMatchesPremierLeague(list: List<PremierLeague>)

    //Traer los elementos de la tabla

    @Query("SELECT * FROM PremierLeague_table ORDER BY date DESC")
    fun getAllMatchesPremierLeague(): LiveData<List<PremierLeague>>

    @Query("SELECT * FROM PremierLeague_table")
    fun getVideoMatch(): LiveData<List<Videos>>

    //

  //  @Insert(onConflict = OnConflictStrategy.REPLACE)
   // suspend fun insertVideoWebView(list: List<Videos>)
    /* Insertar un solo match ?????????????????¡?¡?¡?¡?¡?
@Insert
suspend fun insertMatchPremierLeague(match: PremierLeague) */

}