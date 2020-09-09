package com.example.premierleageapp.Bdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.premierleageapp.Api.PremierLeague


@Dao
interface PremierDao {

    // Para insertar listado de partidos


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMatchesPremierLeague(listPremierLeague: PremierLeague)

    /* Insertar un solo match ?????????????????¡?¡?¡?¡?¡?
    @Insert
    suspend fun insertMatchPremierLeague(match: PremierLeague) */

    //Traer los elementos de la tabla

    @Query("SELECT * FROM PremierLeague_table ORDER BY title DESC")
    fun getAllMatchesPremierLeague(): LiveData<List<PremierLeague>>


}