package save;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface record_stepDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(record_step record_step);
    @Update
    public void updata(record_step record_step);
    @Query("select * from record_step where name = :name")
    public record_step getNameId(String name);
}
