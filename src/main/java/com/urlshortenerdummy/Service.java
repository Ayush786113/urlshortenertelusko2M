package com.urlshortenerdummy;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Service {
    Pattern pattern;
    Matcher matcher;
    Map<String, String> map;
    public Service(){
        map = new HashMap<String, String>();
        String regex = "\\b(?:https|http)?:\\/\\/(?:\\w+\\.)?\\w+\\.\\w+(?:\\/)?";
        pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    }
    public String generateShortUrl(String oUrl){
        if(oUrl.length() == 0)
            return "Insert a URL to shorten!";
        if(map.containsKey(oUrl))
            return map.get(oUrl);
        matcher = pattern.matcher(oUrl);
        if(!matcher.find())
            return "Enter a valid URL to shorten!";
        return createShortUrl(oUrl);
    }
    public String createShortUrl(String oUrl){
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        sb.append("telus.ko/");
        for(int i = 1; i<=9; i+=1){
            sb.append(characters.charAt(new Random().nextInt(characters.length())));
        }
        String sUrl = sb.toString();
        map.put(oUrl, sUrl);
        return sUrl;
    }
}
