package com.example.madproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.madproject.db.entities.AuditLog
import com.example.madproject.databinding.ListItemAuditLogBinding

class AuditLogsAdapter : ListAdapter<AuditLog, AuditLogsAdapter.AuditLogViewHolder>(AuditLogsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            AuditLogViewHolder {
        return AuditLogViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AuditLogViewHolder, position: Int) {
        val auditLog = getItem(position)
        holder.bind(auditLog)
    }

    class AuditLogViewHolder(private val binding: ListItemAuditLogBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(auditLog: AuditLog) {
            binding.auditLog = auditLog
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): AuditLogViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemAuditLogBinding.inflate(layoutInflater, parent, false)
                return AuditLogViewHolder(binding)
            }
        }
    }
}

class AuditLogsDiffCallback : DiffUtil.ItemCallback<AuditLog>() {
    override fun areItemsTheSame(oldItem: AuditLog, newItem: AuditLog): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AuditLog, newItem: AuditLog): Boolean {
        return oldItem == newItem
    }
}
