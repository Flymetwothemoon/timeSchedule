package Service;

import com.example.baselibs.LogService;

public class EnterService implements LogService {
    public EnterService(boolean press) {
        this.press = press;
    }

    public boolean press;
    @Override
    public boolean press() {
        return press;
    }
}
