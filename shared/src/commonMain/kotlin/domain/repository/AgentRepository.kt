package domain.repository

import domain.model.Agent
import kotlinx.coroutines.flow.Flow
import utils.network.Resource

interface AgentRepository {
    fun getAllAgents():Flow<Resource<List<Agent>>>
}