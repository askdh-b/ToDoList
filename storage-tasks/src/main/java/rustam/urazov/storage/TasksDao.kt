package rustam.urazov.storage

import androidx.room.Dao
import androidx.room.Query
import java.util.Date

@Dao
interface TasksDao {

    @Query("SELECT * FROM Tasks WHERE ")
    fun getTasks(deadline: Date)

}