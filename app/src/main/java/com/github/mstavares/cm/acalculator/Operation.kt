package com.github.mstavares.cm.acalculator

import java.util.Date
import java.util.UUID

data class Operation(
  val expression: String, val result: String, val timestamp: Long = Date().time,
  val uuid: String = UUID.randomUUID().toString()
)