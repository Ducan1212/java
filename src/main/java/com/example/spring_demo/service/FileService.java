package com.example.spring_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_demo.model.File;
import com.example.spring_demo.repository.FileRepository;

@Service
public class FileService {
    @Autowired
    FileRepository fileRepository;

    public List<File> getListFile() {
        return fileRepository.getListFile();
    }

    public void insertFile(String name, String path) {
        com.example.spring_demo.model.File file = new File();
        file.setName(name);
        file.setPath(path);
        fileRepository.save(file);
    }
}
