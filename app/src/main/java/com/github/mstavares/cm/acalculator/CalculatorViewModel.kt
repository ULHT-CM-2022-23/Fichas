package com.github.mstavares.cm.acalculator

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

  //private val calculator = Calculator()

  fun getDisplay() = Calculator.display

  fun getHistory() = Calculator.history

  fun addSymbol(symbol: String) {
    Calculator.addSymbol(symbol)
  }

  fun equals() {
    Calculator.equals()
  }

  fun clear() {
    //calculator.clear()
  }

  fun backspace() {
    //calculator.backspace()
  }

  fun showLastOperation() {
    //calculator.showLastOperation()
  }

}