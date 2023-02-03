package rustam.urazov.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class UnfulfilledTaskEntity(
    @PrimaryKey val unfulfilledTaskId: Int = 0,
    val taskId: Int = 0,
    val date: Date = Date()
) {

    companion object {
        const val UNFULFILLED_TASKS_TABLE = "UnfulfilledTasks"
    }

}