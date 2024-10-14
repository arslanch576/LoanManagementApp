package com.coderobust.loanmanagementapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class LoanItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var amount: Int,
    var recipientName: String,
    var startDate: String,
    var isBorrowed: Boolean,
    var isReturned: Boolean,
    var returnDate: String,
    var returnAmount: Int,
    var purpose: String,
    var notes: String,
    var promiseDate: String,
){
    constructor() : this(0,0,"","",true,false,"",0,"","","")
}