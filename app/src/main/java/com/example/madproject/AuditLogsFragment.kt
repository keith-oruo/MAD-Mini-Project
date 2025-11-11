package com.example.madproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madproject.databinding.FragmentAuditLogsBinding

class AuditLogsFragment : Fragment() {

    private lateinit var binding: FragmentAuditLogsBinding
    private val viewModel: AuditLogsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_audit_logs, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = AuditLogsAdapter()
        binding.auditLogsRecyclerView.adapter = adapter
        binding.auditLogsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.allAuditLogs.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return binding.root
    }
}
