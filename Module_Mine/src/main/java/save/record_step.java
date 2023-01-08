package save;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class record_step {
    @PrimaryKey(autoGenerate = true)
    public int num;
    @ColumnInfo
    public String name;//保存名字的
}
