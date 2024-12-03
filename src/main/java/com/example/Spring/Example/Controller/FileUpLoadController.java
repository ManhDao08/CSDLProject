package com.example.Spring.Example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.Spring.Example.Models.ResponseObject;
import com.example.Spring.Example.Service.IStorageService;

@Controller
@RequestMapping("/api/v1/FileUpload")
public class FileUpLoadController {

    @Autowired
    IStorageService iStorageService;
    
    @PostMapping("")
    public ResponseEntity<ResponseObject> uploadFile(@RequestParam("file")MultipartFile file) {
        try {
            String storedImageName = iStorageService.storeFile(file);
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, "Upload Successfully", storedImageName)
            );
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject(false, "Upload Failed", "")
            );
        }
    }
}
