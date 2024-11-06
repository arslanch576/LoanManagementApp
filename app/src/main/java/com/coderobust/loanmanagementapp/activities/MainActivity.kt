package com.coderobust.loanmanagementapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.coderobust.loanmanagementapp.room.AppDatabase
import com.coderobust.loanmanagementapp.adapters.GenericAdapter
import com.coderobust.loanmanagementapp.data.LoanItem
import com.coderobust.loanmanagementapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var appDatabase: AppDatabase
    var items=ArrayList<LoanItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appDatabase= AppDatabase.getDatabase(this)

        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this, AddLoanItemActivity::class.java))
        }

        binding.recyclerview.layoutManager=LinearLayoutManager(this)
        val adapter: GenericAdapter = GenericAdapter(items)
        binding.recyclerview.adapter=adapter

        appDatabase.loanItemDao().getAllLive().observe(this, Observer {
            items.clear()
            items.addAll(it)
            adapter.notifyDataSetChanged()
            binding.receivables.text=appDatabase.loanItemDao().getReceivableAmount().toString()
            binding.payables.text=appDatabase.loanItemDao().getPayableAmount().toString()
            binding.account.text=(appDatabase.loanItemDao().getReceivableAmount()-appDatabase.loanItemDao().getPayableAmount()).toString()
        })

    }
}