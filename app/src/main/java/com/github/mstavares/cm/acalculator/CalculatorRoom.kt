package com.github.mstavares.cm.acalculator

import java.util.*

class CalculatorRoom(private val dao: OperationDao) : Calculator() {

  override suspend fun equals() {
    val expression = display
    super.equals()
    val operation = OperationRoom(expression = expression, result = display.toDouble(), timestamp = Date().time)
    dao.insert(operation)
  }

  override suspend fun showLastOperation() {
    TODO("Not yet implemented")
  }

  override suspend fun getHistory(callback: (List<Operation>) -> Unit) {
    val roomOperations = dao.getAll()
    val operations = roomOperations.map {
      Operation(it.expression, it.result.toString(), it.timestamp, it.uuid)
    }
    callback(operations)
  }

}