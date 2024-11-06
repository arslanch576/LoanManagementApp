package com.coderobust.loanmanagementapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.coderobust.loanmanagementapp.data.LoanItem

@Dao
interface LoanItemDao {

    @Query("Select * from LoanItem where id=:id")
    fun getItemById(id:Int): LoanItem

    @Query("Select * from LoanItem order by id desc")
    fun getAll() : List<LoanItem>

    @Query("Select * from LoanItem order by id desc")
    fun getAllLive() : LiveData<List<LoanItem>>

    @Query("Select sum(amount) from LoanItem where isBorrowed=0")
    fun getReceivableAmount() : Int

    @Query("Select sum(amount) from LoanItem where isBorrowed=1")
    fun getPayableAmount() : Int

    @Insert
    fun save(item: LoanItem)
    @Update
    fun update(item: LoanItem)

    @Delete
    fun delete(item: LoanItem)
}