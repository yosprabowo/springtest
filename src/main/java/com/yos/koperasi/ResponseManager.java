package com.yos.koperasi;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseManager<T> {
    private Integer code;
    private String description;
    private T data;

    public Boolean getSuccess(){
        return code == 200;
    }
}
