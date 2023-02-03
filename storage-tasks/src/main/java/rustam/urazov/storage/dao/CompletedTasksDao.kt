package rustam.urazov.storage.dao

import androidx.room.*
import rustam.urazov.storage.entity.CompletedTaskEntity
import rustam.urazov.storage.entity.PriorityEntity
import rustam.urazov.storage.entity.TaskEntity
import java.util.*

@Dao
interface CompletedTasksDao {

    @Query(
        "SELECT * " +
                "FROM ${CompletedTaskEntity.COMPLETED_TASKS_TABLE}" +
                "JOIN ${TaskEntity.TASKS_TABLE}" +
                "ON ${CompletedTaskEntity.COMPLETED_TASKS_TABLE}.taskId = ${TaskEntity.TASKS_TABLE}.taskId" +
                "JOIN ${PriorityEntity.PRIORITIES_TABLE}" +
                "ON ${TaskEntity.TASKS_TABLE}.priorityId = ${PriorityEntity.PRIORITIES_TABLE}.priorityId" +
                "WHERE ${TaskEntity.TASKS_TABLE}.deadline = :deadline"
    )
    suspend fun selectCompletedTasks(deadline: Date): List<Map<CompletedTaskEntity, Map<TaskEntity, PriorityEntity>>>

    @Query(
        "SELECT * " +
                "FROM ${CompletedTaskEntity.COMPLETED_TASKS_TABLE}" +
                "JOIN ${TaskEntity.TASKS_TABLE}" +
                "ON ${CompletedTaskEntity.COMPLETED_TASKS_TABLE}.taskId = ${TaskEntity.TASKS_TABLE}.taskId" +
                "JOIN ${PriorityEntity.PRIORITIES_TABLE}" +
                "ON ${TaskEntity.TASKS_TABLE}.priorityId = ${PriorityEntity.PRIORITIES_TABLE}.priorityId" +
                "WHERE ${CompletedTaskEntity.COMPLETED_TASKS_TABLE}.completedTaskId = :id"
    )
    suspend fun selectCompletedTask(id: Int): Map<CompletedTaskEntity, Map<TaskEntity, PriorityEntity>>

    @Insert
    suspend fun insertCompletedTask(completedTask: CompletedTaskEntity)

    @Update
    suspend fun updateCompletedTask(completedTask: CompletedTaskEntity)

    @Delete
    suspend fun deleteCompletedTask(completedTask: CompletedTaskEntity)

}