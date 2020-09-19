package com.example.shorten.controllers;

import com.example.shorten.model.Link;
import com.example.shorten.services.DBService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UIController {

    @Autowired
    Faker faker;

    @Autowired
    public DBService DBService;

    @PostMapping("save_link")
    @ResponseBody
    public String saveLink(@RequestParam String link) {
        return DBService.saveLink(link);

    }

    @PostMapping("save_with_custom_link")
    @ResponseBody
    public String saveWithCustomLink(@RequestParam String link) {
//        DBService.saveLink(link);
        return "success";
    }

}
