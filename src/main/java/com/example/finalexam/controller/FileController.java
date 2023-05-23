package com.example.finalexam.controller;

import com.example.finalexam.exceptions.ErrorResponse;
import com.example.finalexam.servies.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/files")
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = fileService.loadFileAsResource(filename);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(file);
    }

    @PostMapping("")
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        fileService.store(file);
        return "You successfully uploaded " + file.getOriginalFilename() + "!";
    }

    @DeleteMapping("/{filename:.+}")
    public String deleteFile(@PathVariable String filename) {
        return fileService.deleteFile(filename);
    }

//    @DeleteMapping("/{name}")
//    public void fileDeleteload(@PathVariable String name) {
//        fileService.deleteFile(name);
//    }

//    @ExceptionHandler(FileNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<ErrorResponse> handleFileNotFound(Exception ex, WebRequest request) {
//        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false).substring(4));
//        er.addValidationError("File 1", "error1");
//        er.addValidationError("File 2", "error2");
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
//    }
//
//    @ExceptionHandler(NullPointerException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<ErrorResponse> handleNullPointer(Exception ex, WebRequest request) {
//        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getDescription(false).substring(4));
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
//    }
//
//    @ExceptionHandler(NumberFormatException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<ErrorResponse> handleNumberFormat(Exception ex, WebRequest request) {
//        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getDescription(false).substring(4));
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
//    }
}
