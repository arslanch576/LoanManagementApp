package com.coderobust.loanmanagementapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LoanItem::class,LoanReturnHistory::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun loanItemDao(): LoanItemDao
    abstract fun loanReturnHistoryDao(): LoanReturnHistoryDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getDatabase(ctx: Context): AppDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(
                    ctx, AppDatabase::class.java,
                    "database_v2"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()

            return instance!!

        }
    }
}
