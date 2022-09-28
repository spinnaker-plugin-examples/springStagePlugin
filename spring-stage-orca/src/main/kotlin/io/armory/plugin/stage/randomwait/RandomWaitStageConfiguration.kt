package io.armory.plugin.stage.randomwait

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(RandomWaitProperties::class)
class RandomWaitStageConfiguration {

}
