package com.example.todo.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.todo.database.TodoDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver() : SqlDriver {
        return NativeSqliteDriver(TodoDatabase.Schema, "todo.db")
    }
}