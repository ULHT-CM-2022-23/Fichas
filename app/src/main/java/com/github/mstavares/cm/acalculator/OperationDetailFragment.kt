package com.github.mstavares.cm.acalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mstavares.cm.acalculator.databinding.FragmentOperationDetailBinding

private const val ARG_OPERATION_UUID = "ARG_OPERATION_UUID"

class OperationDetailFragment : Fragment() {

  private lateinit var binding: FragmentOperationDetailBinding
  private var operationUuid: String? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {
      operationUuid = it.getString(ARG_OPERATION_UUID)
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_operation_detail, container, false)
    binding = FragmentOperationDetailBinding.bind(view)
    return binding.root
  }

  override fun onStart() {
    super.onStart()
    operationUuid?.let { uuid ->
      /*
      TODO
      val operation = Calculator.getOperationById(uuid)
      operation?.let { placeData(it) }
       */
    }
  }

  private fun placeData(ui: Operation) {
    binding.tvExpression.text = ui.expression
    binding.tvResult.text = ui.result
    binding.tvTimestamp.text = ui.timestamp.toString()
    binding.tvUuid.text = ui.uuid
  }

  companion object {

    @JvmStatic
    fun newInstance(uuid: String) =
      OperationDetailFragment().apply {
        arguments = Bundle().apply {
          putString(ARG_OPERATION_UUID, uuid)
        }
      }
  }
}