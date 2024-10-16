package com.coderobust.loanmanagementapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.coderobust.loanmanagementapp.databinding.ItemLoanBinding

class LoanRecyclerAdapter(val items: List<LoanItem>) : RecyclerView.Adapter<LoanItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoanItemViewHolder {
        return LoanItemViewHolder(
            ItemLoanBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LoanItemViewHolder, position: Int) {
        val item = items.get(position)
        holder.binding.name.text = item.recipientName
        holder.binding.amount.text = if (item.isBorrowed) "-" else "+" + item.amount.toString()
        holder.binding.amount.setTextColor(ContextCompat.getColor(holder.itemView.context, if (item.isBorrowed) R.color.red else R.color.green))

    }

}