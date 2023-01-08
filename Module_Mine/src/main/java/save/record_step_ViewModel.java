package save;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class record_step_ViewModel extends AndroidViewModel {
    record_name_Reposity reposity;
    public record_step_ViewModel(@NonNull Application application){
        super(application);
        reposity = new record_name_Reposity(application);
    }
    public void insert(record_step record_step){
        reposity.insert(record_step);
    }
    public void updata(record_step record_step){
        reposity.updata(record_step);
    }
    public record_step getNameId(String name){
        record_step step = reposity.getNameId(name);
        return step;
    }
}
