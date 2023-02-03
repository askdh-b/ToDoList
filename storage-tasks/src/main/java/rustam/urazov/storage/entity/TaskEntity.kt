package rustam.urazov.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import rustam.urazov.core.extension.empty
import java.util.Date

@Entity
data class TaskEntity(
    @PrimaryKey val taskId: Int = 0,
    val title: String = String.empty(),
    val description: String = String.empty(),
    val creationDate: Date = Date(),
    val deadline: Date? = null,
    val priorityId: Int = 0
) {

    companion object {
        const val TASKS_TABLE = "Tasks"
    }

}