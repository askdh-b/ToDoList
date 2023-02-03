package rustam.urazov.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import rustam.urazov.core.extension.empty

@Entity
data class PriorityEntity(
    @PrimaryKey val priorityId: Int = 0,
    val name: String = String.empty(),
    val value: Int = 0
) {

    companion object {
        const val PRIORITIES_TABLE = "Priorities"
    }

}