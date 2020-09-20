package com.example.shorten.controllers;

import com.example.shorten.services.DBService;
import com.example.shorten.services.QRService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;


@RestController
@RequestMapping("/api/")
public class UIController {

    @Autowired
    Faker faker;

    @Autowired
    public DBService DBService;

    @PostMapping("save_link")
    @CrossOrigin(origins = "*")
    @ResponseBody
    public String saveLink(@RequestParam String link, @RequestParam(required=false) String shortLink) {
        return DBService.saveLink(link, shortLink);
    }

    @GetMapping("kowalski_analysis")
    @CrossOrigin(origins = "*")
    public String getStatistics(@RequestParam String shortLink){
        String substring = shortLink.substring(shortLink.lastIndexOf("/") + 1);
        return DBService.getStatistics(substring);
    }

    @GetMapping(value = "get_QR", produces = MediaType.IMAGE_PNG_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<BufferedImage> getQR(@RequestParam String link) throws Exception {
        BufferedImage bufferedImage = QRService.generateQRCodeImage(link);
        return new ResponseEntity<>(bufferedImage, HttpStatus.OK);
    }

}
