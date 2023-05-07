package com.github.mstavares.cm.acalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mstavares.cm.acalculator.databinding.FragmentHistoryBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryFragment : Fragment() {

    private lateinit var adapter: HistoryAdapter
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var calculator: Calculator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_history, container, false)
        adapter = HistoryAdapter(::onOperationClick)
        binding = FragmentHistoryBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        calculator = CalculatorRoom(CalculatorDatabase.getInstance(requireContext()).operationDao())
        binding.rvHistory.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHistory.adapter = adapter
        CoroutineScope(Dispatchers.IO).launch {
            calculator.getHistory { history ->
                CoroutineScope(Dispatchers.Main).launch {
                    adapter.updateItems(history)
                }
            }
        }
    }

    private fun onOperationClick(uuid: String) {
        NavigationManager.goToOperationDetailFragment(parentFragmentManager, uuid)
    }

}