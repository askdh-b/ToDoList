package rustam.urazov.storage.dao

import androidx.room.*
import rustam.urazov.storage.entity.PriorityEntity
import rustam.urazov.storage.entity.TaskEntity
import java.util.Date

@Dao
interface TasksDao {

    @Query(
        "SELECT * " +
                "FROM ${TaskEntity.TASKS_TABLE} JOIN ${PriorityEntity.PRIORITIES_TABLE} " +
                "ON ${TaskEntity.TASKS_TABLE}.priorityId = " +
                "${PriorityEntity.PRIORITIES_TABLE}.priorityId " +
                "WHERE deadline = :deadline"
    )
    suspend fun selectTasks(deadline: Date): List<Map<TaskEntity, PriorityEntity>>

    @Query(
        "SELECT * " +
                "FROM ${TaskEntity.TASKS_TABLE} JOIN ${PriorityEntity.PRIORITIES_TABLE} " +
                "ON ${TaskEntity.TASKS_TABLE}.priorityId = " +
                "${PriorityEntity.PRIORITIES_TABLE}.priorityId " +
                "WHERE taskId = :id"
    )
    suspend fun selectTask(id: Int): Map<TaskEntity, PriorityEntity>

    @Insert
    suspend fun insertTask(taskEntity: TaskEntity)

    @Update
    suspend fun updateTask(taskEntity: TaskEntity)

    @Delete
    suspend fun deleteTask(taskEntity: TaskEntity)

}