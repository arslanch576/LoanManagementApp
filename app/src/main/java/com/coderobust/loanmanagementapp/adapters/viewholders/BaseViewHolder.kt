package com.coderobust.loanmanagementapp.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder(binding:ViewBinding): RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item:Any)
}