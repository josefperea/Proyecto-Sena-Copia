package com.prueba.prueba_apiN2.controllers;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileController {

    @GetMapping("/uploads/productos/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws MalformedURLException {
        Path filePath = Paths.get("C:/Users/Santiago/Documents/GitHub/Proyecto-Sena-/uploads/productos").resolve(filename);
        Resource file = new UrlResource(filePath.toUri());

        if (file.exists() || file.isReadable()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                    .body(file);
        } else {
            throw new RuntimeException("No se puede leer el archivo: " + filename);
        }
    }
}
