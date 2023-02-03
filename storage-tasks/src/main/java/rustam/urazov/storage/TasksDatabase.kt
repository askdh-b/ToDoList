package rustam.urazov.storage

import androidx.room.RoomDatabase
import rustam.urazov.storage.dao.TasksDao

abstract class TasksDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "TasksDb"
    }

    abstract fun getTasksDao(): TasksDao
}