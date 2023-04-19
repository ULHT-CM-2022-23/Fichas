package com.github.mstavares.cm.acalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mstavares.cm.acalculator.databinding.FragmentCalculatorBinding
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding
    private lateinit var viewModel: CalculatorViewModel
    private val adapter = HistoryAdapter(::onOperationClick)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)
        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)
        binding = FragmentCalculatorBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.rvHistory?.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHistory?.adapter = adapter
        adapter.updateItems(viewModel.getHistory())
        binding.textVisor.text = viewModel.getDisplay()
        binding.button0.setOnClickListener { onClickSymbol("0") }
        binding.button00.setOnClickListener { onClickSymbol("00") }
        binding.button1.setOnClickListener { onClickSymbol("1") }
        binding.button2.setOnClickListener { onClickSymbol("2") }
        binding.button3.setOnClickListener { onClickSymbol("3") }
        binding.button4.setOnClickListener { onClickSymbol("4") }
        binding.button5.setOnClickListener { onClickSymbol("5") }
        binding.button6.setOnClickListener { onClickSymbol("6") }
        binding.button7.setOnClickListener { onClickSymbol("7") }
        binding.button8.setOnClickListener { onClickSymbol("8") }
        binding.button9.setOnClickListener { onClickSymbol("9") }
        binding.buttonDot.setOnClickListener { onClickSymbol(".") }
        binding.buttonAdition.setOnClickListener { onClickSymbol("+") }
        binding.buttonSubtraction.setOnClickListener { onClickSymbol("-") }
        binding.buttonMultiplication.setOnClickListener { onClickSymbol("*") }
        binding.buttonDivision.setOnClickListener { onClickSymbol("/") }
        binding.buttonClear.setOnClickListener { onClickClear() }
        binding.buttonBackspace.setOnClickListener { onClickBackspace() }
        binding.buttonPrev.setOnClickListener { onClickGetPreviousOperation() }
        binding.buttonEquals.setOnClickListener { onClickEquals() }
    }

    private fun onClickSymbol(symbol: String) {
        viewModel.addSymbol(symbol)
        binding.textVisor.text = viewModel.getDisplay()
    }

    private fun onClickEquals() {
        viewModel.equals()
        binding.textVisor.text = viewModel.getDisplay()
        adapter.updateItems(viewModel.getHistory())
    }

    private fun onClickClear() {
        viewModel.clear()
        binding.textVisor.text = viewModel.getDisplay()
    }

    private fun onClickBackspace() {
        viewModel.backspace()
        binding.textVisor.text = viewModel.getDisplay()
    }

    private fun onClickGetPreviousOperation() {
        viewModel.showLastOperation()
        binding.textVisor.text = viewModel.getDisplay()
    }

    private fun onOperationClick(uuid: String) {
        Toast.makeText(requireContext(), uuid, Toast.LENGTH_LONG).show()
    }

}