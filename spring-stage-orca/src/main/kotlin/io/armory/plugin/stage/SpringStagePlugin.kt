package io.armory.plugin.stage

import com.netflix.spinnaker.kork.plugins.api.spring.SpringLoaderPlugin
import org.pf4j.PluginWrapper
import org.slf4j.LoggerFactory

class SpringStagePlugin(wrapper: PluginWrapper) : SpringLoaderPlugin(wrapper) {
  private val logger = LoggerFactory.getLogger(SpringStagePlugin::class.java)


  override fun getPackagesToScan(): List<String> {
    return listOf(
            "io.armory.plugin.stage.randomwait"
    )
  }

  override fun start() {
    logger.info("SpringStagePlugin.start()")
  }

  override fun stop() {
    logger.info("SpringStagePlugin.stop()")
  }
}
