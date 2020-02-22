package com.example.hp.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
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

    public static String fileToBase64(MultipartFile file) throws IOException {
        String pre ="data:image/png;base64,";
        byte[] data = null;
        InputStream is = file.getInputStream();
        data = new byte[is.available()];
        is.read(data);
        is.close();
        String encode = Base64.getEncoder().encodeToString(data);
        return pre+encode;
    }

}
