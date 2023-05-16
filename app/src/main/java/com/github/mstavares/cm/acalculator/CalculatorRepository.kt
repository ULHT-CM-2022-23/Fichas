package com.github.mstavares.cm.acalculator

import android.content.Context

class CalculatorRepository(
  private val context: Context,
  private val local: Calculator,
  private val remote: Calculator
) {

  val display: String
    get() = local.display

  fun addSymbol(symbol: String) {
    local.addSymbol(symbol)
  }

  fun clear() {
    local.clear()
  }

  fun backspace() {
    local.backspace()
  }

  suspend fun equals() {
    local.equals()
  }

  suspend fun showLastOperation(onFinished: () -> Unit) {
    local.showLastOperation(onFinished)
  }

  suspend fun getHistory(onFinished: (Result<List<Operation>>) -> Unit) {
    if(ConnectivityUtil.isOnline(context)) {
      remote.getHistory { result ->
        if(result.isSuccess) {
          refreshHistory {
            local.getHistory { result ->
              onFinished(result)
            }
          }
        }
      }
    } else {
      local.getHistory { result ->
        onFinished(result)
      }
    }
  }

  private fun refreshHistory(onFinished: () -> Unit) {
    if(ConnectivityUtil.isOnline(context)) {
      remote.getHistory { result ->
        if(result.isSuccess) {
          local.insertRemoteHistory(result.getOrDefault(mutableListOf())) {
            onFinished()
          }
        } else {
          onFinished()
        }
      }
    }
  }

}