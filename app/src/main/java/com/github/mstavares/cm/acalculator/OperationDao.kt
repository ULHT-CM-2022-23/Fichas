package com.github.mstavares.cm.acalculator

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface OperationDao {

  @Insert
  fun insert(operation: OperationRoom)

  @Query("SELECT * FROM operation ORDER BY timestamp ASC")
  fun getAll(): List<OperationRoom>

  @Query("SELECT * FROM operation WHERE uuid = :uuid")
  fun getById(uuid: String): OperationRoom

}
