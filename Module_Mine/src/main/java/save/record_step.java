package save;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class record_step {
    @PrimaryKey(autoGenerate = true)
    public int key;
    @ColumnInfo
    public String name;//保存名字的
}
