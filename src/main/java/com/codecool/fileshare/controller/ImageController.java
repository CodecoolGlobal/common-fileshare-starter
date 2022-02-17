package com.codecool.fileshare.controller;

import com.codecool.fileshare.dto.ImageDTO;
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
    public String storeImage(@PathVariable("category") String category, @RequestBody String string){
        return imageService.storeImage(category,string);
    }

    @GetMapping("/{uuid}")
    public String getImage(@PathVariable("uuid") String uuid){
        return imageService.getImage(uuid);
    }
}
