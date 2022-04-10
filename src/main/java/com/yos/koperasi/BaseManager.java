package com.yos.koperasi;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

public class BaseManager {

    public ResponseManager isSuccessData(Object data){
        ResponseManager responseManager = new ResponseManager();
        responseManager.setCode(200);
        responseManager.setDescription("success");
        responseManager.setData(data);
        return responseManager;
    }

    public ResponseManager isFailedData(String description){
        ResponseManager responseManager = new ResponseManager();
        responseManager.setCode(500);
        responseManager.setDescription(description);
        return responseManager;
    }
}
