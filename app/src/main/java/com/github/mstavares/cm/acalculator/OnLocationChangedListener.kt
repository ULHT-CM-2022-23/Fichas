package com.github.mstavares.cm.acalculator

interface OnLocationChangedListener {

  // Aqui não vamos transferir um objeto Android, mas sim a latitude
  // e longitude para que a interface não dependa da framework Android
  fun onLocationChanged(latitude: Double, longitude: Double)

}
