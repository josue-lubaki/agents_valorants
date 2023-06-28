package domain.usecases

import domain.model.Agent
import domain.repository.AgentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.CommonFlow
import utils.asCommonFlow
import utils.asListWrapper
import utils.network.ListWrapper
import utils.network.Resource

/**
 * created by Josue Lubaki
 * date : 2023-06-27
 * version : 1.0.0
 */

class GetAgentUseCase : KoinComponent {
    private val repository by inject<AgentRepository>()

    operator fun invoke(uuid : String = "") : Flow<Resource<ListWrapper<Agent>>>  = repository.getAgent(uuid).asListWrapper()
    val agent: CommonFlow<Resource<ListWrapper<Agent>>> = invoke().asCommonFlow()

//    suspend operator fun invoke(agentId: String) = repository.getAgent(agentId)
}