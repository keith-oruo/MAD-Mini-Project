package com.example.madproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.madproject.db.AppDatabase
import com.example.madproject.db.entities.Invoice

class InvoicesViewModel(application: Application) : AndroidViewModel(application) {

    private val invoiceDao = AppDatabase.getDatabase(application).invoiceDao()

    // TODO: This should be dynamic based on the selected claim
    val invoices: LiveData<List<Invoice>> = invoiceDao.getInvoicesForClaim(1)
}
