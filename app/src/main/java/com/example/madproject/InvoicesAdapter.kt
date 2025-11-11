package com.example.madproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.madproject.db.entities.Invoice
import com.example.madproject.databinding.ListItemInvoiceBinding

class InvoicesAdapter : ListAdapter<Invoice, InvoicesAdapter.InvoiceViewHolder>(InvoicesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            InvoiceViewHolder {
        return InvoiceViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: InvoiceViewHolder, position: Int) {
        val invoice = getItem(position)
        holder.bind(invoice)
    }

    class InvoiceViewHolder(private val binding: ListItemInvoiceBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(invoice: Invoice) {
            binding.invoice = invoice
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): InvoiceViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemInvoiceBinding.inflate(layoutInflater, parent, false)
                return InvoiceViewHolder(binding)
            }
        }
    }
}

class InvoicesDiffCallback : DiffUtil.ItemCallback<Invoice>() {
    override fun areItemsTheSame(oldItem: Invoice, newItem: Invoice): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Invoice, newItem: Invoice): Boolean {
        return oldItem == newItem
    }
}
