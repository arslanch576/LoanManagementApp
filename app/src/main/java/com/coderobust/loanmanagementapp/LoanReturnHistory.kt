package com.coderobust.loanmanagementapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class LoanReturnHistory(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var loanItemId:Int,
    var returnAmount:Int,
    var returnDate:String
) {
}