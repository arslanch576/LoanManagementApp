package com.coderobust.loanmanagementapp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.coderobust.loanmanagementapp.data.LoanItem
import com.coderobust.loanmanagementapp.adapters.viewholders.LoanItemViewHolder
import com.coderobust.loanmanagementapp.R
import com.coderobust.loanmanagementapp.activities.LoanItemDetailActivity
import com.coderobust.loanmanagementapp.adapters.viewholders.BaseViewHolder
import com.coderobust.loanmanagementapp.adapters.viewholders.LoanReturnHistoryViewHolder
import com.coderobust.loanmanagementapp.data.LoanReturnHistory
import com.coderobust.loanmanagementapp.databinding.ItemLoanBinding
import com.coderobust.loanmanagementapp.databinding.ItemLoanReturnHistoryBinding

class GenericAdapter(val items: List<Any>) : RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        if (viewType == 0)
            return LoanItemViewHolder(
                ItemLoanBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        else
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

    override fun getItemViewType(position: Int): Int {
        if (items.get(position) is LoanItem) return 0
        else return 1
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items.get(position))

    }

}