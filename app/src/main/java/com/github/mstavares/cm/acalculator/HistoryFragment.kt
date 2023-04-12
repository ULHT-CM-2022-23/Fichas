package com.github.mstavares.cm.acalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mstavares.cm.acalculator.databinding.FragmentCalculatorBinding
import com.github.mstavares.cm.acalculator.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private val adapter = HistoryAdapter(::onOperationClick, ::onOperationLongClick, Calculator.history)
    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_history, container, false)
        binding = FragmentHistoryBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.rvHistory.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHistory.adapter = adapter
    }

    private fun onOperationClick(operation: Operation) {
        NavigationManager.goToOperationDetailFragment(
            parentFragmentManager, null, OperationUi.fromOperation(operation)
        )
    }

    private fun onOperationLongClick(uuid: String) {
        NavigationManager.goToOperationDetailFragment(
            parentFragmentManager, uuid, null
        )
    }

}