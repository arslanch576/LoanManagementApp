package com.coderobust.loanmanagementapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoanItemDao {

    @Query("Select * from LoanItem order by id desc")
    fun getAll() : List<LoanItem>

    @Insert
    fun save(item: LoanItem)

    @Delete
    fun delete(item: LoanItem)
}