package com.urlshortenerdummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller implements ErrorController {

    @Autowired
    Service service;

    @GetMapping(value = "/")
    public String root(Model model){
        model.addAttribute("sUrl", "Shortener URL will appear here!");
        return "index";
    }

    @GetMapping(value = "/shorten", params = "oUrl")
    public String shorten(@RequestParam String oUrl, Model model){
        String sUrl = service.generateShortUrl(oUrl);
        model.addAttribute("sUrl", sUrl);
        return "index";
    }
}
