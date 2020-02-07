package com.example.hp.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class FileUtils {

    public static String upload(MultipartFile file, String path, String fileName) throws Exception {
        String realPath = path + "/" + UUID.randomUUID().toString().replace("-", "")+fileName.substring(fileName.lastIndexOf("."));
        File dest = new File(realPath);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
       file.transferTo(dest);
        return dest.getName();
    }

    public static void delete(String path) {
        File dest = new File(path);
        dest.delete();
    }

}
