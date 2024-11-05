package com.coderobust.loanmanagementapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.coderobust.loanmanagementapp.data.LoanReturnHistory

@Dao
interface LoanReturnHistoryDao {

    @Query("Select * from LoanReturnHistory where id=:id")
    fun getItemById(id:Int): LoanReturnHistory

    @Query("Select * from LoanReturnHistory where loanItemId=:id order by id desc")
    fun getAllById(id:Int) : List<LoanReturnHistory>

    @Insert
    fun save(item: LoanReturnHistory)
    @Update
    fun update(item: LoanReturnHistory)

    @Delete
    fun delete(item: LoanReturnHistory)
}