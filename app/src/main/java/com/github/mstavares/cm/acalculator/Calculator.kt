package com.github.mstavares.cm.acalculator

import net.objecthunter.exp4j.ExpressionBuilder

abstract class Calculator {

  var display: String = "0"
    protected set

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

  /** Preciso de uma callback aqui, pois não sei quanto tempo a operação demora a ser executada.
   *  Esta informação é necessária porque preciso de atualizar a view com base no novo display atualizado
   */
  abstract fun showLastOperation(onFinished: () -> Unit)
  abstract fun insertRemoteHistory(operations: List<Operation>, onFinished: () -> Unit)
  abstract fun getHistory(onFinished: (Result<List<Operation>>) -> Unit)

}
