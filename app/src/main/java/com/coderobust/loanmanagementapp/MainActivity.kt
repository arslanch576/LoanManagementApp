package com.coderobust.loanmanagementapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.coderobust.loanmanagementapp.databinding.ActivityAddLoanItemBinding
import com.coderobust.loanmanagementapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var appDatabase:AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appDatabase=AppDatabase.getDatabase(this)

        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this, AddLoanItemActivity::class.java))
        }

        binding.recyclerview.layoutManager=LinearLayoutManager(this)


    }

    override fun onResume() {
        super.onResume()
        val adapter:LoanRecyclerAdapter=LoanRecyclerAdapter(appDatabase.loanItemDao().getAll())
        binding.recyclerview.adapter=adapter
        binding.receivables.text=appDatabase.loanItemDao().getReceivableAmount().toString()
        binding.payables.text=appDatabase.loanItemDao().getPayableAmount().toString()
        binding.account.text=(appDatabase.loanItemDao().getReceivableAmount()-appDatabase.loanItemDao().getPayableAmount()).toString()
    }
}