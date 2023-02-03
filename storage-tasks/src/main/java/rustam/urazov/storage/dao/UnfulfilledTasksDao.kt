package rustam.urazov.storage.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import rustam.urazov.storage.entity.CompletedTaskEntity
import rustam.urazov.storage.entity.PriorityEntity
import rustam.urazov.storage.entity.TaskEntity
import rustam.urazov.storage.entity.UnfulfilledTaskEntity
import java.util.*

interface UnfulfilledTasksDao {

    @Query(
        "SELECT * " +
                "FROM ${UnfulfilledTaskEntity.UNFULFILLED_TASKS_TABLE}" +
                "JOIN ${TaskEntity.TASKS_TABLE}" +
                "ON ${UnfulfilledTaskEntity.UNFULFILLED_TASKS_TABLE}.taskId = ${TaskEntity.TASKS_TABLE}.taskId" +
                "JOIN ${PriorityEntity.PRIORITIES_TABLE}" +
                "ON ${TaskEntity.TASKS_TABLE}.priorityId = ${PriorityEntity.PRIORITIES_TABLE}.priorityId" +
                "WHERE ${TaskEntity.TASKS_TABLE}.deadline = :deadline"
    )
    suspend fun selectUnfulfilledTasks(deadline: Date): List<Map<UnfulfilledTaskEntity, Map<TaskEntity, PriorityEntity>>>

    @Query(
        "SELECT * " +
                "FROM ${UnfulfilledTaskEntity.UNFULFILLED_TASKS_TABLE}" +
                "JOIN ${TaskEntity.TASKS_TABLE}" +
                "ON ${UnfulfilledTaskEntity.UNFULFILLED_TASKS_TABLE}.taskId = ${TaskEntity.TASKS_TABLE}.taskId" +
                "JOIN ${PriorityEntity.PRIORITIES_TABLE}" +
                "ON ${TaskEntity.TASKS_TABLE}.priorityId = ${PriorityEntity.PRIORITIES_TABLE}.priorityId" +
                "WHERE ${UnfulfilledTaskEntity.UNFULFILLED_TASKS_TABLE}.completedTaskId = :id"
    )
    suspend fun selectUnfulfilledTask(id: Int): Map<UnfulfilledTaskEntity, Map<TaskEntity, PriorityEntity>>

    @Insert
    suspend fun insertUnfulfilledTask(unfulfilledTask: UnfulfilledTaskEntity)

    @Update
    suspend fun updateUnfulfilledTask(unfulfilledTask: UnfulfilledTaskEntity)

    @Delete
    suspend fun deleteUnfulfilledTask(unfulfilledTask: UnfulfilledTaskEntity)

}