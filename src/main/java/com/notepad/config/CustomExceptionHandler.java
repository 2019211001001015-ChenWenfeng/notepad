package com.notepad.config;


import com.notepad.pojo.Json;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;


import static com.notepad.utils.JsonData.fail;
import static com.notepad.utils.JsonData.success;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public Json handlerMaxUploadFile(MaxUploadSizeExceededException ex){

        if (ex.getCause().getCause() instanceof FileUploadBase.FileSizeLimitExceededException)
            return fail();
        return fail();


    }


}
