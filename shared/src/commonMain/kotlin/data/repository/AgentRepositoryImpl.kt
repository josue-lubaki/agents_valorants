package data.repository

import data.datasource.LocalDataSource
import data.datasource.RemoteDataSource
import data.mapper.toAgent
import data.mapper.toAgentEntity
import domain.model.Agent
import domain.repository.AgentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import utils.network.Resource
import utils.network.networkBoundResource

class AgentRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
): AgentRepository {


    override fun getAllAgents(): Flow<Resource<List<Agent>>>{
        return networkBoundResource(
            query = {
                localDataSource.getAllAgents().map {
                    it.map { it.toAgent() }
                }
            },
            fetch = {
                remoteDataSource.getAllAgents()
            },
            saveFetchResult = {
                val items = it.data.map { it.toAgentEntity() }
                localDataSource.insertAgent(items)
            }
        )
    }
}