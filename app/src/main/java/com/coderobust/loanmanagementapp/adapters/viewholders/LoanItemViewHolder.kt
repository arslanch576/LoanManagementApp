package com.coderobust.loanmanagementapp.adapters.viewholders

import android.content.DialogInterface
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.coderobust.loanmanagementapp.R
import com.coderobust.loanmanagementapp.activities.AddLoanItemActivity
import com.coderobust.loanmanagementapp.activities.LoanItemDetailActivity
import com.coderobust.loanmanagementapp.data.LoanItem
import com.coderobust.loanmanagementapp.databinding.ItemLoanBinding
import com.coderobust.loanmanagementapp.room.AppDatabase
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LoanItemViewHolder(val binding: ItemLoanBinding) : BaseViewHolder(binding) {
    override fun bind(data:Any){
        val item=data as LoanItem
        binding.name.text = item.recipientName
        binding.amount.text =
            (if (item.isBorrowed) "-" else "+") + item.amount.toString()
        binding.amount.setTextColor(
            ContextCompat.getColor(
                itemView.context,
                if (item.isBorrowed) R.color.red else R.color.green
            )
        )
        if (item.amount == item.returnAmount) {
            binding.status.setText("Returned")
        } else if (item.returnAmount == 0) {
            binding.status.setText("Not returned")
        } else {
            binding.status.setText("Partially returned")
        }

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, LoanItemDetailActivity::class.java)
            intent.putExtra("id", item.id)
            itemView.context.startActivity(intent)

        }

        itemView.setOnLongClickListener {
            val builder=MaterialAlertDialogBuilder(itemView.context)
            builder.setItems(arrayOf("Edit","Delete"), DialogInterface.OnClickListener { dialog, which ->
                if(which==0){
                    itemView.context.startActivity(Intent(itemView.context,AddLoanItemActivity::class.java).putExtra("id",item.id))
                }else{
                    val warningBuilder=MaterialAlertDialogBuilder(itemView.context)
                    warningBuilder.setTitle("Sure to delete?")
                    warningBuilder.setMessage("The data will be deleted permanently, sure to delete?")
                    warningBuilder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                        AppDatabase.getDatabase(itemView.context).loanItemDao().delete(item)
                    })
                    warningBuilder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                        dialog.dismiss()
                    })
                    warningBuilder.show()

                }
            })
            builder.show()
            true
        }
    }
}