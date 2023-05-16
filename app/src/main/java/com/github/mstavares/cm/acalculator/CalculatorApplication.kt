package com.github.mstavares.cm.acalculator

import android.app.Application

class CalculatorApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    FusedLocation.start(this)
  }

}