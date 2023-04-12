package com.github.mstavares.cm.acalculator

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class OperationUi(
  val expression: String, val result: String,
  val timestamp: Long, val uuid: String
) : Parcelable {

  companion object {

    fun fromOperation(from: Operation): OperationUi {
      return OperationUi(from.expression, from.result, from.timestamp, from.uuid)
    }

  }

}