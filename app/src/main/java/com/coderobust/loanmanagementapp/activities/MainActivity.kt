package com.coderobust.loanmanagementapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.coderobust.loanmanagementapp.room.AppDatabase
import com.coderobust.loanmanagementapp.adapters.GenericAdapter
import com.coderobust.loanmanagementapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appDatabase= AppDatabase.getDatabase(this)

        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this, AddLoanItemActivity::class.java))
        }

        binding.recyclerview.layoutManager=LinearLayoutManager(this)


    }

    override fun onResume() {
        super.onResume()
        val adapter: GenericAdapter = GenericAdapter(appDatabase.loanItemDao().getAll())
        binding.recyclerview.adapter=adapter
        binding.receivables.text=appDatabase.loanItemDao().getReceivableAmount().toString()
        binding.payables.text=appDatabase.loanItemDao().getPayableAmount().toString()
        binding.account.text=(appDatabase.loanItemDao().getReceivableAmount()-appDatabase.loanItemDao().getPayableAmount()).toString()
    }
}