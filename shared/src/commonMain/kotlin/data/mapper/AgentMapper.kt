package data.mapper

import data.model.AgentDTO
import database.AgentEntity
import domain.model.Agent

internal fun AgentEntity.toAgent(): Agent {
    return Agent(
        uuid = this.uuid,
        backgroundGradientColors = this.backgroundGradientColors?.split(",")
            ?.let { listOf(*it.toTypedArray()) },
        displayName = this.displayName,
        displayIcon = this.displayIcon,
        fullPortrait = this.fullPortrait,
        background = this.background,
        role = this.role,
        description = this.description
    )
}

internal fun AgentDTO.toAgentEntity():AgentEntity {
    return  AgentEntity(
        uuid = this.uuid,
        backgroundGradientColors = this.backgroundGradientColors?.joinToString(separator = ",", prefix = "", postfix = ""),
        displayName = this.displayName,
        displayIcon = this.displayIcon,
        fullPortrait = this.fullPortrait,
        background = this.background,
        role = this.role?.displayName,
        description = this.description
    )
}