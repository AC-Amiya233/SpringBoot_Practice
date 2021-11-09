package com.usrcontrol.usrinfo.controller.admin;

import com.usrcontrol.usrinfo.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UploadDownController {
    @RequestMapping("/upload")
    public Result upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File filePath = new File(path);
        System.out.println("Save path: " + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            filePath.mkdir();
        }
        String originalFileName = picture.getOriginalFilename();
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(d);
        String fileName = date + name + "." + type;
        System.out.println("Save as：" + path + "/" + fileName);
        File targetFile = new File(path, fileName);
        try {
            picture.transferTo(targetFile);
            System.out.println("Upload success");
            return new Result(true,"/upload/" + fileName);
        } catch (IOException e) {
            System.out.println("Upload fail");
            e.printStackTrace();
            return new Result(false, "fail");
        }
    }
}
