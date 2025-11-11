package com.example.madproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.madproject.db.entities.Claim
import com.example.madproject.databinding.ListItemClaimBinding

class ClaimsAdapter : ListAdapter<Claim, ClaimsAdapter.ClaimViewHolder>(ClaimsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ClaimViewHolder {
        return ClaimViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ClaimViewHolder, position: Int) {
        val claim = getItem(position)
        holder.bind(claim)
    }

    class ClaimViewHolder(private val binding: ListItemClaimBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(claim: Claim) {
            binding.claim = claim
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ClaimViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemClaimBinding.inflate(layoutInflater, parent, false)
                return ClaimViewHolder(binding)
            }
        }
    }
}

class ClaimsDiffCallback : DiffUtil.ItemCallback<Claim>() {
    override fun areItemsTheSame(oldItem: Claim, newItem: Claim): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Claim, newItem: Claim): Boolean {
        return oldItem == newItem
    }
}
