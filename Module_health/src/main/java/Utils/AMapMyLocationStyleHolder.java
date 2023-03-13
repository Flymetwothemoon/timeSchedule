package Utils;

import com.amap.api.maps2d.model.MyLocationStyle;

public class AMapMyLocationStyleHolder {
    public static MyLocationStyle getaMapMyLocationStyleHolder() {
        return aMapMyLocationStyleHolder;
    }

    public static void setaMapMyLocationStyleHolder(MyLocationStyle aMapMyLocationStyleHolder) {
        AMapMyLocationStyleHolder.aMapMyLocationStyleHolder = aMapMyLocationStyleHolder;
    }

    private static MyLocationStyle aMapMyLocationStyleHolder;

}
