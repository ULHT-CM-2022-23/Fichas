package com.github.mstavares.cm.acalculator

import net.objecthunter.exp4j.ExpressionBuilder

object Calculator {

  var display: String = "0"
    private set

  private val _history = mutableListOf<Operation>(
    Operation("1+1", "2"), Operation("2+2","4")
  )
  val history get() = _history.toList()

  fun getOperationById(uuid: String): Operation? {
    return _history.find { it.uuid == uuid }
  }

  fun addSymbol(symbol: String) {
    display = if(display == "0") symbol else "$display$symbol"
  }

  fun equals() {
    val expression = ExpressionBuilder(display).build()
    val result = expression.evaluate().toString()
    _history.add(Operation(display, result))
    display = result
  }

}
