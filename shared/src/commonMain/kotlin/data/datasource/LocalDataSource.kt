package data.datasource

import database.AgentEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getAllAgents():Flow<List<AgentEntity>>
    suspend fun insertAgent(agents: List<AgentEntity>)
}