package rustam.urazov.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class CompletedTaskEntity(
    @PrimaryKey val completedTaskId: Int = 0,
    val taskId: Int = 0,
    val completionDate: Date = Date()
) {

    companion object {
        const val COMPLETED_TASKS_TABLE = "CompletedTasks"
    }

}