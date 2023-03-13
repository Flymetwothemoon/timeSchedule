package Utils;

import com.amap.api.maps2d.AMap;

public class AMapHolder {
    private static AMap aMap;

    public static void setAMap(AMap map) {
        aMap = map;
    }

    public static AMap getAMap() {
        return aMap;
    }
}
