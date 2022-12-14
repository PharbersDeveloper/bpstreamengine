package com.pharbers.StreamEngine.Utils.Module.baseModules

import com.pharbers.StreamEngine.Utils.Module.moduleConfig.{ConfigImpl, ModuleConfig}


trait PharbersModule extends ModuleConfig {
    val id = "pharbers module"
    val configPath : String

    lazy val configDir : String = System.getProperty("user.dir")
    import ModuleConfig.f
    import ModuleConfig.fr
    lazy val config : ConfigImpl = loadConfig(configDir + "/" + configPath)

    def init : Unit = Unit
    def terminate : Unit = Unit
}
