package rustam.urazov.storage.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import rustam.urazov.storage.entity.PendingTaskEntity
import rustam.urazov.storage.entity.PriorityEntity
import rustam.urazov.storage.entity.TaskEntity
import rustam.urazov.storage.entity.UnfulfilledTaskEntity
import java.util.*

interface PendingTasksDao {

    @Query(
        "SELECT * " +
                "FROM ${PendingTaskEntity.PENDING_TASKS_TABLE}" +
                "JOIN ${TaskEntity.TASKS_TABLE}" +
                "ON ${PendingTaskEntity.PENDING_TASKS_TABLE}.taskId = ${TaskEntity.TASKS_TABLE}.taskId" +
                "JOIN ${PriorityEntity.PRIORITIES_TABLE}" +
                "ON ${TaskEntity.TASKS_TABLE}.priorityId = ${PriorityEntity.PRIORITIES_TABLE}.priorityId" +
                "WHERE ${TaskEntity.TASKS_TABLE}.deadline = :deadline"
    )
    suspend fun selectPendingTasks(deadline: Date): List<Map<PendingTaskEntity, Map<TaskEntity, PriorityEntity>>>

    @Query(
        "SELECT * " +
                "FROM ${PendingTaskEntity.PENDING_TASKS_TABLE}" +
                "JOIN ${TaskEntity.TASKS_TABLE}" +
                "ON ${PendingTaskEntity.PENDING_TASKS_TABLE}.taskId = ${TaskEntity.TASKS_TABLE}.taskId" +
                "JOIN ${PriorityEntity.PRIORITIES_TABLE}" +
                "ON ${TaskEntity.TASKS_TABLE}.priorityId = ${PriorityEntity.PRIORITIES_TABLE}.priorityId" +
                "WHERE ${PendingTaskEntity.PENDING_TASKS_TABLE}.completedTaskId = :id"
    )
    suspend fun selectPendingTask(id: Int): Map<PendingTaskEntity, Map<TaskEntity, PriorityEntity>>

    @Insert
    suspend fun insertPendingTask(pendingTask: PendingTaskEntity)

    @Update
    suspend fun updatePendingTask(pendingTask: PendingTaskEntity)

    @Delete
    suspend fun deletePendingTask(pendingTask: PendingTaskEntity)

}