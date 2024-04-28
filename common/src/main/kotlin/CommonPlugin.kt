package project_group.project_name.common

import dev.inmo.micro_utils.fsm.common.State
import dev.inmo.plagubot.Plugin
import dev.inmo.tgbotapi.extensions.behaviour_builder.BehaviourContextWithFSM
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import org.koin.core.Koin
import org.koin.core.module.Module
import project_group.project_name.common.models.CommonConfig

object CommonPlugin : Plugin {
    override fun Module.setupDI(config: JsonObject) {
        single<CommonConfig> {
            get<Json>().decodeFromJsonElement(CommonConfig.serializer(), config["common"]!!.jsonObject)
        }
    }
    override suspend fun BehaviourContextWithFSM<State>.setupBotPlugin(koin: Koin) {
        val config = koin.get<CommonConfig>()
        println(config.sample)
    }
}