package Utils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;



public class vegetable implements Serializable {
    @SerializedName("log_id")
    public Integer logId;
    @SerializedName("result_num")
    public Integer resultNum;
    @SerializedName("result")
    public List<ResultDTO> result;

    public static vegetable objectFromData(String str) {

        return new Gson().fromJson(str, vegetable.class);
    }
}
