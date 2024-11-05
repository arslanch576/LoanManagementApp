package com.coderobust.loanmanagementapp.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.coderobust.loanmanagementapp.data.LoanReturnHistory
import com.coderobust.loanmanagementapp.databinding.ItemLoanReturnHistoryBinding

class LoanReturnHistoryViewHolder(val binding: ItemLoanReturnHistoryBinding) : BaseViewHolder(binding) {
    override fun bind(data:Any){
        val item=data as LoanReturnHistory
        binding.date.text = item.returnDate
        binding.amount.text = item.returnAmount.toString()
    }
}