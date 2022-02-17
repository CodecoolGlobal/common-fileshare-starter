package com.codecool.fileshare.controller;

import com.codecool.fileshare.dto.ImageBase64Model;
import com.codecool.fileshare.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/images")

public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping ("/{category}")
    public String storeImage(@PathVariable("category") String category, @RequestBody ImageBase64Model string){
        return imageService.storeImage(category,string);
    }

    @GetMapping("/{uuid}")
    public ImageBase64Model getImage(@PathVariable("uuid") String uuid){
        return imageService.getImage(uuid);
    }
}
