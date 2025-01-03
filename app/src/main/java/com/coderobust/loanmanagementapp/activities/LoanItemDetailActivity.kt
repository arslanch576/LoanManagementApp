package com.coderobust.loanmanagementapp.activities

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.coderobust.loanmanagementapp.adapters.GenericAdapter
import com.coderobust.loanmanagementapp.room.AppDatabase
import com.coderobust.loanmanagementapp.data.LoanItem
import com.coderobust.loanmanagementapp.data.LoanReturnHistory
import com.coderobust.loanmanagementapp.databinding.ActivityLoanItemDetailBinding
import com.coderobust.loanmanagementapp.databinding.DialogReturnLoanBinding

class LoanItemDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoanItemDetailBinding;
    lateinit var loanItem: LoanItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoanItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id=intent.getIntExtra("id",0)
        loanItem= AppDatabase.getDatabase(this).loanItemDao().getItemById(id)

        refresh()

        binding.returnLoan.setOnClickListener {
            val dialog = Dialog(this)
            val binding = DialogReturnLoanBinding.inflate(layoutInflater)
            dialog.setContentView(binding.root)

            binding.save.setOnClickListener {
                val returnAmount=binding.amount.editText?.text.toString().toInt()
                loanItem.amount=loanItem.amount-returnAmount
                loanItem.returnAmount=loanItem.returnAmount+returnAmount
                AppDatabase.getDatabase(this).loanItemDao().update(loanItem)

                val history= LoanReturnHistory(0,loanItem.id,returnAmount,binding.startDate.editText?.text.toString())
                AppDatabase.getDatabase(this).loanReturnHistoryDao().save(history)
                dialog.dismiss()
                refresh()

            }

            dialog.show()
        }

    }

    private fun refresh() {
        binding.name.text=loanItem.recipientName
        binding.amount.text=(if (loanItem.isBorrowed) "-" else "+") + loanItem.amount.toString()
        binding.returnAmount.text="Returned: "+loanItem.returnAmount.toString()
        binding.purpose.text="Purpose: "+loanItem.purpose
        binding.notes.text="Notes: "+loanItem.notes
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        val adapter=
            GenericAdapter(AppDatabase.getDatabase(this).loanReturnHistoryDao().getAllById(loanItem.id))
        binding.recyclerView.adapter=adapter
    }
}