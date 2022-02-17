package com.codecool.fileshare.service;

import com.codecool.fileshare.dto.ImageDTO;
import com.codecool.fileshare.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;
import java.util.UUID;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String getImage(String UUIDString){
        UUID search = UUID.fromString(UUIDString);
        return DatatypeConverter.printBase64Binary(imageRepository.getById(search).getContent());
    }
    public String storeImage(String category, String string){
        String cleanString = string.substring(3,string.length()-4);
        String newCleanString = cleanString.replaceAll("%2F","/");
        System.out.println(cleanString);
        ImageDTO teszt = new ImageDTO(category,
                (DatatypeConverter.parseBase64Binary(newCleanString)),
                getExtension(string.charAt(0)));
       imageRepository.save(teszt);

       return teszt.getId().toString();
    }

    private String getExtension(char charAt) {
        switch(charAt) {
            case '/': return "jpg";
            case 'i': return "png";
            case 'R': return "gif";
            case 'U':  return "webp";
        }
        return "";
    }
}
