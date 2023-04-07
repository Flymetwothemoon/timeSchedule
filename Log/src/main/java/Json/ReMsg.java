package Json;

import java.io.Serializable;
import java.util.Map;

public class ReMsg implements Serializable {


        private String code; //
        private String error; //
        private Map msgMap; //

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

        public Map getMsgMap(){
            return msgMap;
        }

        public void setMsgMap(Map msgMap){
            this.msgMap = msgMap;
        }

    }

