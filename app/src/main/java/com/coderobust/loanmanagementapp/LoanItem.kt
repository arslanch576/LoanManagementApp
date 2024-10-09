package com.coderobust.loanmanagementapp

class LoanItem(
    val id: Int,
    val amount: Int,
    val recipientName: String,
    val startDate: String,
    val isGiven: Boolean,
    val isReturned: Boolean,
    val returnDate: String,
    val returnAmount: Int,
    val purpose: String,
    val notes: String,
    val promiseDate: String,
)