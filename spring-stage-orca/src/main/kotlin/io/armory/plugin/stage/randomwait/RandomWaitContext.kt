package io.armory.plugin.stage.randomwait

/**
 * Context is used within the stage itself and returned to the Orca pipeline execution.
 */
data class RandomWaitContext(var maxWaitTime: Int?)
