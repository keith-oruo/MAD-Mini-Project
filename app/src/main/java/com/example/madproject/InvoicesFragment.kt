package com.example.madproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madproject.databinding.FragmentInvoicesBinding

class InvoicesFragment : Fragment() {

    private lateinit var binding: FragmentInvoicesBinding
    private val viewModel: InvoicesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_invoices, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = InvoicesAdapter()
        binding.invoicesRecyclerView.adapter = adapter
        binding.invoicesRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.invoices.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return binding.root
    }
}
