package project_group.project_name.replier

import dev.inmo.micro_utils.fsm.common.State
import dev.inmo.plagubot.Plugin
import dev.inmo.tgbotapi.extensions.api.send.reply
import dev.inmo.tgbotapi.extensions.behaviour_builder.BehaviourContextWithFSM
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onContentMessage
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import org.koin.core.Koin
import org.koin.core.module.Module
import project_group.project_name.replier.models.ReplierConfig

object ReplierPlugin : Plugin {
    override fun Module.setupDI(config: JsonObject) {
        single<ReplierConfig> {
            get<Json>().decodeFromJsonElement(ReplierConfig.serializer(), config["replier"]!!.jsonObject)
        }
    }
    override suspend fun BehaviourContextWithFSM<State>.setupBotPlugin(koin: Koin) {
        val config = koin.get<ReplierConfig>()
        onContentMessage {
            reply(it, config.answer)
        }
    }
}