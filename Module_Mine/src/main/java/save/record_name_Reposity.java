package save;

import android.content.Context;

import androidx.lifecycle.LiveData;

public class record_name_Reposity {
    public record_stepDao mDao;
    public record_step mStep;
    record_name_Reposity(Context context){
        database database = save.database.getInstance(context);
        mDao = database.mDao();
    }
    void insert(record_step step){
        database.databaseWriteExecutor.execute(()->mDao.insert(step));
    }
    void updata(record_step step){
        database.databaseWriteExecutor.execute(()->mDao.updata(step));
    }
   record_step getNameId(String name){
         mStep = mDao.getNameId(name);
         return mStep;
    }
    record_step getKeyId(int key){
        mStep = mDao.getKeyId(key);
        return mStep;
    }
}
