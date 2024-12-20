package com.example.spring_demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    private final String URL = "/home/oem/Project/spring-demo/src/upload/";

    @GetMapping(value = "/upload")
    public String listFileUpload() {
        return "file/list";
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        File convertFile = new File(URL + file.getOriginalFilename());
        convertFile.createNewFile();

        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();

        return "File is uploaded successfully";
    }

    @GetMapping("/download")
    public ResponseEntity<Object> downloadFile() throws IOException {
        String filename = URL + "option.png";
        File file = new File(filename);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        
        ResponseEntity<Object> 
        responseEntity = ResponseEntity.ok().headers(headers).contentLength(
            file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);
        
        return responseEntity;
    }
}
