package com.github.mstavares.cm.acalculator

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface OperationDao {

  @Insert
  fun insert(operation: OperationRoom)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertAll(operations: List<OperationRoom>)

  @Query("SELECT * FROM operation ORDER BY timestamp ASC")
  fun getAll(): List<OperationRoom>

  @Query("SELECT * FROM operation ORDER BY timestamp DESC LIMIT 1")
  fun getLastEntry(): OperationRoom?

}
