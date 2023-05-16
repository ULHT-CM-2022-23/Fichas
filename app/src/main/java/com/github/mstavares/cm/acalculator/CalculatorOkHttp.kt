package com.github.mstavares.cm.acalculator

import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class CalculatorOkHttp(
  private val url: String,
  private val apiKey: String,
  private val client: OkHttpClient
) : Calculator() {

  override fun getHistory(onFinished: (Result<List<Operation>>) -> Unit) {
    val request = Request.Builder()
      .addHeader("apiKey", apiKey)
      .url("$url/operations")
      .build()

    client.newCall(request).enqueue(object : Callback {

      override fun onFailure(call: Call, e: IOException) {
        onFinished(Result.failure(e))
      }

      override fun onResponse(call: Call, response: Response) {
        if(!response.isSuccessful) {
          onFinished(Result.failure(IOException("Error: $response")))
        } else {
          val body = response.body?.string()
          if(body != null) {
            val jsonOperations = JSONArray(body)
            val operations = mutableListOf<Operation>()
            for(i in 0 until jsonOperations.length()) {
              val jsonOperation = jsonOperations.getJSONObject(i)
              operations.add(
                Operation(
                jsonOperation.getString("expression"),
                jsonOperation.getString("result"),
                jsonOperation.getLong("timestamp"),
                jsonOperation.getString("uuid")
              ))
            }
            onFinished(Result.success(operations))
          }
        }
      }
    })
  }

  override fun showLastOperation(onFinished: () -> Unit) {
    throw Exception("Illegal operation")
  }

  override fun insertRemoteHistory(operations: List<Operation>, onFinished: () -> Unit) {
    throw Exception("Illegal operation")
  }

}