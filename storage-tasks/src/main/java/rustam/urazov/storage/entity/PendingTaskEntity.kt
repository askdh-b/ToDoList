package rustam.urazov.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class PendingTaskEntity(
    @PrimaryKey val pendingTaskId: Int = 0,
    val taskId: Int = 0,
    val oldDate: Date = Date(),
    val newDate: Date = Date()
) {

    companion object {
        const val PENDING_TASKS_TABLE = "PendingTasks"
    }

}