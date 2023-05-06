package com.github.mstavares.cm.acalculator

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Este array deverá conter todas as entidades do modelo de dados
@Database(entities = [OperationRoom::class], version = 1)
abstract class CalculatorDatabase : RoomDatabase() {

  abstract fun operationDao(): OperationDao

  companion object {

    private var instance: CalculatorDatabase? = null

    fun getInstance(context: Context): CalculatorDatabase {
      synchronized(this) {
        if(instance == null) {
          instance = Room.databaseBuilder(
            context,
            CalculatorDatabase::class.java,
            "calculator_db"
          )
            .fallbackToDestructiveMigration()
            .build()
        }
        return instance as CalculatorDatabase
      }
    }
  }

}
