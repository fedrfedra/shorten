package com.example.shorten.controllers;


import com.example.shorten.services.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class RedirectController {

    @Autowired
    RedirectService service;

    @GetMapping("/{shortLink}")
    public RedirectView redirectWithUsingRedirectView(
            RedirectAttributes attributes, @PathVariable String shortLink) {
        String substring = shortLink.substring(shortLink.length() - 4, shortLink.length());
        String longLink = service.getLongLink(substring);
        return new RedirectView(longLink);
    }

}
