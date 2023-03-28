package Json;

import java.io.Serializable;

public class LoginToken implements Serializable {
    private String code; //
    private String error; //
    private Object msgMap; //

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getError(){
        return error;
    }

    public void setError(String error){
        this.error = error;
    }

    public Object getMsgMap(){
        return msgMap;
    }

    public void setMsgMap(Object msgMap){
        this.msgMap = msgMap;
    }
}
