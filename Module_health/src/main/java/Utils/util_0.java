package Utils;

import com.example.module_health.bean.Data;

public class util_0 {
    public static Data exchange(Data data){
        if(data.dayOfWeekend.equals("星期0")){
            data.dayOfWeekend ="星期"+"天";
        }
        if(data.dayOfWeekend.equals("星期1")){
            data.dayOfWeekend ="星期"+"一";
        }
        if(data.dayOfWeekend.equals("星期2")){
            data.dayOfWeekend ="星期"+"二";
        }
        if(data.dayOfWeekend.equals("星期3")){
            data.dayOfWeekend ="星期"+"三";
        }
        if(data.dayOfWeekend.equals("星期4")){
            data.dayOfWeekend ="星期"+"四";
        }
        if(data.dayOfWeekend.equals("星期5")){
            data.dayOfWeekend ="星期"+"五";
        }
        if(data.dayOfWeekend.equals("星期6")){
            data.dayOfWeekend ="星期"+"六";
        }
        return data;
    }
}
