package data.db

import com.myapplication.database.AgentXDatabase
import com.squareup.sqldelight.db.SqlDriver
import org.koin.core.scope.Scope

expect fun Scope.sqlDriverFactory(): SqlDriver
fun createDatabase(driver: SqlDriver): AgentXDatabase = AgentXDatabase(driver = driver)
