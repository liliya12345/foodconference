package com.foodconference.foodconference.controllers;

import com.foodconference.foodconference.models.Image;
import com.foodconference.foodconference.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ImageController {
    private  final ImageRepository imageRepository;
    @GetMapping("/api/v1/image/{id}")
    public ResponseEntity<?> getImageById(@PathVariable Long id){
        Optional<Image> byId = imageRepository.findById(id);
        Image image = byId.orElse(null);
        if(image == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header("fileName",image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));

    }

}
