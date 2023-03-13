package Utils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ResultDTO implements Serializable {
    @SerializedName("name")
    public String name;
    @SerializedName("score")
    public Double score;

    public static ResultDTO objectFromData(String str) {

        return new Gson().fromJson(str, ResultDTO.class);
    }
}
