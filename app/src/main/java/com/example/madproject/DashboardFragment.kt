package com.example.madproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.madproject.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)

        binding.claimsButton.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_claimsFragment)
        }

        binding.invoicesButton.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_invoicesFragment)
        }

        binding.messagesButton.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_messagesFragment)
        }

        binding.auditLogsButton.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_auditLogsFragment)
        }

        binding.profileButton.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_profileFragment)
        }

        return binding.root
    }
}
