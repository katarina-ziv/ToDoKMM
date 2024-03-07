package com.example.todo.data.local

import app.cash.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
    fun createDriver() : SqlDriver
    //moramo da napravimo implementaciju ove funkcije za andrpid i iOS
}