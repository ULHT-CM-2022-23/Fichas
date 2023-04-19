package com.github.mstavares.cm.acalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mstavares.cm.acalculator.databinding.FragmentCalculatorBinding
import com.github.mstavares.cm.acalculator.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private lateinit var adapter: HistoryAdapter
    private lateinit var viewModel: CalculatorViewModel
    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_history, container, false)
        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)
        adapter = HistoryAdapter(::onOperationClick, viewModel.getHistory())
        binding = FragmentHistoryBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.rvHistory.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHistory.adapter = adapter
    }

    private fun onOperationClick(uuid: String) {
        NavigationManager.goToOperationDetailFragment(parentFragmentManager, uuid)
    }

}