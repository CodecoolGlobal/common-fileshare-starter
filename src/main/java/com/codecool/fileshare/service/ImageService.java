package com.codecool.fileshare.service;

import com.codecool.fileshare.dto.ImageBase64Model;
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

    public ImageBase64Model getImage(String UUIDString){
        UUID search = UUID.fromString(UUIDString);
        String s = Base64.getEncoder().encodeToString(imageRepository.getByteById(search));
        System.out.println(s);
        ImageBase64Model result = new ImageBase64Model(s);
        return result;
    }
    public String storeImage(String category, ImageBase64Model string){
        System.out.println(string.getContent());
        ImageDTO teszt = new ImageDTO(category,
                Base64.getDecoder().decode(string.getContent()),
                getExtension(string.getContent().charAt(0)));
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
