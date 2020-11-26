package com.ssafy.happyhouse.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Controller
@RequestMapping("/api")
public class NewsController {
	@GetMapping("/allNews")
    @ResponseBody
    public JSONArray getAll() {
		
        String url = "https://land.naver.com/news/headline.nhn";
        
        Document doc = null;
        Document doc2 = null;
        
        JSONArray jsonArray = new JSONArray();
        
        try {
        	
        	doc = Jsoup.connect(url).get();

        	
        	// 2개 (링크) 
        	Elements elements0 = doc.select("div[class=news_area NE=a:hla]").select("dt").select("a");
        	for (Element element : elements0) {
        		
        		JSONObject jsonObject = new JSONObject();

        		String hrefLink = "https://land.naver.com/" + element.attr("href");
            	System.out.println("link is " + hrefLink);

        		doc2 = Jsoup.connect(hrefLink).get();
        		Elements elem = doc2.select("div[class=article_header]").select("h3"); 
        		
            	String title = elem.text();
        		System.out.println(title);
        		
        		jsonObject.put("title", title);
        		jsonObject.put("url", hrefLink);
        		jsonArray.add(jsonObject);

        	}
        	
        	
        	// 3개 
        	Elements elements = doc.select("div[class=section_headline NE=a:mnn]").select("dt").select("a");
        	
        	int i = 0;
        	for (Element element : elements) {
        		JSONObject jsonObject = new JSONObject();

        		String hrefLink = "https://land.naver.com/" + element.attr("href");
            	String title = element.text();
            	
            	if (i % 2 != 0) {
                	jsonObject.put("title", title);
            		jsonObject.put("url", hrefLink);
            		jsonArray.add(jsonObject);
            	}
            	i ++;
            	if(i == 6) {
            		break;
            	}
        	}
        	
        	
        }catch (IOException e) {
        	e.printStackTrace();
        }
        
        return jsonArray;
        
        
        
    }
}
