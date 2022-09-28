package io.armory.plugin.stage.randomwait

import com.netflix.spinnaker.kork.plugins.api.spring.ExposeToApp
import com.netflix.spinnaker.orca.api.pipeline.graph.StageDefinitionBuilder
import com.netflix.spinnaker.orca.api.pipeline.graph.TaskNode
import com.netflix.spinnaker.orca.api.pipeline.models.StageExecution
import org.springframework.stereotype.Component

/**
 * By implementing StageDefinitionBuilder, your stage is available for use in Spinnaker.
 * @see com.netflix.spinnaker.orca.api.StageDefinitionBuilder
 */
@Component
@ExposeToApp
class RandomWaitStage : StageDefinitionBuilder {

    /**
     * This function describes the sequence of substeps, or "tasks" that comprise this
     * stage. The task graph is generally linear though there are some looping mechanisms.
     *
     * This method is called just before a stage is executed. The task graph can be generated
     * programmatically based on the stage's context.
     */
    override fun taskGraph(stage: StageExecution, builder: TaskNode.Builder) {
        builder.withTask("randomWait", RandomWaitTask::class.java)
    }
}
