package Service;

import android.app.Application;

import com.example.baselibs.ServiceFactory;

//因为我们并不知道什么时候其他的组件就会在ServiceFactroy中获得这个类，
// 所以我们上传这个接口实现类要在项目刚刚开始的时候，所以就在Mine的application中实现上传。
public class LogApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ServiceFactory.getInstance().setLogService(new EnterService(ServiceUtil.press));
    }
}
