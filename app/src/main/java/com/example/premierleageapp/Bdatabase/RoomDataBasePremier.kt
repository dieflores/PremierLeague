package com.example.premierleageapp.Bdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.premierleageapp.Api.PremierLeague
import com.example.premierleageapp.Api.Videos

@Database(entities = [PremierLeague::class], version = 1, exportSchema = false)
abstract class RoomDataBasePremier : RoomDatabase() {

    abstract fun getPremierLeagueDao(): PremierDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDataBasePremier? = null

        fun getDataBase(context: Context): RoomDataBasePremier {
            val tempInstance: RoomDataBasePremier? = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance: RoomDataBasePremier = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDataBasePremier::class.java,
                    "Premier_database"
                ).build()
                INSTANCE = instance
                return instance

            }

        }
    }
}