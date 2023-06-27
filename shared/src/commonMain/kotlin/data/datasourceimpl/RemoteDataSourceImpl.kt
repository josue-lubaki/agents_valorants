package data.datasourceimpl

import data.api.AgentXService
import data.datasource.RemoteDataSource
import data.model.AgentDTO
import data.model.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSourceImpl(
    private val service : AgentXService,
    private val dispatcher: CoroutineDispatcher
) : RemoteDataSource {
    override suspend fun getAllAgents(): Response<List<AgentDTO>> {
        return withContext(dispatcher) {
            service.getAllAgents()
        }
    }
}
