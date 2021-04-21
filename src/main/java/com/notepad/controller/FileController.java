package com.notepad.controller;

import com.notepad.pojo.Json;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static com.notepad.utils.JsonData.fail;
import static com.notepad.utils.JsonData.success;

@Api(tags={"文件上传的接口"})
@RestController
@RequestMapping("/file")
public class FileController {


    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Json upload(MultipartFile img) throws IOException {

        //处理文件上传

//        String realPath = request.getServletContext().getRealPath("/files");
        String realPath = ResourceUtils.getURL("classpath:").getPath()+"static/files";
        //日期目录创建
        String dateDir = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File dir = new File(realPath,dateDir);
        if(!dir.exists())
            dir.mkdirs();
        //修改文件名
        String newFileNamePrefix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+ UUID.randomUUID().toString();
        String extension = FilenameUtils.getExtension(img.getOriginalFilename());
        String newFileName = newFileNamePrefix + "." + extension;

///文件上传
        img.transferTo(new File(dir,newFileName));
        if(realPath != null)
        {
            return success();
        }else
        {
            return fail();
        }

    }
}
