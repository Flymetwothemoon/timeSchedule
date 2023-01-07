package save;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {record_step.class},version = 7,exportSchema = true)
public abstract class database extends RoomDatabase {
    public static database instance;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(4);
    static database getInstance(final Context context){
        if(instance ==null){
            synchronized (database.class){
                if(instance==null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),database.class,"data1").build();
                }
            }
        }
        return instance;
    }
    public abstract record_stepDao mDao();
}
