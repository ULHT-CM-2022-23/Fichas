package com.github.mstavares.cm.acalculator

import net.objecthunter.exp4j.ExpressionBuilder

abstract class Calculator {

  var display: String = "0"
    private set

  fun addSymbol(symbol: String) {
    display = if(display == "0") symbol else "$display$symbol"
  }

  open suspend fun equals() {
    val expression = ExpressionBuilder(display).build()
    val result = expression.evaluate().toString()
    display = result
  }

  fun clear() {
    display = "0"
  }

  fun backspace() {
    display = if(display.length > 1) display.dropLast(1) else "0"
  }

  abstract suspend fun showLastOperation()
  abstract suspend fun getHistory(callback: (List<Operation>) -> Unit)

}
