package com.notepad.config;


import com.notepad.pojo.Json;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

import static com.notepad.utils.JsonData.fail;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public Json uploadException(MaxUploadSizeExceededException e) throws IOException {
       return fail(e);
    }

    @ExceptionHandler(Exception.class)
    public void myexce(Exception e) {
        System.out.println("myexce>>>"+e.getMessage());
    }


}
