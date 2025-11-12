package com.example.madproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.madproject.databinding.ClaimItemBinding
import com.example.madproject.db.entities.Claim

class ClaimsAdapter(private val viewModel: ClaimsViewModel) : ListAdapter<Claim, ClaimsAdapter.ClaimViewHolder>(ClaimDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
    ClaimViewHolder {
        val binding = ClaimItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClaimViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClaimViewHolder, position: Int) {
        val claim = getItem(position)
        holder.bind(claim, viewModel)
    }

    class ClaimViewHolder(private val binding: ClaimItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(claim: Claim, viewModel: ClaimsViewModel) {
            binding.claim = claim
            binding.viewModel = viewModel

            binding.editClaimButton.setOnClickListener {
                binding.editAmountEditText.visibility = View.VISIBLE
                binding.updateClaimButton.visibility = View.VISIBLE
                binding.editClaimButton.visibility = View.GONE
                binding.editAmountEditText.setText(claim.amount.toString())
            }

            binding.updateClaimButton.setOnClickListener {
                val newAmount = binding.editAmountEditText.text.toString().toDoubleOrNull()
                if (newAmount != null) {
                    viewModel.updateClaimAmount(claim, newAmount)
                }
                binding.editAmountEditText.visibility = View.GONE
                binding.updateClaimButton.visibility = View.GONE
                binding.editClaimButton.visibility = View.VISIBLE
            }
        }
    }

    class ClaimDiffCallback : DiffUtil.ItemCallback<Claim>() {
        override fun areItemsTheSame(oldItem: Claim, newItem: Claim): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Claim, newItem: Claim): Boolean {
            return oldItem == newItem
        }
    }
}
