package com.example.madproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madproject.databinding.FragmentClaimsBinding

class ClaimsFragment : Fragment() {

    private lateinit var binding: FragmentClaimsBinding
    private val viewModel: ClaimsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_claims, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = ClaimsAdapter(viewModel)
        binding.claimsRecyclerView.adapter = adapter
        binding.claimsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.allClaims.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.submitClaimButton.setOnClickListener {
            val description = binding.claimDescriptionEditText.text.toString()
            viewModel.submitClaim(description)
            binding.claimDescriptionEditText.text.clear()
        }

        return binding.root
    }
}
