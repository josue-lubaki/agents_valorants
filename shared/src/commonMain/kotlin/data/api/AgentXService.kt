package data.api

import data.model.AgentDTO
import data.model.Response
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.util.StringValues
import utils.URL

/**
 * created by Josue Lubaki
 * date : 2023-06-24
 * version : 1.0.0
 */

internal class AgentXService : Api() {
    suspend fun getAllAgents() : Response<List<AgentDTO>> = client.get {
        parameterUrl(URL.AGENTS, URL.AGENTS_PARAMS)
    }.body()
}