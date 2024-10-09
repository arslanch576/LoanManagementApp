package com.coderobust.loanmanagementapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LoanRecyclerAdapter(val items:List<LoanItem>): RecyclerView.Adapter<LoanItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoanItemViewHolder {
        return LoanItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_loan,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LoanItemViewHolder, position: Int) {
        val item=items.get(position)
        //TODO: Bind item data
    }

}