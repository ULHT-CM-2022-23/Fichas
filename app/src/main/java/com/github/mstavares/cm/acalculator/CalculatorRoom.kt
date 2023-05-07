package com.github.mstavares.cm.acalculator

import java.util.*

class CalculatorRoom(private val dao: OperationDao) : Calculator() {

  override suspend fun equals() {
    val expression = display
    super.equals()
    val operation = OperationRoom(expression = expression, result = display.toDouble(), timestamp = Date().time)
    dao.insert(operation)
  }

  override suspend fun showLastOperation(onFinished: () -> Unit) {
    val operationRoom = dao.getLastEntry()
    if(operationRoom != null) {
      display = operationRoom.expression
      onFinished()
    }
  }

  override suspend fun getHistory(onFinished: (Result<List<Operation>>) -> Unit) {
    val roomOperations = dao.getAll()
    val operations = roomOperations.map {
      Operation(it.expression, it.result.toString(), it.timestamp, it.uuid)
    }
    onFinished(Result.success(operations))
  }

  suspend fun insertRemoteHistory(operations: List<Operation>, onFinished: () -> Unit) {
    val roomOperations = operations.map { OperationRoom(
      it.uuid, it.expression, it.result.toDouble(), it.timestamp
    )}
    dao.insertAll(roomOperations)
    onFinished()
  }

}