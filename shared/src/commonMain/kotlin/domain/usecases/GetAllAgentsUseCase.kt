package domain.usecases

import domain.model.Agent
import domain.repository.AgentRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.CommonFlow
import utils.asCommonFlow
import utils.asListWrapper
import utils.network.ListWrapper
import utils.network.Resource

class GetAllAgentsUseCase : KoinComponent {
    private val repository by inject<AgentRepository>()

//    private val localDataSource:LocalDataSource = LocalDataSourceImpl(databaseDriverFactory)
//    private val remoteDataSource:RemoteDataSource = RemoteDataSourceImpl()
//    private val repository:AgentRepository = AgentRepositoryImpl(localDataSource, remoteDataSource)

    operator fun invoke():Flow<Resource<ListWrapper<Agent>>> = repository.getAllAgents().asListWrapper()

    val allAgents: CommonFlow<Resource<ListWrapper<Agent>>> = invoke().asCommonFlow()

}