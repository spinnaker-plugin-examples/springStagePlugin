package io.armory.plugin.stage.randomwait

import com.netflix.spinnaker.kork.plugins.api.spring.ExposeToApp
import com.netflix.spinnaker.orca.api.pipeline.Task
import com.netflix.spinnaker.orca.api.pipeline.TaskResult
import com.netflix.spinnaker.orca.api.pipeline.models.ExecutionStatus
import com.netflix.spinnaker.orca.api.pipeline.models.StageExecution
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*
import java.util.concurrent.TimeUnit

@Component
@ExposeToApp
class RandomWaitTask(private val config: RandomWaitProperties) : Task {

    private val log = LoggerFactory.getLogger(RandomWaitTask::class.java)

    /**
     * This method is called when the task is executed.
     */
    override fun execute(stage: StageExecution): TaskResult {
        val context = stage.mapTo(RandomWaitContext::class.java)
        val rand = Random()
        val maxWaitTime = context.maxWaitTime ?: config.defaultMaxWaitTime ?: 0
        val timeToWait = rand.nextInt(maxWaitTime)

        try {
            TimeUnit.SECONDS.sleep(timeToWait.toLong())
        } catch (e: Exception) {
            log.error("{}", e)
        }

        return TaskResult.builder(ExecutionStatus.SUCCEEDED)
                .context(mutableMapOf("maxWaitTime" to maxWaitTime))
                .outputs(mutableMapOf("timeToWait" to timeToWait))
                .build()
    }
}
