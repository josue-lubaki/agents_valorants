package data.datasource

import data.model.AgentDTO
import data.model.Response

interface RemoteDataSource {
    suspend fun getAllAgents(): Response<List<AgentDTO>>
    suspend fun getAgent(uuid: String): Response<AgentDTO>
}