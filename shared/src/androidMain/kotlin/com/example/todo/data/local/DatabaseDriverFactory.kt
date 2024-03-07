package com.example.todo.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.todo.database.TodoDatabase

actual class DatabaseDriverFactory(private val context: Context) {

    actual fun createDriver() : SqlDriver{
        return AndroidSqliteDriver(TodoDatabase.Schema,context,"todo.db")
    }
}