package com.coderobust.loanmanagementapp

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.coderobust.loanmanagementapp.databinding.ItemLoanBinding
import com.coderobust.loanmanagementapp.databinding.ItemLoanReturnHistoryBinding

class LoanReturnHistoryRecyclerAdapter(val items: List<LoanReturnHistory>) : RecyclerView.Adapter<LoanReturnHistoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoanReturnHistoryViewHolder {
        return LoanReturnHistoryViewHolder(
            ItemLoanReturnHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LoanReturnHistoryViewHolder, position: Int) {
        val item = items.get(position)
        holder.binding.date.text = item.returnDate
        holder.binding.amount.text = item.returnAmount.toString()

    }

}