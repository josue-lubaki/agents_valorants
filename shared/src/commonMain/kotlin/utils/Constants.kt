package utils

import io.ktor.util.StringValues

object URL {
    const val AGENTS = "agents"
    val AGENTS_PARAMS = StringValues.build {
        this.append("isPlayableCharacter", "true")
    }
}