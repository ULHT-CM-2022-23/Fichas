package com.github.mstavares.cm.acalculator

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class CalculatorRoom(private val dao: OperationDao) : Calculator() {

  override suspend fun equals() {
    val expression = display
    super.equals()
    val operation = OperationRoom(expression = expression, result = display.toDouble(), timestamp = Date().time)
    dao.insert(operation)
  }

  override fun showLastOperation(onFinished: () -> Unit) {
    val operationRoom = dao.getLastEntry()
    if(operationRoom != null) {
      display = operationRoom.expression
      onFinished()
    }
  }

  override fun insertRemoteHistory(operations: List<Operation>, onFinished: () -> Unit) {
    TODO("Not yet implemented")
  }

  override fun getHistory(onFinished: (Result<List<Operation>>) -> Unit) {
    val roomOperations = dao.getAll()
    val operations = roomOperations.map {
      Operation(it.expression, it.result.toString(), it.timestamp, it.uuid)
    }
    onFinished(Result.success(operations))
  }

}