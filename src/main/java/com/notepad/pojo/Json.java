package com.notepad.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Json<T> {
    private  Integer code;
    private String message;
    private T data;
}
