package io.armory.plugin.stage.randomwait

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("random-wait-properties")
data class RandomWaitProperties(var defaultMaxWaitTime: Int? = null)
