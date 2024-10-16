package com.coderobust.loanmanagementapp

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.coderobust.loanmanagementapp.databinding.ActivityAddLoanItemBinding

class AddLoanItemActivity : AppCompatActivity() {

    lateinit var binding:ActivityAddLoanItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddLoanItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.save.setOnClickListener {
            val loanItem=LoanItem()
            loanItem.recipientName=binding.recipientName.editText?.text.toString()
            loanItem.amount=binding.amount.editText?.text.toString().toInt()
            loanItem.startDate=binding.startDate.editText?.text.toString()
            loanItem.promiseDate=binding.promiseDate.editText?.text.toString()
            loanItem.notes=binding.notes.editText?.text.toString()
            loanItem.purpose=binding.purpose.editText?.text.toString()
            loanItem.isBorrowed=binding.toggleButton.checkedButtonId==R.id.borrowing

            val appDatabase=AppDatabase.getDatabase(this)
            appDatabase.loanItemDao().save(loanItem)
            Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}